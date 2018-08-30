package com.example.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.entity.Cliente;

@Repository
public class ClienteDAOImpl implements InterfaceClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Cliente").getResultList();
	}

}
