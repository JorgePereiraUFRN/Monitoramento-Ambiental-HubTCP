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
            socketSubscriber = new Socket("127.0.0.1", 2002);
            socketUnbscriber = new Socket("127.0.0.1", 2003);
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
