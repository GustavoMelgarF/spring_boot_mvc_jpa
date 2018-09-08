package com.example.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.entity.Cliente;

@Repository("interfaceClienteDAO_HIBERNATE")
public class ClienteDAOImpl implements InterfaceClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> obtenerListaClientes() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void Guardar(Cliente cliente) {
		entityManager.persist(cliente);
		
	}

}
