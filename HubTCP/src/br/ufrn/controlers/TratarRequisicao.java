/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jorge
 */
public abstract class TratarRequisicao extends Thread{
    
    protected Map<String, Map<String, Socket>> subscribers;
    protected ObjectInputStream input;
    protected Socket socket;

    public TratarRequisicao(Map<String, Map<String, Socket>> subscribers, Socket socket) {
        this.socket = socket;
        this.subscribers = subscribers;
    }
 
    
   
}
