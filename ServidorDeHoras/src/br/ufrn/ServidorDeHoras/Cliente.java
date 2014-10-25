package br.ufrn.ServidorDeHoras;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Cliente {
	
	ServidorHoras servidorHoras;
	
	public Cliente() throws MalformedURLException, RemoteException, NotBoundException {
		String hostName = "localhost";

		String portNum = "8000";

	
		String regURL = "rmi://" + hostName + ":" + portNum
				+ "/ServidorHoras";
		
		servidorHoras = (ServidorHoras) Naming.lookup(regURL);
	}
	
	public Long getHoras() throws RemoteException{
		
		Long hora = servidorHoras.getHora();
		//System.out.println(hora);
		return hora;
		
	}
	
	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException{
		
		Cliente cliente = new Cliente();
		
		//System.out.println(cliente.getHoras());
		
		
	}

}
