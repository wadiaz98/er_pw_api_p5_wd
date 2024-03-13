package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class ProductoTO extends RepresentationModel<ProductoTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String codigo;
	private String nombre;
	private Integer stock;
	private LocalDateTime fechaCaduca;

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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public LocalDateTime getFechaCaduca() {
		return fechaCaduca;
	}

	public void setFechaCaduca(LocalDateTime fechaCaduca) {
		this.fechaCaduca = fechaCaduca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
