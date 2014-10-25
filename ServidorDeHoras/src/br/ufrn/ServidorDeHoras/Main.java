package br.ufrn.ServidorDeHoras;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Main {
	
	public static void main(String[] args) {
		String portNum, registryURL;
		try {
			
			int RMIPortNum = 8000;
			startRegistry(RMIPortNum);
			ServidorHoras exportedObj = new ConcreteServidorDeHoras();
			registryURL = "rmi://localhost:" + RMIPortNum + "/ServidorHoras";
			Naming.rebind(registryURL, exportedObj);
			
			//System.out.println("Servidor de Horas iniciado!");
			
		} catch (Exception re) {
			re.printStackTrace();
			//System.out.println("Exception: " + re);
		}

	}

	private static void startRegistry(int RMIPortNum) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(RMIPortNum);
			registry.list();
		} catch (RemoteException e) {
			// No valid registry at that port.
			Registry registry = LocateRegistry.createRegistry(RMIPortNum);
		}
	} // end startRegistry
}
