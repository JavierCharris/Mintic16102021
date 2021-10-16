package com.mintic.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario  {
	
	@Id
	private Long cedula;
	
	private String nombre;
	
	private String password;
	
	private String nombre_completo;
	
	private String correo;
	
	private Boolean enabled;

	public Usuario() {
		
		
	}

	public Usuario(Long cedula, String nombre, String password, String nombre_completo, String correo,
			Boolean enabled) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.password = password;
		this.nombre_completo = nombre_completo;
		this.correo = correo;
		this.enabled = enabled;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(cedula, other.cedula);
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", password=" + password + ", nombre_completo="
				+ nombre_completo + ", correo=" + correo + ", enabled=" + enabled + "]";
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	

	
	
	
}