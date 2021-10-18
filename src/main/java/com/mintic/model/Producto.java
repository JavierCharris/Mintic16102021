package com.mintic.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long codigo;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="nit",nullable = false)
	private Proveedor nit;
	
	private Double precio_compra;
	private Double iva_compra;
	private Double precio_venta;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Proveedor getNit() {
		return nit;
	}
	public void setNit(Proveedor nit) {
		this.nit = nit;
	}
	public Double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public Double getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(Double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public Double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}
	

	
	

	
	
}
