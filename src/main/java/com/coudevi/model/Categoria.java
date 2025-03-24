package com.coudevi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private TipoCategoria tipo;

	    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	    private List<Producto> productos = new ArrayList<>();

	    public Categoria() {}

	    public Categoria(TipoCategoria tipo) {
	        this.tipo = tipo;
	    }

	    public void agregarProducto(Producto producto) {
	        productos.add(producto);
	        producto.setCategoria(this);
	    }

	    public void removerProducto(Producto producto) {
	        productos.remove(producto);
	        producto.setCategoria(null);
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public TipoCategoria getTipo() {
			return tipo;
		}

		public void setTipo(TipoCategoria tipo) {
			this.tipo = tipo;
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
	    
}
