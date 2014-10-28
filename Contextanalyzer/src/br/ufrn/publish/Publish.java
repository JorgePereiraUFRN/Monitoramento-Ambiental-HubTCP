/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.publish;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensagem.Mensagem;

/**
 *
 * @author jorge
 */
public class Publish {

    private Socket socketPublish;
    private Socket socketRegister;
    private String topico;
    private String oldmessage = "";

    public Publish(String topico) {
        this.topico = topico;
        try {
            socketRegister = new Socket("127.0.0.1", 2000);//172.31.18.206
            socketPublish = new Socket("127.0.0.1", 2001);//172.31.18.206
        } catch (UnknownHostException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criarTopico() {
        try {

            ObjectOutputStream output = new ObjectOutputStream(socketRegister.getOutputStream());
            Mensagem mensagem = new Mensagem();
            mensagem.setCodigo(Mensagem.register);
            mensagem.setValorMensagem(topico);

            output.writeObject(mensagem);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void publicar(String notificacao) {
        try {
            if (!oldmessage.equals(notificacao)) {
                ObjectOutputStream output = new ObjectOutputStream(socketPublish.getOutputStream());
                Mensagem mensagem = new Mensagem();
                mensagem.setCodigo(Mensagem.publish);
                mensagem.setValorMensagem(topico + "%" + notificacao);

                output.writeObject(mensagem);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Publish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        Publish publish = new Publish("esportes");

        publish.criarTopico();

        Scanner sc = new Scanner(System.in);

        for (;;) {
            //System.out.println("digite a atualização");
            String t = sc.nextLine();

            publish.publicar(t);
        }

    }
}
