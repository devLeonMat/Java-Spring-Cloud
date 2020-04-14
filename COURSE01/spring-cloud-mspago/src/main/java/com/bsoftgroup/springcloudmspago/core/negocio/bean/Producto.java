package com.bsoftgroup.springcloudmspago.core.negocio.bean;

import java.util.List;

public class Producto {
	
	private Integer codigo;
	private String descripcion;
	private Integer precio;

	
	//atributo de relacion
	List<Servicio> servicios;


	
	public Producto(Integer codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public List<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	

}
