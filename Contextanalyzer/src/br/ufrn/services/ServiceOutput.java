/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;

/**
 *
 * @author Jorge
 */
public class ServiceOutput {
    
    private Widget informaOUT;
    private InformaService informaService;

    public ServiceOutput() {
        //OUT Widgets and Service
        informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");

        informaService = new InformaService(informaOUT/*, monitor*/);
        informaOUT.addService(informaService);
        
    }
    
    
    
}
