/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.subscriber;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensagem.Mensagem;

/**
 *
 * @author jorge
 */
public abstract class Subscriber extends TratarMensagem{
    
    public Socket socketSubscriber;
    public Socket socketUnbscriber;
    private String topico;
    private EsperarAtualizacoes esperarAtualizacoes;

    public Subscriber(String topico) {
        this.topico = topico;
        try {
            socketSubscriber = new Socket("localhost", 2002);//54.94.145.201
            socketUnbscriber = new Socket("localhost", 2003);//54.94.145.201
        } catch (UnknownHostException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void subscribe(){
        
        Mensagem mensagem = new Mensagem();
        mensagem.setCodigo(Mensagem.subscriber);
        mensagem.setValorMensagem(topico);
        try {
            ObjectOutputStream output = new ObjectOutputStream(socketSubscriber.getOutputStream());
            
            output.writeObject(mensagem);
            
           esperarAtualizacoes = new EsperarAtualizacoes(socketSubscriber, this);
           esperarAtualizacoes.start();
        } catch (IOException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void unsubscribe(){
        Mensagem mensagem = new Mensagem();
        mensagem.setCodigo(Mensagem.unsubscriber);
        mensagem.setValorMensagem(topico);
        try {
            ObjectOutputStream output = new ObjectOutputStream(socketUnbscriber.getOutputStream());
            
            output.writeObject(mensagem);          
            
            esperarAtualizacoes.finalize();
            socketUnbscriber.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

 
    
    
}
