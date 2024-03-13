package com.example.demo.service;

import java.util.List;

import com.example.demo.service.dto.ProductoDTO;
import com.example.demo.service.to.ProductoTO;

public interface IProductoService {
	public void guardarTO(ProductoTO p);

	public void actualizarTO(ProductoTO p);

	public ProductoTO consultarTO(String codigo);

	public List<ProductoDTO> consultarTodosTO();

	public void eliminarTO(String codigo);

}
