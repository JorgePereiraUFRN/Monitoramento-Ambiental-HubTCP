package br.ufrn.ServidorDeHoras;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConcreteServidorDeHoras extends UnicastRemoteObject implements ServidorHoras{

	protected ConcreteServidorDeHoras() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getHora() throws RemoteException {
		return System.currentTimeMillis();
	}

}
