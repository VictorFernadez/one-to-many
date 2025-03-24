package com.coudevi;

import com.coudevi.model.Categoria;
import com.coudevi.model.Producto;
import com.coudevi.model.TipoCategoria;
import com.coudevi.service.CategoriaService;

public class MainOneToMany {
	public static void main(String[] args) {
	       CategoriaService service = new CategoriaService();

	        // Crear una categoría
	        Categoria categoria = new Categoria(TipoCategoria.ELECTRONICA);

	        // Crear productos
	        Producto p1 = new Producto("Smartphone");
	        Producto p2 = new Producto("Laptop");

	        // Asociar productos a la categoría
	        categoria.agregarProducto(p1);
	        categoria.agregarProducto(p2);

	        // Persistir
	        service.crearCategoria(categoria);

	        // Recuperar y mostrar
	        service.obtenerCategoriasConProductos().forEach(c -> {
	            System.out.println("Categoria: " + c.getTipo());
	            c.getProductos().forEach(prod -> System.out.println("  Producto: " + prod.getNombre()));
	        });

	        service.cerrar();		
	}

}
