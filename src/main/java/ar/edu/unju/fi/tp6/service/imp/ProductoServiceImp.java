package ar.edu.unju.fi.tp6.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.IProductoService;
import ar.edu.unju.fi.tp6.util.TablaProducto;

@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	@Qualifier("unProducto")
	Producto producto;

	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	//private List<Producto> productoList = new ArrayList<Producto>();
	private List<Producto> productos;
	
	
	//14-5 si la lista esta vacia se llamara a generarTabla()
	@Override
	public void addProducto(Producto producto) {
		/*
		 * //agrego el objeto producto en la lista de productos
		 * this.productoList.add(producto);
		 * LOGGER.info("METHOD: addProducto - se agrego un producto en la lista --> "+
		 * productoList.get(productoList.size()-1));
		 */	
		if (productos==null) {
			generarTablaProducto();
			
		}
		productos.add(producto);;
		
	}

	@Override
	public Producto getUltimoProducto() {

		if (productos.isEmpty()) {
			return producto;
			
		}else {
			Producto pr = productos.get(productos.size()-1);//productoList.get(productoList.size()-1);
			return pr;
		}

	}
	
	
	@Override
	public List<Producto> getAllProductos() {
		// TODO Auto-generated method stub
		if(this.productos==null) {
			this.generarTablaProducto();
		}
		return this.productos;//this.productoList;
	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return producto;
	}
	
	
	//14-5 Se busca un producto por codigo 
	@Override
	public Producto getUnProducto(int codigo) {
		// TODO Auto-generated method stub
		Producto prod =new Producto();
		//for each
		/*
		 * for (Producto producto : this.productoList) { if
		 * (codigo==producto.getCodigo()) { prod=producto; }
		 * 
		 * }
		 */
		for (Producto producto : this.productos) 
		{
			if (codigo==producto.getCodigo()){
				prod=producto; 
				}
			 
		 }
		return prod;
	}
	
	
	//14-5 Se genera la tabla con dos productos por defecto
	@Override
	public void generarTablaProducto() {
		// TODO Auto-generated method stub
		this.productos=TablaProducto.ListProducto;
		this.productos.add(new Producto(111,"Arroz",80.2,"Peleador",5));
		this.productos.add(new Producto(112,"Yerba",100.5,"Amanda",3));
		
	}
	

}
