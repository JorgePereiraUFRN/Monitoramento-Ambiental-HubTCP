package br.ufrn.ServidorDeHoras;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorHoras extends Remote{
	
	Long getHora() throws RemoteException;

}
