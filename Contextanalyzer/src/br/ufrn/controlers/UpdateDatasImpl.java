package br.ufrn.controlers;

import br.ufrn.services.UpdaterWidget;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class UpdateDatasImpl extends Register implements UpdateDatas, AddUpdaters{
    
   private HashMap<Integer, UpdateDatas> areaWdgets = new HashMap<Integer, UpdateDatas>();
   
   private static UpdateDatasImpl atualizarWidgets;
   
   private static Integer port = 1029;
   public static String address = "rmi://localhost:"+port.toString()+"/Monitoramento";
   
   public static synchronized UpdateDatasImpl getInstance(){
       
       if(atualizarWidgets == null){
           try {
               atualizarWidgets = new UpdateDatasImpl();
           } catch (RemoteException ex) {
               Logger.getLogger(UpdateDatasImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return atualizarWidgets;
   }
   
   private UpdateDatasImpl() throws RemoteException {
       super(address, port);
        try {
            super.register();
        } catch (MalformedURLException ex) {
            Logger.getLogger(UpdateDatasImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     //=====PollutionWidget=====
    
   @Override
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) throws RemoteException {
        
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIndicePoluicao(area, indexPolluition);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) throws RemoteException {
         UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarFluxoDeVeiculos(area, vehicleFlow);
        }
    }

     //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
   @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) throws RemoteException {
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarVelociadeDoVento(area, windSpeed);
        }
        
    }

   @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) throws RemoteException {
       UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizardirecaoDoVento(area, directionWind);
        }
        
    }

   @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) throws RemoteException{
       UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarProbalidadeChuva(area, willRain);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarQuantidadeRuido(Integer area, Integer noise) throws RemoteException {
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeRuido(area, noise);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //======TemperatureWidget=====
    
   @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) throws RemoteException {
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarTemeperatura(area, temperature);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarHumidade(Integer area, Integer humidity) throws RemoteException{
      UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarHumidade(area, humidity);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire) throws RemoteException {
       UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIncidenciaDeIncendio(area, isFire);

        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //=====DumpWidget===
    
   @Override
    public void atualizarQuantidadeLixo(Integer area, Integer content) throws RemoteException {
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeLixo(area, content);
        }else{
            //System.out.println("não existe um areawidget associado à area "+area);
        }
    }

   @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) throws RemoteException {
      UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarAgenteProximo(area, agentNearName);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    @Override
    public void atualizaDistanciaAgente(Integer area, Integer agentDistance) throws RemoteException {
        UpdateDatas atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizaDistanciaAgente(area, agentDistance);
        }else{
            //System.out.println("não existe um pollution widget associado à area "+area);
        }
    }
   
   @Override
    public void AddAtualizadoresWidgets(Integer area, UpdateDatas atualizarWidgetsArea) {
        
        areaWdgets.put(area, atualizarWidgetsArea);
        
    }

    

}
