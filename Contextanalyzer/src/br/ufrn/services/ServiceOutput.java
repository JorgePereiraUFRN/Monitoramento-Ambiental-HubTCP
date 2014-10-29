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
    
    private Widget outputWidget;
    private InformaService informaService;

    public ServiceOutput() {
        //OUT Widgets and Service
        outputWidget = WidgetXmlParser.createWidget("Context/output-widget.xml");

        informaService = new InformaService(outputWidget/*, monitor*/);
        outputWidget.addService(informaService);
        
    }
    
    
    
}
