package com.example.demo.models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.dao.InterfaceClienteDAO;

@Controller
public class ClienteController {

	@Autowired
		/**
		 * Se usa Qualifier para inyectar uno de distintos Beans que implementen la interfaz
		 * Se distinguen porque la anotación @Repository del objeto DAO que implementa la interfaz,
		 * , tiene ese nombre
		 */
	@Qualifier("interfaceClienteDAO_HIBERNATE")
	private InterfaceClienteDAO iCD; 
	
	/**
	 * 
	 * También podemos usar @RequestMapping(value="/listado", method=RequestMethod.GET)
	 * en vez de @GetMapping(...)
	 */
	@GetMapping(value="/listado")
	public String obtenerListado(Model modelo) {
		modelo.addAttribute("titulo", "Título");
		modelo.addAttribute("clientes", iCD.obtenerListaClientes());
		return "listar";
	}
}
 