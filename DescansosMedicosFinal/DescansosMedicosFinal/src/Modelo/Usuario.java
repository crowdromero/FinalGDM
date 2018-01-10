/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Usuario {

	private int idusuario; 
	private String usu_codigo;
	private String usu_contraseña;
	private int usu_estado;
	private String usu_idempleado; 
	private int usu_perfil;
	
	
	public Usuario(int idusuario, String usu_codigo, String usu_contraseña, int usu_estado, String usu_idempleado,
			int usu_perfil) {

		this.idusuario = idusuario;
		this.usu_codigo = usu_codigo;
		this.usu_contraseña = usu_contraseña;
		this.usu_estado = usu_estado;
		this.usu_idempleado = usu_idempleado;
		this.usu_perfil = usu_perfil;
	}


	public Usuario() {
		
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String getUsu_codigo() {
		return usu_codigo;
	}


	public void setUsu_codigo(String usu_codigo) {
		this.usu_codigo = usu_codigo;
	}


	public String getUsu_contraseña() {
		return usu_contraseña;
	}


	public void setUsu_contraseña(String usu_contraseña) {
		this.usu_contraseña = usu_contraseña;
	}


	public int getUsu_estado() {
		return usu_estado;
	}


	public void setUsu_estado(int usu_estado) {
		this.usu_estado = usu_estado;
	}


	public String getUsu_idempleado() {
		return usu_idempleado;
	}


	public void setUsu_idempleado(String usu_idempleado) {
		this.usu_idempleado = usu_idempleado;
	}


	public int getUsu_perfil() {
		return usu_perfil;
	}


	public void setUsu_perfil(int usu_perfil) {
		this.usu_perfil = usu_perfil;
	}
	
	
}