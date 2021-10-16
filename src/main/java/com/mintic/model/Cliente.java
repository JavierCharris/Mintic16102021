package com.mintic.model;

import java.util.Objects;

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
	
	
	public Cliente() {
		
	}


	public Cliente(Long cedula, String nombre_completo, String direccion, String telefono,
			String correo_electronico) {
		super();
		this.cedula = cedula;
		this.nombre_completo = nombre_completo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cedula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cedula, other.cedula);
	}


	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre_completo=" + nombre_completo + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo_electronico=" + correo_electronico + "]";
	}


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
