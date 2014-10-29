/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

import br.ufrn.controlers.UpdateDatas;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.intelligibility.test.WidgetUtils;
import context.arch.storage.Attributes;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class UpdaterWidget implements UpdateDatas {

    private Widget noise, noise2;
    private Widget fire;
    private Widget trash;
    private Widget weather;
    private Widget vehicles;
    
    private Enactor noiseEnactor;  
    private Enactor fireEnactor;
    private Enactor trashEnactor;
    private Enactor weatherEnactor;
    private Enactor vehiclesEnactor;
    

    public UpdaterWidget(Integer area) {

        noise = WidgetXmlParser.createWidget("Context/barulho-widget.xml");  //area"+area+"/
        
        noise.updateData("area", area);
        noise.updateData("noise", -100);
        
        fire = WidgetXmlParser.createWidget("Context/fogo-widget.xml");
        fire.setId(fire.getId()+area);
        fire.updateData("area", area);
        fire.updateData("isFire", 0);
        
        trash = WidgetXmlParser.createWidget("Context/lixo-widget.xml");
        
        trash.updateData("area", area);
        trash.updateData("content", -100);
        trash.updateData("agentNearName", "agente 1");
        trash.updateData("agentDistance", -100);
        
        weather = WidgetXmlParser.createWidget("Context/tempo-widget.xml");
        weather.updateData("area", area);  
        weather.updateData("indexPollution", -100);
        weather.updateData("directionWind", "norte");
        weather.updateData("willRain", -100);
        weather.updateData("temperature", -300);
        weather.updateData("humidity", -100);
        weather.updateData("windSpeed", -100);
        
        vehicles = WidgetXmlParser.createWidget("Context/veiculos-widget.xml");
        vehicles.updateData("area", area);  
        vehicles.updateData("vehicleFlow", -100);

    
        //Enactors
        noiseEnactor = EnactorXmlParser.createEnactor("Context/barulho-enactor.xml");
        fireEnactor = EnactorXmlParser.createEnactor("Context/fogo-enactor.xml");
        trashEnactor = EnactorXmlParser.createEnactor("Context/lixo-enactor.xml");
        weatherEnactor = EnactorXmlParser.createEnactor("Context/tempo-enactor.xml");
        vehiclesEnactor = EnactorXmlParser.createEnactor("Context/veiculos-enactor.xml");


    }

    @Override
    public void atualizarQuantidadeLixo(Integer area, Integer content) {
        trash.updateData("content", content);
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        trash.updateData("agentNearName", agentNearName);
    }

    @Override
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) {
        weather.updateData("indexPollution", indexPolluition);
    }

    @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) {
        vehicles.updateData("vehicleFlow", vehicleFlow);
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) {
        weather.updateData("windSpeed", windSpeed);
    }

    @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        weather.updateData("directionWind", directionWind);
    }

    @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) {
        weather.updateData("willRain", willRain);
    }

    
    @Override
    public void atualizarQuantidadeRuido(Integer area, Integer n) {
        noise.updateData("noise", n);
    }

    @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) {
        weather.updateData("temperature", temperature);
    }

    @Override
    public void atualizarHumidade(Integer area, Integer humidity) {
        weather.updateData("humidity", humidity);
    }

    @Override
    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire) {
        fire.updateData("isFire", isFire);
    }

    @Override
    public void atualizaDistanciaAgente(Integer area, Integer agentDistance) throws RemoteException {
        trash.updateData("agentDistance", agentDistance);
    }   

 
}
