package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal("1000"),celulares);

		EntityManager em = JPAUtils.getEntityManager();

		ProductoDao productoDao = new ProductoDao(em);

		em.getTransaction().begin();

		productoDao.guardar(celular);

		em.getTransaction().commit();
		em.close();
	}

}