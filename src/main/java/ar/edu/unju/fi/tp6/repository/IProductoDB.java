package ar.edu.unju.fi.tp6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tp6.model.Producto;

public interface IProductoDB extends JpaRepository<Producto, Integer > {
	
}
