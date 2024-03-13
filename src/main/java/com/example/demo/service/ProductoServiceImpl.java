package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.dto.ProductoDTO;
import com.example.demo.service.to.ProductoTO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public void guardarTO(ProductoTO p) {
		// TODO Auto-generated method stub
		this.productoRepository.insertar(this.revertir(p));

	}

	@Override
	public void actualizarTO(ProductoTO p) {
		// TODO Auto-generated method stub
		this.productoRepository.actualizar(this.revertir(p));
	}

	@Override
	public ProductoTO consultarTO(String codigo) {
		// TODO Auto-generated method stub
		return this.convertir(this.productoRepository.obtener(codigo));
	}

	@Override
	public List<ProductoDTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		List<Producto> lista = this.productoRepository.obtenerTodos();
		List<ProductoDTO> dto = new ArrayList<>();
		for (Producto p : lista) {
			dto.add(this.convertirDTO(p));
		}
		return dto;
	}

	@Override
	public void eliminarTO(String codigo) {
		// TODO Auto-generated method stub
		this.productoRepository.eliminar(codigo);
	}

	// Conversion

	public ProductoTO convertir(Producto p) {
		ProductoTO to = new ProductoTO();
		to.setCodigo(p.getCodigo());
		to.setFechaCaduca(p.getFechaCaduca());
		to.setId(p.getId());
		to.setNombre(p.getNombre());
		to.setStock(p.getStock());
		return to;
	}

	public ProductoDTO convertirDTO(Producto p) {
		ProductoDTO to = new ProductoDTO();
		to.setCodigo(p.getCodigo());
		to.setId(p.getId());
		to.setNombre(p.getNombre());
		return to;
	}

	// Revertir

	public Producto revertir(ProductoTO to) {
		Producto p = new Producto();
		p.setCodigo(to.getCodigo());
		p.setFechaCaduca(to.getFechaCaduca());
		p.setId(to.getId());
		p.setNombre(to.getNombre());
		p.setStock(to.getStock());
		return p;
	}
}
