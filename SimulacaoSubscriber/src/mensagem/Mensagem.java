/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensagem;

import java.io.Serializable;

/**
 *
 * @author jorge
 */
public class Mensagem implements Serializable{
    
    public static final String subscriber = "subscriber", unsubscriber = "unsubscriber",
            publish = "publish", register = "register";
    
    private String codigo;
    private String valorMensagem;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValorMensagem() {
        return valorMensagem;
    }

    public void setValorMensagem(String valorMensagem) {
        this.valorMensagem = valorMensagem;
    }

   
    
    
}
