/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.subscriber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class EsperarAtualizacoes extends Thread{
    
    private Socket socket;
    private  ObjectInputStream input;
    private TratarMensagem tratarMensagem;

    public EsperarAtualizacoes(Socket socket, TratarMensagem tratarMensagem) {
        this.socket = socket;
        this.tratarMensagem = tratarMensagem;
    }
    
    @Override
    public void run(){
        
        for(;;){
            try {
                input = new ObjectInputStream(socket.getInputStream());
                String mensagem = (String) input.readObject();
                tratarMensagem.tratarMensagem(mensagem);
                
//                Date data = new Date(System.currentTimeMillis());
//                //System.out.println("mensagem recebida: "+mensagem+"\n"+data);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EsperarAtualizacoes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EsperarAtualizacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
    }
    
    @Override
    public void finalize(){
        try {
            super.stop();
            socket.close();
            super.finalize();
        } catch (IOException ex) {
            Logger.getLogger(EsperarAtualizacoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(EsperarAtualizacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
