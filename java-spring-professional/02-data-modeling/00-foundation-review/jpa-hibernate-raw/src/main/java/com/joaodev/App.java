package com.joaodev;

import com.joaodev.dominio.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
   	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
