/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

//import br.ufrn.interfaces.AtualizacoesLixeira;

import br.ufrn.publish.Publish;
import context.arch.comm.DataObject;
import context.arch.service.Service;
import context.arch.service.helper.FunctionDescription;
import context.arch.service.helper.FunctionDescriptions;
import context.arch.service.helper.ServiceInput;
import context.arch.widget.Widget;

import java.util.HashMap;
import java.util.Iterator;


public class InformaService extends Service {
    
    public static final String SERVICE = "informaService";
	
    public static final String POLLUTION = "pollutionMonitor";
    public static final String WILL_RAIN = "willRainMonitor";
    public static final String ACID_RAIN = "acidRainMonitor";
    public static final String NOISE = "noiseMonitor";
    public static final String TEMPERATURE = "temperatureMonitor";
    public static final String BEAUTIFUL_WEATHER = "beautifulWeatherMonitor";
    public static final String IS_FIRE = "isFireMonitor";
    public static final String HOT_DRY = "hotDryMonitor";
    public static final String TRASH = "trashMonitor";
    public static final String GATHERING = "trashGathering";
    
    
    private HashMap<String, Publish> publishs = new HashMap<String, Publish>();
    
    private void criarTopicos(){
        
        publishs.put(POLLUTION, new Publish(POLLUTION));
        publishs.put(WILL_RAIN, new Publish(WILL_RAIN));
        publishs.put(ACID_RAIN, new Publish(ACID_RAIN));
        publishs.put(NOISE, new Publish(NOISE));
        publishs.put(TEMPERATURE, new Publish(TEMPERATURE));
        publishs.put(BEAUTIFUL_WEATHER, new Publish(BEAUTIFUL_WEATHER));
        publishs.put(IS_FIRE, new Publish(IS_FIRE));
        publishs.put(HOT_DRY, new Publish(HOT_DRY));
        publishs.put(TRASH, new Publish(TRASH));
        publishs.put(GATHERING, new Publish(GATHERING));
        
        Iterator<Publish> pIterator = publishs.values().iterator();
        
        while(pIterator.hasNext()){
            Publish p = pIterator.next();
            p.criarTopico();
        }
        
        
    }
    
       
            @SuppressWarnings("serial")
            public InformaService(final Widget widget) {
                    super(widget, SERVICE,
                                    new FunctionDescriptions() {
                            { // constructor
                                    // POLLUTION FUNCTIONS
                                    add(new FunctionDescription(
                                                    POLLUTION, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                    add(new FunctionDescription(
                                                    WILL_RAIN, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                    add(new FunctionDescription(
                                                    ACID_RAIN,
                                                    "avisa sobre possibilidade de chuva acida.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    NOISE,
                                                    "avisa sobre barulhos muito altos em faixas de horários proibidos.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   // TEMPERATURE FUNCTIONS
                                   add(new FunctionDescription(
                                                    TEMPERATURE,
                                                    "mostra a temperatura.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    BEAUTIFUL_WEATHER,
                                                    "mostra a temperatura aparente (sensação térmica).",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    IS_FIRE,
                                                    "avisa se existe algum incêndios.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    HOT_DRY,
                                                    "chama o service de coleta.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   // DUMP FUNCTIONS
                                   add(new FunctionDescription(
                                                    TRASH,
                                                    "mostra o nível de lixo da lixeira e avisa quando a lixeira esta bem próxima de encher.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    GATHERING,
                                                    "chama um agente de coleta mais próximo.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                            }
                    });
                    
                    criarTopicos();

            }

            @Override
             public DataObject execute(ServiceInput serviceInput) {
                    
                   String functionName = serviceInput.getFunctionName(); 
                   //System.out.println("função "+functionName+"\n");
                    
                    /**
                     *POLLUTION FUNCTIONS
                     */
                                       
                    //Index Pollution
                    if (functionName.equals(POLLUTION)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
 
                        //Publisher excession
                        Publish p = publishs.get(POLLUTION);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+POLLUTION);
                        }
                            
                    }   
                   
                    //Will Rain
                    else if (functionName.equals(WILL_RAIN)) {
                    	
                    	 
                        String context = serviceInput.getInput().getAttributeValue("area");
                        
                       
                       
                        //Publisher excession
                        Publish p = publishs.get(WILL_RAIN);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+WILL_RAIN);
                        }
                        
                    }
                    
                    //Acid Rain
                    else if (functionName.equals(ACID_RAIN)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
                        //Publisher excession
                        Publish p = publishs.get(ACID_RAIN);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+ACID_RAIN);
                        }
                    }
                    
                    //Noise
                    else if (functionName.equals(NOISE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");

                        //Publisher excession
                        Publish p = publishs.get(NOISE);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+NOISE);
                        }
                    }
                    
                    /**
                     *TEMPERATURE FUNCTIONS
                     */      
                    
                    // Temperature
                    else if (functionName.equals(TEMPERATURE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                            //Publisher excession
                        Publish p = publishs.get(TEMPERATURE);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+TEMPERATURE);
                        }
                    }
                    
                    // beautiful Weather
                    else if (functionName.equals(BEAUTIFUL_WEATHER)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
                        //Publisher excession
                        Publish p = publishs.get(BEAUTIFUL_WEATHER);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+BEAUTIFUL_WEATHER);
                        }
                        
                    }
                    
                    //is fire?
                    else if (functionName.equals(IS_FIRE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
                        //Publisher excession
                        Publish p = publishs.get(IS_FIRE);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+IS_FIRE);
                        }
                    }
                    
                    // Hot and dry weather
                    else if (functionName.equals(HOT_DRY)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
                        //Publisher excession
                        Publish p = publishs.get(HOT_DRY);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+HOT_DRY);
                        }
                        
                    }
                    
                    /**
                     *DUMP FUNCTIONS
                     */      
                    
//                     Dump situation
                    
                    else if (functionName.equals(TRASH)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                         
                        //Publisher excession
                        Publish p = publishs.get(TRASH);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+TRASH);
                        }
                    }
                    // alerts you when is borderline calls and agent catcher.
                    else if (functionName.equals(GATHERING)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                       
                        //Publisher excession
                        Publish p = publishs.get(GATHERING);
                        if(p != null){
                            p.publicar(context);
                        }else{
                            //System.out.println("não existe publish associado a "+GATHERING);
                        }
                    }
                    
                    return null;
                    //return new DataObject();

            }
}

