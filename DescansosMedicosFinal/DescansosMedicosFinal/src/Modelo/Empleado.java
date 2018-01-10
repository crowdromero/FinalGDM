/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Empleado {

private String idempleado;
private String emp_nombre;
private String emp_apellido;
private int emp_tipo_documento;
private String emp_numero_doc;
private Date emp_fecha_naciemiento;
private int emp_estado_civil;
private String emp_telefono;
private String emp_direccion;
private String emp_correo;
private String emp_genero;
private int emp_estado;
private int emp_idtipotrabajador;
private int emp_idpuesto;
private int emp_idgerencia;
private int emp_idunidad;
private int emp_iddepartamento;
private int emp_idprovincia;
private int emp_iddistrito;


public Empleado(String idempleado, String emp_nombre, String emp_apellido, int emp_tipo_documento,
		String emp_numero_doc, Date emp_fecha_naciemiento, int emp_estado_civil, String emp_telefono,
		String emp_direccion, String emp_correo, String emp_genero, int emp_estado, int emp_idtipotrabajador,
		int emp_idpuesto, int emp_idgerencia, int emp_idunidad, int emp_iddepartamento, int emp_idprovincia,
		int emp_iddistrito) {

	this.idempleado = idempleado;
	this.emp_nombre = emp_nombre;
	this.emp_apellido = emp_apellido;
	this.emp_tipo_documento = emp_tipo_documento;
	this.emp_numero_doc = emp_numero_doc;
	this.emp_fecha_naciemiento = emp_fecha_naciemiento;
	this.emp_estado_civil = emp_estado_civil;
	this.emp_telefono = emp_telefono;
	this.emp_direccion = emp_direccion;
	this.emp_correo = emp_correo;
	this.emp_genero = emp_genero;
	this.emp_estado = emp_estado;
	this.emp_idtipotrabajador = emp_idtipotrabajador;
	this.emp_idpuesto = emp_idpuesto;
	this.emp_idgerencia = emp_idgerencia;
	this.emp_idunidad = emp_idunidad;
	this.emp_iddepartamento = emp_iddepartamento;
	this.emp_idprovincia = emp_idprovincia;
	this.emp_iddistrito = emp_iddistrito;
}


public Empleado() {
	
	// TODO Auto-generated constructor stub
}


public String getIdempleado() {
	return idempleado;
}


public void setIdempleado(String idempleado) {
	this.idempleado = idempleado;
}


public String getEmp_nombre() {
	return emp_nombre;
}


public void setEmp_nombre(String emp_nombre) {
	this.emp_nombre = emp_nombre;
}


public String getEmp_apellido() {
	return emp_apellido;
}


public void setEmp_apellido(String emp_apellido) {
	this.emp_apellido = emp_apellido;
}


public int getEmp_tipo_documento() {
	return emp_tipo_documento;
}


public void setEmp_tipo_documento(int emp_tipo_documento) {
	this.emp_tipo_documento = emp_tipo_documento;
}


public String getEmp_numero_doc() {
	return emp_numero_doc;
}


public void setEmp_numero_doc(String emp_numero_doc) {
	this.emp_numero_doc = emp_numero_doc;
}


public Date getEmp_fecha_naciemiento() {
	return emp_fecha_naciemiento;
}


public void setEmp_fecha_naciemiento(Date emp_fecha_naciemiento) {
	this.emp_fecha_naciemiento = emp_fecha_naciemiento;
}


public int getEmp_estado_civil() {
	return emp_estado_civil;
}


public void setEmp_estado_civil(int emp_estado_civil) {
	this.emp_estado_civil = emp_estado_civil;
}


public String getEmp_telefono() {
	return emp_telefono;
}


public void setEmp_telefono(String emp_telefono) {
	this.emp_telefono = emp_telefono;
}


public String getEmp_direccion() {
	return emp_direccion;
}


public void setEmp_direccion(String emp_direccion) {
	this.emp_direccion = emp_direccion;
}


public String getEmp_correo() {
	return emp_correo;
}


public void setEmp_correo(String emp_correo) {
	this.emp_correo = emp_correo;
}


public String getEmp_genero() {
	return emp_genero;
}


public void setEmp_genero(String emp_genero) {
	this.emp_genero = emp_genero;
}


public int getEmp_estado() {
	return emp_estado;
}


public void setEmp_estado(int emp_estado) {
	this.emp_estado = emp_estado;
}


public int getEmp_idtipotrabajador() {
	return emp_idtipotrabajador;
}


public void setEmp_idtipotrabajador(int emp_idtipotrabajador) {
	this.emp_idtipotrabajador = emp_idtipotrabajador;
}


public int getEmp_idpuesto() {
	return emp_idpuesto;
}


public void setEmp_idpuesto(int emp_idpuesto) {
	this.emp_idpuesto = emp_idpuesto;
}


public int getEmp_idgerencia() {
	return emp_idgerencia;
}


public void setEmp_idgerencia(int emp_idgerencia) {
	this.emp_idgerencia = emp_idgerencia;
}


public int getEmp_idunidad() {
	return emp_idunidad;
}


public void setEmp_idunidad(int emp_idunidad) {
	this.emp_idunidad = emp_idunidad;
}


public int getEmp_iddepartamento() {
	return emp_iddepartamento;
}


public void setEmp_iddepartamento(int emp_iddepartamento) {
	this.emp_iddepartamento = emp_iddepartamento;
}


public int getEmp_idprovincia() {
	return emp_idprovincia;
}


public void setEmp_idprovincia(int emp_idprovincia) {
	this.emp_idprovincia = emp_idprovincia;
}


public int getEmp_iddistrito() {
	return emp_iddistrito;
}


public void setEmp_iddistrito(int emp_iddistrito) {
	this.emp_iddistrito = emp_iddistrito;
}

	
}