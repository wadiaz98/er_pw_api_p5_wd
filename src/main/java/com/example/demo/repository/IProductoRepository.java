package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {
	public void insertar(Producto p);

	public void actualizar(Producto p);

	public Producto obtener(String codigo);

	public List<Producto> obtenerTodos();

	public void eliminar(String codigo);
}
