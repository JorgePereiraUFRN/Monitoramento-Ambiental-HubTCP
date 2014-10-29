/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensagem.Mensagem;

/**
 *
 * @author jorge
 */
public class PublishComand extends TratarRequisicao {

	public PublishComand(Map<String, Map<String, Socket>> subscribers,
			Socket socket) {
		super(subscribers, socket);
	}

	@Override
	public void run() {
		try {
			for (;;) {

				input = new ObjectInputStream(socket.getInputStream());

				Mensagem mensagem = (Mensagem) input.readObject();
				if (mensagem.getCodigo().equals(Mensagem.publish)) {

					String[] v = mensagem.getValorMensagem().split("%");

					enviarAtualizacao(
							subscribers.get(v[0]).values().iterator(), v[1]);
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PublishComand.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PublishComand.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	private void enviarAtualizacao(Iterator<Socket> sockets, String atualizacao) {

		
		while (sockets.hasNext()) {
			ObjectOutputStream output = null;
			try {
				Socket s = sockets.next();
				output = new ObjectOutputStream(s.getOutputStream());

				output.writeObject(atualizacao);
			} catch (IOException ex) {
				Logger.getLogger(PublishComand.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

	}
}
