/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

import br.ufrn.controlers.AtualizarWidgetsRMI;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class MonitoramentoArea implements AtualizarWidgetsRMI {

    private Widget areaIN;
    private Enactor areaEnactor;
    

    public MonitoramentoArea(Integer area) {

        areaIN = WidgetXmlParser.createWidget("Informa/area-widget-input_" + area.toString() + ".xml");
       
        areaIN.updateData("area", area);
        areaIN.updateData("indexPollution", -100);
        areaIN.updateData("vehicleFlow", -100);
        areaIN.updateData("directionWind", "norte");
        areaIN.updateData("willRain", -100);
        areaIN.updateData("noise", -100);
        areaIN.updateData("temperature", -300);
        areaIN.updateData("humidity", -100);
        areaIN.updateData("windSpeed", -100);
        areaIN.updateData("content", -100);
        areaIN.updateData("agentNearName", "agente 1");
        areaIN.updateData("agentDistance", -100);
    
        //Enactors
        areaEnactor = EnactorXmlParser.createEnactor("Informa/area-enactor_" + area.toString() + ".xml");

    }

    @Override
    public void atualizarQuantidadeLixo(Integer area, Integer content) {
        areaIN.updateData("content", content);
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        areaIN.updateData("agentNearName", agentNearName);
    }

    @Override
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) {
        areaIN.updateData("indexPollution", indexPolluition);
    }

    @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) {
        areaIN.updateData("vehicleFlow", vehicleFlow);
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) {
        areaIN.updateData("windSpeed", windSpeed);
    }

    @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        areaIN.updateData("directionWind", directionWind);
    }

    @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) {
        areaIN.updateData("willRain", willRain);
    }

    @Override
    public void atualizarQuantidadeRuido(Integer area, Integer noise) {
        areaIN.updateData("noise", noise);
    }

    @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) {
        areaIN.updateData("temperature", temperature);
    }

    @Override
    public void atualizarHumidade(Integer area, Integer humidity) {
        areaIN.updateData("humidity", humidity);
    }

    @Override
    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire) {
        areaIN.updateData("isFire", isFire);
        //System.out.println("======== atualizando fogo =======");
    }

    @Override
    public void atualizaDistanciaAgente(Integer area, Integer agentDistance) throws RemoteException {
        areaIN.updateData("agentDistance", agentDistance);
    }
    

 
}
