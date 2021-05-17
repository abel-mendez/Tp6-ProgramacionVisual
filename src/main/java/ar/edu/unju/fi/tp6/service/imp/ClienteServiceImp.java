package ar.edu.unju.fi.tp6.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.repository.IClienteDB;
import ar.edu.unju.fi.tp6.service.IClienteService;
import ar.edu.unju.fi.tp6.util.TablaCliente;

@Service("clienteRamImp")
public class ClienteServiceImp implements IClienteService{

	
	@Autowired
	@Qualifier("clienteObj")
	Cliente cliente;
	@Autowired
	IClienteDB clienteDBImp;
	private List<Cliente> clientes;
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	
	@Override
	public void generarTablaCLiente() {
		LOGGER.info("CONTROLLER : ClienteServiceImp");
		LOGGER.info("METHOD : generarTablaCLiente()");
		
		this.clientes = clienteDBImp.findAll();
		//clientes.add(new Cliente("DNI",38325788,"CRUZ,LEANDRO","leoapu@gmail.com","sdd12554",LocalDate.of(1989, 4, 3),388,5445845,LocalDate.of(2021, 4, 16)));
		clienteDBImp.save(new Cliente("DNI",38325788,"CRUZ,LEANDRO","leoapu@gmail.com","sdd12554",LocalDate.of(1989, 4, 3),388,5445845,LocalDate.of(2021, 4, 16)));
		LOGGER.info("RESULT : CREA LISTA DE CLIENTES");
	}
	

	@Override
	public void guardarCliente(Cliente cliente) {
		LOGGER.info("CONTROLLER : ClienteServiceImp");
		this.clientes = clienteDBImp.findAll();
		  if (clientes == null) {
			  generarTablaCLiente();
		  }
		  
		  clienteDBImp.save(cliente);
		  // LOGGER.info("METHOD : guardarCliente() - se agrego un Cliente en la lista --> " + clientes.get(clientes.size()-1));
		   LOGGER.info("RESULT : GUARDA CLIENTE INGRESADO POR FORMULARIO");
	}

	
	@Override
	public List<Cliente> getAllClientes() {
		LOGGER.info("METHOD : getAllClientes()");
		LOGGER.info("RESULT : INGRESA CLIENTES A UNA LISTA DE CLIENTES");
		this.clientes=clienteDBImp.findAll();
		return this.clientes;
	}


	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return this.cliente;
	}



}