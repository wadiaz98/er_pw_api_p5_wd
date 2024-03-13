package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(generator = "seq_producto", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "seq_producto", sequenceName = "seq_producto")
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_codigo")
	private String codigo;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_stock")
	private Integer stock;
	@Column(name = "prod_fecha_caduca")
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

}
