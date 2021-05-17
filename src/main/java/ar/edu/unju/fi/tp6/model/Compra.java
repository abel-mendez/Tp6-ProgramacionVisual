package ar.edu.unju.fi.tp6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="COMPRAS")
@Component ("unaCompra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COMP_ID")
	private long id;
	
	@Autowired
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="PRO_CODIGO")
	private Producto producto;
	
	@Column(name="COMP_CANTIDAD")
	private int cantidad;
	@Column(name="COMP_TOTAL")
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
public Compra(Producto producto, int cantidad) {
	super();
	this.producto = producto;
	this.cantidad = cantidad;
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
