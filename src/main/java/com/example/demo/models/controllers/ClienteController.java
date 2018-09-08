package com.example.demo.models.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.dao.InterfaceClienteDAO;
import com.example.demo.models.entity.Cliente;

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
	
	@GetMapping(value="/form")
	public String crearObjeto(Map<String, Object> modelo) {
		
		Cliente cliente= new Cliente();
		modelo.put("cliente",  cliente);
		modelo.put("titulo", "formCliente");
		
		return "form"; 
		
	}
	
	@PostMapping(value="/form")
	public String almacenarObjeto(Cliente cliente) {
		iCD.Guardar(cliente);
		return "redirect:listado";
	}
}
 