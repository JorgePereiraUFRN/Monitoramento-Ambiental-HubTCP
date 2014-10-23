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
public class subscriberComand extends TratarRequisicao {

    public subscriberComand(Map<String, Map<String, Socket>> subscribers, Socket socket) {
        super(subscribers, socket);
    }

    
    @Override
    public void run() {
        try {
            for (;;) {
                input = new ObjectInputStream(socket.getInputStream());
                Mensagem mensagem = (Mensagem) input.readObject();

                if (mensagem.getCodigo().equals(Mensagem.subscriber)) {
                    String topico = mensagem.getValorMensagem();
                    if (subscribers.get(topico) != null) {
                        subscribers.get(topico).put(socket.getInetAddress().getHostAddress() + ":" + socket.getPort(), socket);
                        System.out.println("inserindo subscriber " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
                    }
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(subscriberComand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(subscriberComand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
