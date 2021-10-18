package com.mintic.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Cliente {

	
	@Id
	private Long cedula;
	
	private String nombre_completo;
	
	private String direccion;
	
	private String telefono;
	
	private String correo_electronico;
	
	
	public Long getCedula() {
		return cedula;
	}


	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}


	public String getNombre_completo() {
		return nombre_completo;
	}


	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo_electronico() {
		return correo_electronico;
	}


	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}


	
	
	
}
