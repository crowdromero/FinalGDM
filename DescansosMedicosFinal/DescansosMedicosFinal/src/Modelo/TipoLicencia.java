/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Xen
 */
public class TipoLicencia {
    private int idTipo_licencia;
    private String des_tip_licencia;
    private int tipli_estado;

    public TipoLicencia() {
    }

    public TipoLicencia(int idTipo_licencia, String des_tip_licencia, int tipli_estado) {
        this.idTipo_licencia = idTipo_licencia;
        this.des_tip_licencia = des_tip_licencia;
        this.tipli_estado = tipli_estado;
    }

    public int getIdTipo_licencia() {
        return idTipo_licencia;
    }

    public void setIdTipo_licencia(int idTipo_licencia) {
        this.idTipo_licencia = idTipo_licencia;
    }

    public String getDes_tip_licencia() {
        return des_tip_licencia;
    }

    public void setDes_tip_licencia(String des_tip_licencia) {
        this.des_tip_licencia = des_tip_licencia;
    }

    public int getTipli_estado() {
        return tipli_estado;
    }

    public void setTipli_estado(int tipli_estado) {
        this.tipli_estado = tipli_estado;
    }
    
    
}
