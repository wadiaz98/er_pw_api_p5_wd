package com.example.demo.service.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ProductoDTO extends RepresentationModel<ProductoDTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Integer id;
	private String codigo;
	private String nombre;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
