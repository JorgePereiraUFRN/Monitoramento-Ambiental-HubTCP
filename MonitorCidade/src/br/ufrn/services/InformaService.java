/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

//import br.ufrn.interfaces.AtualizacoesLixeira;
import br.ufrn.GUI.MonitorCidade;
import br.ufrn.subscriber.Subscriber;


public class InformaService {

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
    
    private AtualizaMonitor cidade = MonitorCidade.getInstance();

  
    public void iniciar(){
        new SubscriberHOT_DRY(HOT_DRY).subscribe();
        new SubscriberIS_FIRE(IS_FIRE).subscribe();
        new SubscriberNOISE(NOISE).subscribe();
        new SubscriberPOLLUTION(POLLUTION).subscribe();
        new SubscriberTEMPERATURE(TEMPERATURE).subscribe();
        new SubscriberWILL_RAIN(NOISE).subscribe();
        new SusbcriberGATHERING(GATHERING).subscribe();
        new subscriberACID_RAIN(ACID_RAIN).subscribe();
        new subscriberBEAUTIFUL_WEATHER(BEAUTIFUL_WEATHER).subscribe();
        new subscriberTRASH(TRASH).subscribe();
    }

    private class SubscriberPOLLUTION extends Subscriber {

        public SubscriberPOLLUTION(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresP[] = mensagem.split(";");

            if (valoresP[2].equals("TRAFEGO_ON")) {
                cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
            } else if (valoresP[2].equals("TRAFEGO_OFF")) {
                cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
            } else {
                cidade.atualizaNivelPoluicao(Integer.parseInt(valoresP[0]), valoresP[2]);
            }
        }
    }

    private class SubscriberWILL_RAIN extends Subscriber {

        public SubscriberWILL_RAIN(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresP[] = mensagem.split(";");

            if (valoresP[2].equals("RAIN_ON")) {
                cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
            } else if (valoresP[2].equals("RAIN_OFF")) {
                cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
            }
        }
    }

    private class subscriberACID_RAIN extends Subscriber {

        public subscriberACID_RAIN(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresP[] = mensagem.split(";");

            if (valoresP[2].equals("AQUI")) {
                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
            } else if (valoresP[2].equals("OUTRO")) {
                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], valoresP[3]);
            } else if (valoresP[2].equals("ACID_OFF")) {
                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
            }
        }
    }

    private class SubscriberNOISE extends Subscriber {

        public SubscriberNOISE(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresP[] = mensagem.split(";");

            if (valoresP[2].equals("NOISE_ON")) {
                cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]), valoresP[2], Integer.parseInt(valoresP[3]));
            } else if (valoresP[2].equals("NOISE_OFF")) {
                cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]), valoresP[2], Integer.parseInt(valoresP[3]));
            }
        }
    }

    private class SubscriberTEMPERATURE extends Subscriber {

        public SubscriberTEMPERATURE(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            System.out.println(mensagem);
            String valoresT[] = mensagem.split(";");
            cidade.atualizaTemperatura(Integer.parseInt(valoresT[0]), Integer.parseInt(valoresT[2]));

        }
    }

    private class subscriberBEAUTIFUL_WEATHER extends Subscriber {

        public subscriberBEAUTIFUL_WEATHER(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresT[] = mensagem.split(";");

            if (valoresT[2].equals("BEAUTIFUL_ON")) {
                cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), valoresT[2]);
            } else if (valoresT[2].equals("BEAUTIFUL_OFF")) {
                cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), valoresT[2]);
            }
        }
    }

    private class SubscriberIS_FIRE extends Subscriber {

        public SubscriberIS_FIRE(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresT[] = mensagem.split(";");

            if (valoresT[2].equals("FIRE_ON")) {
                cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), valoresT[2]);
            } else if (valoresT[2].equals("FIRE_OFF")) {
                cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), valoresT[2]);
            }
        }
    }

    private class SubscriberHOT_DRY extends Subscriber {

        public SubscriberHOT_DRY(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresT[] = mensagem.split(";");

            if (valoresT[2].equals("HOTDRY_ON")) {
                cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), valoresT[2]);
            } else if (valoresT[2].equals("HOTDRY_OFF")) {
                cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), valoresT[2]);
            }
        }
    }

    private class subscriberTRASH extends Subscriber {

        public subscriberTRASH(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresD[] = mensagem.split(";");

            if (valoresD[2].equals("VAZIA")) {
                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
            } else if (valoresD[2].equals("ENCHENDO")) {
                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
            } else if (valoresD[2].equals("CHEIA")) {
                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
            }
        }
    }

    private class SusbcriberGATHERING extends Subscriber {

        public SusbcriberGATHERING(String topico) {
            super(topico);
        }

        @Override
        public void tratarMensagem(String mensagem) {
            String valoresD[] = mensagem.split(";");

            if (valoresD[2].equals("LIMITE")) {
                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], valoresD[3], Integer.parseInt(valoresD[4]));
            } else if (valoresD[2].equals("GATHERING_ON")) {
                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], valoresD[3], null);
            } else if (valoresD[2].equals("GATHERING_OFF")) {
                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], null, null);
            }
        }
    }
