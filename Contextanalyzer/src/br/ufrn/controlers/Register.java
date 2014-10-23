/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.controlers;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Jorge
 */
public abstract class Register extends UnicastRemoteObject {

    private String url;
    private int port;

    public Register(String url, int port) throws RemoteException {
        this.url = url;
        this.port = port;
    }


    protected void register() throws RemoteException, MalformedURLException{

        java.rmi.registry.LocateRegistry.createRegistry(port);
        Naming.rebind(url, this);

        System.out.println("Registro criado "+url);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}
