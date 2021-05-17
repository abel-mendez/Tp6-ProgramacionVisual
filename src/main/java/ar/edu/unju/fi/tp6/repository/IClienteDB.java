package ar.edu.unju.fi.tp6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteDB extends JpaRepository<Cliente, Integer>{

}
