/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Medico {


private String idmedico;
private String ed_nombres;
private String med_apellidos;
private int med_activo;


public Medico(String idmedico, String ed_nombres, String med_apellidos, int med_activo) {
	
	this.idmedico = idmedico;
	this.ed_nombres = ed_nombres;
	this.med_apellidos = med_apellidos;
	this.med_activo = med_activo;
}


public Medico() {

	// TODO Auto-generated constructor stub
}


public String getIdmedico() {
	return idmedico;
}


public void setIdmedico(String idmedico) {
	this.idmedico = idmedico;
}


public String getEd_nombres() {
	return ed_nombres;
}


public void setEd_nombres(String ed_nombres) {
	this.ed_nombres = ed_nombres;
}


public String getMed_apellidos() {
	return med_apellidos;
}


public void setMed_apellidos(String med_apellidos) {
	this.med_apellidos = med_apellidos;
}




public int getMed_activo() {
	return med_activo;
}


public void setMed_activo(int med_activo) {
	this.med_activo = med_activo;
}


}
