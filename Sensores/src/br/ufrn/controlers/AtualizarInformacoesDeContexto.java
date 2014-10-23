/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;


/**
 *
 * @author Jorge
 */
public interface AtualizarInformacoesDeContexto {
    
   
    
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition);
    
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow);
    
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed);
    
    public void atualizardirecaoDoVento(Integer area, String directionWind);
    
    public void atualizarProbalidadeChuva( Integer area, Integer willRain);
    
    public void atualizarQuantidadeRuido( Integer area, Integer noise);
    
    public void atualizarTemeperatura(Integer area, Integer temperature);
    
    public void atualizarHumidade( Integer area, Integer humidity);
    
    public void atualizarIncidenciaDeIncendio( Integer area, Integer isFire);
    
    public void atualizarQuantidadeLixo( Integer area, Integer trash);
    
    public void atualizarAgenteProximo( Integer area, String agentNearName);
    
    public void atualizarDistanciaAgente( Integer area, Integer agentDistance);

}
