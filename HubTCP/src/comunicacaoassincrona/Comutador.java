/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacaoassincrona;

import br.ufrn.controlers.TratarRequisicao;
import br.ufrn.controlers.PublishComand;
import br.ufrn.controlers.RegisterComand;
import br.ufrn.controlers.UnsubscriberComand;
import br.ufrn.controlers.subscriberComand;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensagem.Mensagem;

/**
 *
 * @author jorge
 */
public class Comutador {

    private ServerSocket ServerSocketRegister, ServerSocketSubscriber,
            ServerSocketUnsubscriber, ServerSocketPublish;
    private Map<String, Map<String, Socket>> subscribers = Collections.synchronizedMap(new HashMap<String, Map<String, Socket>>());

    public Comutador() {
        try {
            ServerSocketRegister = new ServerSocket(2000);
            ServerSocketPublish = new ServerSocket(2001);
            ServerSocketSubscriber = new ServerSocket(2002);
            ServerSocketUnsubscriber = new ServerSocket(2003);

          
        } catch (IOException ex) {
            Logger.getLogger(Comutador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void iniciar() {

        new RequisicaoPublish(ServerSocketPublish).start();
        new RequisicaoRegister(ServerSocketRegister).start();
        new RequisicaoSubscriber(ServerSocketSubscriber).start();
        new RequisicaoUnsubscriber(ServerSocketUnsubscriber).start();
       

    }

    private class RequisicaoSubscriber extends Thread {

        private ServerSocket serverSocket;

        public RequisicaoSubscriber( ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }


        @Override
        public void run() {
            for (;;) {
                try {
                    new subscriberComand(subscribers, serverSocket.accept()).start();
                } catch (IOException ex) {
                    Logger.getLogger(Comutador.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }
    }
    
    
    private class RequisicaoUnsubscriber extends Thread{
        
        private ServerSocket serverSocket;

        public RequisicaoUnsubscriber(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }
        
         @Override
        public void run() {
             for(;;){
                try {
                    new UnsubscriberComand(subscribers, serverSocket.accept()).start();
                } catch (IOException ex) {
                    Logger.getLogger(Comutador.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
         }
        
    }
    
    private class RequisicaoRegister extends Thread{
         private ServerSocket serverSocket;

        public RequisicaoRegister(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }
        
         @Override
        public void run() {
             for(;;){
            try {
                new RegisterComand(subscribers, serverSocket.accept()).start();
            } catch (IOException ex) {
                Logger.getLogger(Comutador.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
         }
    }
    
    private class RequisicaoPublish extends Thread{
        private ServerSocket serverSocket;

        public RequisicaoPublish(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }
        
         @Override
        public void run() {
             for(;;){
            try {
                new PublishComand(subscribers, serverSocket.accept()).start();
            } catch (IOException ex) {
                Logger.getLogger(Comutador.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         }
         }
    
}
