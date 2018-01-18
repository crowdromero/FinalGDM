/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class ListadoDescansoMedico {
	
	private int iddescansomedico;
	private String dm_idempleado;
	private String emp_nombre;
	private String emp_apellido;
	private String dm_fechaincio;
	private String dm_fechafin;
	private String dm_tipolicencia;
	private String diag_descripcion;
	private String dm_medico;
	private String med_nombres;
	private String ruccem;
	private String cem_nombre;
	private String dm_observaciones;
	private int cantDias;
	
	public ListadoDescansoMedico() {
		
	}

    public ListadoDescansoMedico(String dm_idempleado, String emp_nombre, String emp_apellido, int cantDias) {
        this.dm_idempleado = dm_idempleado;
        this.emp_nombre = emp_nombre;
        this.emp_apellido = emp_apellido;
        this.cantDias = cantDias;
    }
        
	public ListadoDescansoMedico(int iddescansomedico, String dm_idempleado, String emp_nombre, String emp_apellido,
			String dm_fechaincio, String dm_fechafin, String dm_tipolicencia, String diag_descripcion, String dm_medico,
			String med_nombres, String ruccem, String cem_nombre, String dm_observaciones,int cantDias) {
		
		this.iddescansomedico = iddescansomedico;
		this.dm_idempleado = dm_idempleado;
		this.emp_nombre = emp_nombre;
		this.emp_apellido = emp_apellido;
		this.dm_fechaincio = dm_fechaincio;
		this.dm_fechafin = dm_fechafin;
		this.dm_tipolicencia = dm_tipolicencia;
		this.diag_descripcion = diag_descripcion;
		this.dm_medico = dm_medico;
		this.med_nombres = med_nombres;
		this.ruccem = ruccem;
		this.cem_nombre = cem_nombre;
		this.dm_observaciones = dm_observaciones;
		this.cantDias = cantDias;
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

	public String getDm_tipolicencia() {
		return dm_tipolicencia;
	}

	public void setDm_tipolicencia(String dm_tipolicencia) {
		this.dm_tipolicencia = dm_tipolicencia;
	}

	public String getDiag_descripcion() {
		return diag_descripcion;
	}

	public void setDiag_descripcion(String diag_descripcion) {
		this.diag_descripcion = diag_descripcion;
	}

	public String getDm_medico() {
		return dm_medico;
	}

	public void setDm_medico(String dm_medico) {
		this.dm_medico = dm_medico;
	}

	public String getMed_nombres() {
		return med_nombres;
	}

	public void setMed_nombres(String med_nombres) {
		this.med_nombres = med_nombres;
	}

		public String getRuccem() {
		return ruccem;
	}

	public void setRuccem(String ruccem) {
		this.ruccem = ruccem;
	}

	public String getCem_nombre() {
		return cem_nombre;
	}

	public void setCem_nombre(String cem_nombre) {
		this.cem_nombre = cem_nombre;
	}

	public String getDm_observaciones() {
		return dm_observaciones;
	}

	public void setDm_observaciones(String dm_observaciones) {
		this.dm_observaciones = dm_observaciones;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	
}
