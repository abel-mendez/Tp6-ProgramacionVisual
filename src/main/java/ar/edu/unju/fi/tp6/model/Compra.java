package ar.edu.unju.fi.tp6.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ("unaCompra")
public class Compra {
	private int id;
	@Autowired
	private Producto producto;
	private int cantidad;
	private Double total;

public Compra() {
	// TODO Auto-generated constructor stub
}


/**
 * @param id
 * @param producto
 * @param cantidad
 * @param total
 */
public Compra(int id, Producto producto, int cantidad) {
	super();
	this.id = id;
	this.producto = producto;
	this.cantidad = cantidad;
}



/**
 * @return the id
 */
public int getId() {
	return id;
}


/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}


/**
 * @return the producto
 */
public Producto getProducto() {
	return producto;
}


/**
 * @param producto the producto to set
 */
public void setProducto(Producto producto) {
	this.producto = producto;
}


/**
 * @return the cantidad
 */
public int getCantidad() {
	return cantidad;
}


/**
 * @param cantidad the cantidad to set
 */
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


/**
 * @param total the total to set
 */
public void setTotal(Double total) {
	this.total = total;
}



@Override
public String toString() {
	return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
}


public double getTotal() {
	this.total=this.producto.getPrecio()*this.cantidad;
	return this.total;
}
 

}
