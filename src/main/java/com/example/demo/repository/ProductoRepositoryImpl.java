package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public Producto obtener(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p where p.codigo=:valor",
				Producto.class);
		query.setParameter("valor", codigo);
		return query.getSingleResult();
	}

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.obtener(codigo));
	}

}
