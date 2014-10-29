/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author Jorge
 */
public interface UpdateDatas extends Remote{

    //=====PollutionWidget=====
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) throws RemoteException;

    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) throws RemoteException;

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) throws RemoteException;

    public void atualizardirecaoDoVento(Integer area, String directionWind)throws RemoteException;

    public void atualizarProbalidadeChuva(Integer area, Integer willRain) throws RemoteException;

    public void atualizarQuantidadeRuido(Integer area, Integer noise) throws RemoteException;

    //======TemperatureWidget=====
    public void atualizarTemeperatura(Integer area, Integer temperature) throws RemoteException;

    public void atualizarHumidade(Integer area, Integer humidity) throws RemoteException;

    public void atualizarIncidenciaDeIncendio(Integer area, Integer isFire)throws RemoteException;

    //=====DumpWidget===
    public void atualizarQuantidadeLixo(Integer area, Integer trash)throws RemoteException;

    public void atualizarAgenteProximo(Integer area, String agentNearName) throws RemoteException;
    
    public void atualizaDistanciaAgente(Integer area, Integer agentDistance) throws RemoteException;
}
