/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.util.Date;

public class Descanso_medico {

	private int iddescansomedico;
	private String dm_idempleado;
	private String dm_fechaincio;
	private String dm_fechafin;
	private int dm_tipolicencia;
	private int dm_diagnostico;
	private String dm_medico;
	private int dm_centromedico;
	private String dm_observaciones;
	private int dm_cantidaddias;
	
	public Descanso_medico() {
	
	
	}

	public Descanso_medico(int iddescansomedico, String dm_idempleado, String dm_fechaincio, String dm_fechafin,
			int dm_tipolicencia, int dm_diagnostico, String dm_medico, int dm_centromedico, String dm_observaciones,
			int dm_cantidaddias) {
		
		this.iddescansomedico = iddescansomedico;
		this.dm_idempleado = dm_idempleado;
		this.dm_fechaincio = dm_fechaincio;
		this.dm_fechafin = dm_fechafin;
		this.dm_tipolicencia = dm_tipolicencia;
		this.dm_diagnostico = dm_diagnostico;
		this.dm_medico = dm_medico;
		this.dm_centromedico = dm_centromedico;
		this.dm_observaciones = dm_observaciones;
		this.dm_cantidaddias = dm_cantidaddias;
	}

	public int getIddescansomedico() {
		return iddescansomedico;
	}

	public void setIddescansomedico(int iddescansomedico) {
		this.iddescansomedico = iddescansomedico;
	}

	public String getDm_idempleado() {
		return dm_idempleado;
	}

	public void setDm_idempleado(String dm_idempleado) {
		this.dm_idempleado = dm_idempleado;
	}

	public String getDm_fechaincio() {
		return dm_fechaincio;
	}

	public void setDm_fechaincio(String dm_fechaincio) {
		this.dm_fechaincio = dm_fechaincio;
	}

	public String getDm_fechafin() {
		return dm_fechafin;
	}

	public void setDm_fechafin(String dm_fechafin) {
		this.dm_fechafin = dm_fechafin;
	}

	public int getDm_tipolicencia() {
		return dm_tipolicencia;
	}

	public void setDm_tipolicencia(int dm_tipolicencia) {
		this.dm_tipolicencia = dm_tipolicencia;
	}

	public int getDm_diagnostico() {
		return dm_diagnostico;
	}

	public void setDm_diagnostico(int dm_diagnostico) {
		this.dm_diagnostico = dm_diagnostico;
	}

	public String getDm_medico() {
		return dm_medico;
	}

	public void setDm_medico(String dm_medico) {
		this.dm_medico = dm_medico;
	}

	public int getDm_centromedico() {
		return dm_centromedico;
	}

	public void setDm_centromedico(int dm_centromedico) {
		this.dm_centromedico = dm_centromedico;
	}

	public String getDm_observaciones() {
		return dm_observaciones;
	}

	public void setDm_observaciones(String dm_observaciones) {
		this.dm_observaciones = dm_observaciones;
	}

	public int getDm_cantidaddias() {
		return dm_cantidaddias;
	}

	public void setDm_cantidaddias(int dm_cantidaddias) {
		this.dm_cantidaddias = dm_cantidaddias;
	}

	


}
 