//    
//    public void execute() {
//
//        String functionName = serviceInput.getFunctionName();
//        System.out.println("função " + functionName + "\n");
//
//        /**
//         * POLLUTION FUNCTIONS
//         */
//        //Index Pollution
//        if (functionName.equals(POLLUTION)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresP[] = context.split(";");
//
//            if (valoresP[2].equals("TRAFEGO_ON")) {
//                cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
//            } else if (valoresP[2].equals("TRAFEGO_OFF")) {
//                cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
//            } else {
//                cidade.atualizaNivelPoluicao(Integer.parseInt(valoresP[0]), valoresP[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(POLLUTION);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + POLLUTION);
//            }
//
//        } //Will Rain
//        else if (functionName.equals(WILL_RAIN)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresP[] = context.split(";");
//
//            if (valoresP[2].equals("RAIN_ON")) {
//                cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
//            } else if (valoresP[2].equals("RAIN_OFF")) {
//                cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(WILL_RAIN);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + WILL_RAIN);
//            }
//
//        } //Acid Rain
//        else if (functionName.equals(ACID_RAIN)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresP[] = context.split(";");
//
//            if (valoresP[2].equals("AQUI")) {
//                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
//            } else if (valoresP[2].equals("OUTRO")) {
//                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], valoresP[3]);
//            } else if (valoresP[2].equals("ACID_OFF")) {
//                cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
//            }
//            //Publisher excession
//            Publish p = publishs.get(ACID_RAIN);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + ACID_RAIN);
//            }
//        } //Noise
//        else if (functionName.equals(NOISE)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresP[] = context.split(";");
//
//            if (valoresP[2].equals("NOISE_ON")) {
//                cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]), valoresP[2], Integer.parseInt(valoresP[3]));
//            } else if (valoresP[2].equals("NOISE_OFF")) {
//                cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]), valoresP[2], Integer.parseInt(valoresP[3]));
//            }
//            //Publisher excession
//            Publish p = publishs.get(NOISE);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + NOISE);
//            }
//        } /**
//         * TEMPERATURE FUNCTIONS
//         */
//        // Temperature
//        else if (functionName.equals(TEMPERATURE)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresT[] = context.split(";");
//
//            cidade.atualizaTemperatura(Integer.parseInt(valoresT[0]), Integer.parseInt(valoresT[2]));
//            //Publisher excession
//            Publish p = publishs.get(TEMPERATURE);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + TEMPERATURE);
//            }
//        } // beautiful Weather
//        else if (functionName.equals(BEAUTIFUL_WEATHER)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresT[] = context.split(";");
//
//            if (valoresT[2].equals("BEAUTIFUL_ON")) {
//                cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), valoresT[2]);
//            } else if (valoresT[2].equals("BEAUTIFUL_OFF")) {
//                cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), valoresT[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(BEAUTIFUL_WEATHER);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + BEAUTIFUL_WEATHER);
//            }
//
//        } //is fire?
//        else if (functionName.equals(IS_FIRE)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresT[] = context.split(";");
//
//            if (valoresT[2].equals("FIRE_ON")) {
//                cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), valoresT[2]);
//            } else if (valoresT[2].equals("FIRE_OFF")) {
//                cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), valoresT[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(IS_FIRE);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + IS_FIRE);
//            }
//        } // Hot and dry weather
//        else if (functionName.equals(HOT_DRY)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresT[] = context.split(";");
//
//            if (valoresT[2].equals("HOTDRY_ON")) {
//                cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), valoresT[2]);
//            } else if (valoresT[2].equals("HOTDRY_OFF")) {
//                cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), valoresT[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(HOT_DRY);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + HOT_DRY);
//            }
//
//        } /**
//         * DUMP FUNCTIONS
//         */
//        //                     Dump situation
//        else if (functionName.equals(TRASH)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresD[] = context.split(";");
//
//            if (valoresD[2].equals("VAZIA")) {
//                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
//            } else if (valoresD[2].equals("ENCHENDO")) {
//                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
//            } else if (valoresD[2].equals("CHEIA")) {
//                cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);
//            }
//            //Publisher excession
//            Publish p = publishs.get(TRASH);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + TRASH);
//            }
//        } // alerts you when is borderline calls and agent catcher.
//        else if (functionName.equals(GATHERING)) {
//            String context = serviceInput.getInput().getAttributeValue("area");
//            String valoresD[] = context.split(";");
//
//            if (valoresD[2].equals("LIMITE")) {
//                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], valoresD[3], Integer.parseInt(valoresD[4]));
//            } else if (valoresD[2].equals("GATHERING_ON")) {
//                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], valoresD[3], null);
//            } else if (valoresD[2].equals("GATHERING_OFF")) {
//                cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]), valoresD[2], null, null);
//            }
//            //Publisher excession
//            Publish p = publishs.get(GATHERING);
//            if (p != null) {
//                p.publicar(context);
//            } else {
//                System.out.println("não existe publish associado a " + GATHERING);
//            }
//        }
//
//        return null;
//        //return new DataObject();
//
//    }
//    
}
