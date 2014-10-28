package br.ufrn.controlers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import br.ufrn.ServidorDeHoras.ServidorHoras;

public class SimulacaoSensores {

	private AtualizarInformacoesDeContexto atualizar;

	private String hostName = "localhost";//192.168.1.5
	private ServidorHoras servidorHoras;

	private String portNum = "8000";
	private int contthread = 0;
	
	private SimulacaoSensores() throws MalformedURLException,
			RemoteException, NotBoundException {
		atualizar = new ConcreteAtualizarInformacoesDeContexto();

		String regURL = "rmi://" + hostName + ":" + portNum + "/ServidorHoras";

		servidorHoras = (ServidorHoras) Naming.lookup(regURL);

	}

	public void teste1(int area, int fire) throws RemoteException {

		atualizar.atualizarIncidenciaDeIncendio(area, fire);
		long hora = servidorHoras.getHora();

		System.out.println("Teste 1 - Sensor - hora: " + hora);

	}

	public void enviarDado(int op) {

		Random r = new Random();
		int area = r.nextInt(4);
		switch (op) {
		case 1:
			atualizar.atualizarAgenteProximo(area, "agente" + area);
			break;
		case 2:
			atualizar.atualizardirecaoDoVento(area, "norte");
			break;
		case 3:
			atualizar.atualizarDistanciaAgente(area, r.nextInt(5));
			break;
		case 4:
			atualizar.atualizarFluxoDeVeiculos(area, r.nextInt(70));
			break;
		case 5:
			atualizar.atualizarHumidade(area, r.nextInt(100));
			break;
		case 6:
			atualizar.atualizarIndicePoluicao(area, 150);
			break;
		case 7:
			atualizar.atualizarProbalidadeChuva(area, r.nextInt(100));
			break;

		case 8:
			atualizar.atualizarQuantidadeLixo(area, r.nextInt(100));
			break;
		case 9:
			atualizar.atualizarProbalidadeChuva(area, r.nextInt(100));
			break;
		case 10:
			atualizar.atualizarQuantidadeLixo(area, r.nextInt(250));
			break;
		case 11:
			atualizar.atualizarQuantidadeRuido(area, r.nextInt(70));
		case 12:
			atualizar.atualizarTemeperatura(area, r.nextInt(100));
		case 13:
			atualizar.atualizarVelociadeDoVento(area, r.nextInt(60));

		case 14:
			atualizar.atualizarIncidenciaDeIncendio(area, 0);

		default:
			break;
		}

	}

	public void teste2() {
		
		
		ExecutorService executor = Executors.newCachedThreadPool();

		long inicio = System.currentTimeMillis();
		
		for (int i = 0; i < 1005; i++) {
			
			if(i % 100 == 0){
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			executor.execute(new Runnable() {

				@Override
				public void run() {

					enviarDado(new Random().nextInt(14));
					
					if(contthread++ % 100 == 0){
					System.out.println( contthread +" "+ (System.currentTimeMillis() - inicio));
					}

				}
			});
		}
		
		
	
		

	}

	public void teste3() throws RemoteException {
		ExecutorService executor = Executors.newCachedThreadPool();

		long inicio = System.currentTimeMillis();
		AtomicInteger cont  = new AtomicInteger(0);
		
		for (int i = 0; i < 1005; i++) {
			
			if(i % 100 == 0){
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			executor.execute(new Runnable() {

				@Override
				public void run() {

					enviarDado(new Random().nextInt(13));
					cont.incrementAndGet();

				}
			});
		}
		
		new Thread(new Runnable() {
			public void run() {
				
				if(cont.get() >= 999){
					
					try {
						atualizar.atualizarIncidenciaDeIncendio(1, 1);
						long hora;
						hora = servidorHoras.getHora();
						System.out.println("tempo de execução das threads :"+ (System.currentTimeMillis() -  inicio));
						System.out.println("hora teste 3 - Sensor :"+hora);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}else{
					try {
						Thread.sleep(5);
						this.run();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();;

		
	}

	public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException {
		
		SimulacaoSensores simulacao = new SimulacaoSensores();
	
		/*
		simulacao.teste1(2,0);
		simulacao.teste1(3,0);
		simulacao.teste1(4,0);*/
	
		simulacao.teste3();
		
		//simulacao.teste2();

	}

}
