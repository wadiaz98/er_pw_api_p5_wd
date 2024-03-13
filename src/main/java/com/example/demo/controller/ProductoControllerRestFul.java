package com.example.demo.controller;

//Importaciones estaticas
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IProductoService;
import com.example.demo.service.dto.ProductoDTO;
import com.example.demo.service.to.ProductoTO;

@RestController
@RequestMapping(path = "/productos")
@CrossOrigin
public class ProductoControllerRestFul {
	@Autowired
	private IProductoService productoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody ProductoTO p) {
		this.productoService.guardarTO(p);
	}

	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoTO> consultar(@PathVariable String codigo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.productoService.consultarTO(codigo));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoDTO>> consultarTodos() {
		List<ProductoDTO> lista = this.productoService.consultarTodosTO();
		for (ProductoDTO to : lista) {
			Link link = linkTo(methodOn(ProductoControllerRestFul.class).consultar(to.getCodigo())).withSelfRel();
			to.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody ProductoTO to) {
		this.productoService.actualizarTO(to);
	}

	@DeleteMapping(path = "/{codigo}")
	public void eliminar(@PathVariable String codigo) {
		this.productoService.eliminarTO(codigo);
	}
	
	//URL: http://localhost:8080/API/V1.0/Inventario/productos
}
