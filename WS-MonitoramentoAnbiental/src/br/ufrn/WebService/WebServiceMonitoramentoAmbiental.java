/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.WebService;

import br.ufrn.controlers.AtualizarWidgetsRMI;
import br.ufrn.controlers.Reference;
import java.rmi.RemoteException;
import javax.activation.MimeType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jorge
 */
@Path("monitoramento_ambiental")
public class WebServiceMonitoramentoAmbiental {
    
//    private InstanciaWidget widget;
//    private final AtualizarWidgets atualizarWidgets = ConcreteAtualizarWidgets.getInstance();
//    
//    private MonitorCidade monitorCidade = MonitorCidade.getInstance();

    private AtualizarWidgetsRMI atualizarWidgets = new Reference().getReference("rmi://localhost:1029/Monitoramento");
    /**
     * Creates a new instance of WebServiceMonitoramentoAmbiental
     */
    public WebServiceMonitoramentoAmbiental() {
//        this.widget = new InstanciaWidget();
//        monitorCidade.setVisible(true);
    }
    
 
    //=====PollutionWidget=====
    @POST
    @Path("/atualizar_indice_poluicao/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarindicePoluicao(@PathParam("area") int area, String indexPolluition) throws RemoteException {
       atualizarWidgets.atualizarIndicePoluicao(area, Integer.parseInt(indexPolluition));
        System.out.println(area+" indice poluição "+indexPolluition);
    }
    
    @POST
    @Path("/atualizar_fluxo_veiculos/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarFluxoDeVeiculos(@PathParam("area") int area, String vehicleFlow) throws RemoteException {
         atualizarWidgets.atualizarFluxoDeVeiculos(area, Integer.parseInt(vehicleFlow));
        System.out.println(area+" fluxo de veiculos  "+vehicleFlow);
    }

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    @POST
    @Path("/atualizar_velocidade_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarVelociadeDoVento(@PathParam("area") int area, String windSpeed) throws RemoteException {
        atualizarWidgets.atualizarVelociadeDoVento(area, Integer.parseInt(windSpeed));
        System.out.println(area+"  velocidade do vento "+windSpeed);
    }
    
    @POST
    @Path("/atualizar_direcao_vento/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizardirecaoDoVento(@PathParam("area") int area, String directionWind) throws RemoteException {
       atualizarWidgets.atualizardirecaoDoVento(area, directionWind);
        System.out.println(area+"  direção do vento "+directionWind);
    }
    
    @POST
    @Path("/atualizar_probabilidade_chuva/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarProbalidadeChuva(@PathParam("area") int area, String willRain) throws RemoteException {
       atualizarWidgets.atualizarProbalidadeChuva(area, Integer.parseInt(willRain));
        System.out.println(area+" vai chover "+willRain);
    }
    
    @POST
    @Path("/atualizar_quantidade_ruido/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeRuido(@PathParam("area") int area, String noise) throws RemoteException {
        atualizarWidgets.atualizarQuantidadeRuido(area, Integer.parseInt(noise));
        System.out.println(area+" quantidade de ruido  "+noise);
    }

    //======TemperatureWidget=====
    @POST
    @Path("/atualizar_temperatura/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarTemeperatura(@PathParam("area") int area, String temperature) throws RemoteException {
        atualizarWidgets.atualizarTemeperatura(area, Integer.parseInt(temperature));
        System.out.println(area+" temperatura "+temperature);
    }
    
    @POST
    @Path("/atualizar_humidade/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarHumidade(@PathParam("area") int area, String humidity) throws RemoteException {
        atualizarWidgets.atualizarHumidade(area, Integer.parseInt(humidity));
        System.out.println(area+" humidade do ar "+humidity);
    }
    
    @POST
    @Path("/atualizar_incidencia_incendio/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarIncidenciaDeIncendio(@PathParam("area") int area, String isFire) throws RemoteException {
        atualizarWidgets.atualizarIncidenciaDeIncendio(area, Integer.parseInt(isFire));
        System.out.println(area+" fogo "+isFire);
    }

    //=====DumpWidget===
    @POST
    @Path("/atualizar_quantidade_lixo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarQuantidadeLixo(@PathParam("area") int area, String trash) throws RemoteException {
        atualizarWidgets.atualizarQuantidadeLixo(area, Integer.parseInt(trash));
        System.out.println(area+" lixo "+trash);
    }
    
    @POST
    @Path("/atualizar_agente_proximo/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarAgenteProximo(@PathParam("area") int area, String agentNearName) throws RemoteException {
       atualizarWidgets.atualizarAgenteProximo(area, agentNearName);
       System.out.println(area+"  agente proximo "+agentNearName);
    }
    
    @POST
    @Path("/atualizar_distancia_agente/{area}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizaDistanciaAgente(@PathParam("area") int area, String agentDistance) throws RemoteException {
       atualizarWidgets.atualizaDistanciaAgente(area, Integer.parseInt(agentDistance));
       System.out.println(area+"  distancia proximo "+agentDistance);
    }
}
