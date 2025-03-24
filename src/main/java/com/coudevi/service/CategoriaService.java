package com.coudevi.service;

import java.util.List;

import com.coudevi.model.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoriaService {
	 private final EntityManagerFactory emf;

	    public CategoriaService() {
	        this.emf = Persistence.createEntityManagerFactory("oneToManyPU");
	    }

	    public void crearCategoria(Categoria categoria) {
	        EntityManager em = emf.createEntityManager();
	        try {
	            em.getTransaction().begin();
	            em.persist(categoria);
	            em.getTransaction().commit();
	        } finally {
	            em.close();
	        }
	    }

	    public List<Categoria> obtenerCategoriasConProductos() {
	        EntityManager em = emf.createEntityManager();
	        try {
	            // Usamos fetch join para evitar LazyInitializationException
	            return em.createQuery("SELECT c FROM Categoria c LEFT JOIN FETCH c.productos", Categoria.class)
	                     .getResultList();
	        } finally {
	            em.close();
	        }
	    }

	    public void cerrar() {
	        emf.close();
	    }
}
