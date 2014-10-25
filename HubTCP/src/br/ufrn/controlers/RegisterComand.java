/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
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
public class RegisterComand extends TratarRequisicao {

    public RegisterComand(Map<String, Map<String, Socket>> subscribers, Socket socket) {
        super(subscribers, socket);
    }

    

    @Override
    public void run() {
        try {
            for (;;) {
                input = new ObjectInputStream(socket.getInputStream());

            //    //System.out.println("RegisterComand tentando registrar topico");
                Mensagem mensagem = (Mensagem) input.readObject();

                if (mensagem.getCodigo().equals(Mensagem.register)) {
                    String topico = mensagem.getValorMensagem();

                    if (subscribers.get(topico) == null) {
                        subscribers.put(topico, new HashMap<String, Socket>());
                     //   //System.out.println("registrando topico " + topico);
                    } else {
                      //  //System.out.println("topico ja existe");
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterComand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegisterComand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
