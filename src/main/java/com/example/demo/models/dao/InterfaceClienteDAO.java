package com.example.demo.models.dao;

import java.util.List;

import com.example.demo.models.entity.Cliente;

public interface InterfaceClienteDAO {

	public List<Cliente> obtenerListaClientes();
	
	public void Guardar(Cliente cliente);
}
