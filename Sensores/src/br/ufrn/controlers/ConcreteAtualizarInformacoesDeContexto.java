/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Jorge
 */
public class ConcreteAtualizarInformacoesDeContexto implements AtualizarInformacoesDeContexto{
    
    
    
    private Client client = Client.create();
    private static String URL_BASE_SERVICO = "http://localhost:8080/WS-MonitoramentoAnbiental/monitoramento_ambiental/";

    @Override
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_indice_poluicao/"+area);
        resource.type("application/json").post(indexPolluition.toString());
    }

    @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_fluxo_veiculos/"+area);
        resource.type("application/json").post(vehicleFlow.toString());
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_velocidade_vento/"+area);
        resource.type("application/json").post(windSpeed.toString());
    }

    @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_direcao_vento/"+area);
        resource.type("application/json").post(directionWind.toString());
    }

    @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_probabilidade_chuva/"+area);
        resource.type("application/json").post(willRain.toString());
    }

    @Override
    public void atualizarQuantidadeRuido(Integer area, Integer noise) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_quantidade_ruido/"+area);
        resource.type("application/json").post(noise.toString());
    }

    @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_temperatura/"+area);
        resource.type("application/json").post(temperature.toString());
    }

    @Override
    public void atualizarHumidade(Integer area, Integer humidity) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_humidade/"+area);
        resource.type("application/json").post(humidity.toString());
    }

    @Override
    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_incidencia_incendio/"+area);
        resource.type("application/json").post(isFire.toString());
    }

    @Override
    public void atualizarQuantidadeLixo(Integer area, Integer trash) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_quantidade_lixo/"+area);
        resource.type("application/json").post(trash.toString());
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_agente_proximo/"+area);
        resource.type("application/json").post(agentNearName.toString());
    }

    @Override
    public void atualizarDistanciaAgente(Integer area, Integer agentDistance) {
        WebResource resource = client.resource(URL_BASE_SERVICO+"atualizar_distancia_agente/"+area);
        resource.type("application/json").post(agentDistance.toString());
    }
    
}
