package ar.edu.unju.fi.tp6.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;

@Controller
public class ClienteController {

	
	@Autowired
	@Qualifier("clienteRamImp")
	private IClienteService clienteService;
	
	private static final Log LOGGER = LogFactory.getLog(ClienteController.class);
	
	@GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		LOGGER.info("CONTROLLER : ClienteController with / Formulario get method");
		LOGGER.info("METHOD : nuevoCliente()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevocliente.html");
		model.addAttribute(clienteService.getCliente());
		
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
		LOGGER.info("CONTROLLER : ClienteController with / cliente/guardar post method");
		LOGGER.info("METHOD : guardarCliente()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA clientes.html");
		ModelAndView modelView = new ModelAndView("clientes");
		clienteService.guardarCliente(cliente);
		modelView.addObject("clientes",clienteService.getAllClientes());
		
		return modelView;
	}
	
	
	
	@GetMapping("/cliente/listado")
	public ModelAndView getClientesPage() {
		LOGGER.info("CONTROLLER : ClienteController with / cliente/listado get method");
		LOGGER.info("METHOD : getClientesPage()");
		ModelAndView modelView = new ModelAndView("clientes");
		if (clienteService.getAllClientes() == null) {
			clienteService.generarTablaCLiente();
		}
		modelView.addObject("clientes",clienteService.getAllClientes());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA clientes.html");
		return modelView;
	
	}
	
}