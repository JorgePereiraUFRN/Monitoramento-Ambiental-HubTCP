/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensagem.Mensagem;

/**
 *
 * @author jorge
 */
public class UnsubscriberComand extends TratarRequisicao {

    public UnsubscriberComand(Map<String, Map<String, Socket>> subscribers, Socket socket) {
        super(subscribers, socket);
    }

   

    @Override
    public void run() {
        try {
            for (;;) {
                input = new ObjectInputStream(socket.getInputStream());
                Mensagem mensagem = (Mensagem) input.readObject();

                if (mensagem.getCodigo().equals(Mensagem.unsubscriber)) {
                    String topico = mensagem.getValorMensagem();
                    if (subscribers.get(topico) != null) {

                        input.close();
                        
                        subscribers.get(topico).get(socket.getInetAddress().getHostAddress() + ":" + socket.getPort()).close();
                        subscribers.get(topico).remove(socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
                        

                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UnsubscriberComand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UnsubscriberComand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
