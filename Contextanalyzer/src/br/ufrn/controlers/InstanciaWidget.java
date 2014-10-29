/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import br.ufrn.services.UpdaterWidget;
import br.ufrn.services.ServiceOutput;
import context.arch.discoverer.Discoverer;


public class InstanciaWidget {
    
    private final UpdaterWidget ma1;
    private final UpdaterWidget ma2;
    private final UpdaterWidget ma3;
    private final UpdaterWidget ma4;
   
      
    private static InstanciaWidget INSTANCIA_WIDGET;

    public static InstanciaWidget getInstance() {

        if (INSTANCIA_WIDGET == null) {
            INSTANCIA_WIDGET = new InstanciaWidget();
        }
        return INSTANCIA_WIDGET;
    }
    
    AddUpdaters atualizador = UpdateDatasImpl.getInstance();
    
    public InstanciaWidget(){
    	
    	Discoverer.start();
        
        //System.out.println("Inicializando componentes...");
       
        ma1 = new UpdaterWidget(1);
        ma2 = new UpdaterWidget(2);
        ma3 = new UpdaterWidget(3);
        ma4 = new UpdaterWidget(4);
        
        new ServiceOutput();
       
        atualizador.AddAtualizadoresWidgets(1, ma1);
        atualizador.AddAtualizadoresWidgets(2, ma2);
        atualizador.AddAtualizadoresWidgets(3, ma3);
        atualizador.AddAtualizadoresWidgets(4, ma4);
        
        System.out.println("Componentes inicializados com sucesso!");
        
    }
    
    
}
