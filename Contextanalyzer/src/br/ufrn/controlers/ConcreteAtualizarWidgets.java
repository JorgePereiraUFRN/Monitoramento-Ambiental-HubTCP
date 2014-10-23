package br.ufrn.controlers;

import br.ufrn.services.MonitoramentoArea;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class ConcreteAtualizarWidgets extends Register implements AtualizarWidgetsRMI, AddAtualizadores{
    
   private HashMap<Integer, AtualizarWidgetsRMI> areaWdgets = new HashMap<Integer, AtualizarWidgetsRMI>();
   
   private static ConcreteAtualizarWidgets atualizarWidgets;
   
   private static Integer port = 1029;
   public static String address = "rmi://localhost:"+port.toString()+"/Monitoramento";
   
   public static ConcreteAtualizarWidgets getInstance(){
       
       if(atualizarWidgets == null){
           try {
               atualizarWidgets = new ConcreteAtualizarWidgets();
           } catch (RemoteException ex) {
               Logger.getLogger(ConcreteAtualizarWidgets.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return atualizarWidgets;
   }
   
   public ConcreteAtualizarWidgets() throws RemoteException {
       super(address, port);
        try {
            super.register();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ConcreteAtualizarWidgets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //=====PollutionWidget=====
    
   @Override
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) throws RemoteException {
        
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIndicePoluicao(area, indexPolluition);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) throws RemoteException {
         AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarFluxoDeVeiculos(area, vehicleFlow);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

     //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
   @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) throws RemoteException {
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarVelociadeDoVento(area, windSpeed);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) throws RemoteException {
       AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizardirecaoDoVento(area, directionWind);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) throws RemoteException{
       AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarProbalidadeChuva(area, willRain);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarQuantidadeRuido(Integer area, Integer noise) throws RemoteException {
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeRuido(area, noise);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //======TemperatureWidget=====
    
   @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) throws RemoteException {
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarTemeperatura(area, temperature);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarHumidade(Integer area, Integer humidity) throws RemoteException{
      AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarHumidade(area, humidity);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire) throws RemoteException {
       AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIncidenciaDeIncendio(area, isFire);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //=====DumpWidget===
    
   @Override
    public void atualizarQuantidadeLixo(Integer area, Integer content) throws RemoteException {
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeLixo(area, content);
        }else{
            System.out.println("não existe um areawidget associado à area "+area);
        }
    }

   @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) throws RemoteException {
      AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarAgenteProximo(area, agentNearName);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    @Override
    public void atualizaDistanciaAgente(Integer area, Integer agentDistance) throws RemoteException {
        AtualizarWidgetsRMI atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizaDistanciaAgente(area, agentDistance);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }
   
   @Override
    public void AddAtualizadoresWidgets(Integer area, AtualizarWidgetsRMI atualizarWidgetsArea) {
        
        areaWdgets.put(area, atualizarWidgetsArea);
        
    }

    

}
