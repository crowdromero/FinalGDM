/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Centro_Medico {

private int idcentro_medico;
private String cem_ruc;
private String cem_nombre;
private String cem_direccion;
private int iddepartamento;
private int idprovincia;
private int iddistrito;
private int cem_estado;


public Centro_Medico(int idcentro_medico, String cem_ruc, String cem_nombre, String cem_direccion, int iddepartamento,
		int idprovincia, int iddistrito, int cem_estado) {

	this.idcentro_medico = idcentro_medico;
	this.cem_ruc = cem_ruc;
	this.cem_nombre = cem_nombre;
	this.cem_direccion = cem_direccion;
	this.iddepartamento = iddepartamento;
	this.idprovincia = idprovincia;
	this.iddistrito = iddistrito;
	this.cem_estado = cem_estado;
}


public Centro_Medico() {
	
	// TODO Auto-generated constructor stub
}


public int getIdcentro_medico() {
	return idcentro_medico;
}


public void setIdcentro_medico(int idcentro_medico) {
	this.idcentro_medico = idcentro_medico;
}


public String getCem_ruc() {
	return cem_ruc;
}


public void setCem_ruc(String cem_ruc) {
	this.cem_ruc = cem_ruc;
}


public String getCem_nombre() {
	return cem_nombre;
}


public void setCem_nombre(String cem_nombre) {
	this.cem_nombre = cem_nombre;
}


public String getCem_direccion() {
	return cem_direccion;
}


public void setCem_direccion(String cem_direccion) {
	this.cem_direccion = cem_direccion;
}


public int getIddepartamento() {
	return iddepartamento;
}


public void setIddepartamento(int iddepartamento) {
	this.iddepartamento = iddepartamento;
}


public int getIdprovincia() {
	return idprovincia;
}


public void setIdprovincia(int idprovincia) {
	this.idprovincia = idprovincia;
}


public int getIddistrito() {
	return iddistrito;
}


public void setIddistrito(int iddistrito) {
	this.iddistrito = iddistrito;
}


public int getCem_estado() {
	return cem_estado;
}


public void setCem_estado(int cem_estado) {
	this.cem_estado = cem_estado;
}

}