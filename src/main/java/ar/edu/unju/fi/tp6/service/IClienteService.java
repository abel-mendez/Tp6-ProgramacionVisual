package ar.edu.unju.fi.tp6.service;

import java.util.List;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteService {
	
	//public void generarTablaCLiente();
	public void guardarCliente(Cliente cliente);
	public List<Cliente> getAllClientes();
	public Cliente getCliente();

}
