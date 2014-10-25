package br.ufrn.simulacao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import br.ufrn.ServidorDeHoras.ServidorHoras;
import br.ufrn.subscriber.Subscriber;


public class SimulacaoSubsicribers {
	
	private String hostName = "localhost";
	private ServidorHoras servidorHoras;

	private String portNum = "8000";
	//private int contthread = 0;
	
	private SimulacaoSubsicribers() throws MalformedURLException,
			RemoteException, NotBoundException {

		String regURL = "rmi://" + hostName + ":" + portNum + "/ServidorHoras";

		servidorHoras = (ServidorHoras) Naming.lookup(regURL);

	}
	
	public void teste1(){
		
		Subscriber subscriber = new Subscriber("isFireMonitor") {
			
			@Override
			public void tratarMensagem(String mensagem) {
				try {
					long hora = servidorHoras.getHora();
					
					System.out.println("Hora teste 1 - subscriber: "+hora);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
	}
		
	
	public void teste3(){
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		int numeroSubscribers = 200;
		AtomicInteger cont = new AtomicInteger(0);
		
		for(int i = 0; i < numeroSubscribers; i++){
			
			Subscriber subscriber = new Subscriber("isFireMonitor") {
				
				@Override
				public void tratarMensagem(String mensagem) {
					
					if ( cont.incrementAndGet() == numeroSubscribers){
						
						try {
							long hora = servidorHoras.getHora();
							
							System.out.println("Hora teste 3 - subscriber: "+hora);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			};
			
		}
		
	}
	


}
