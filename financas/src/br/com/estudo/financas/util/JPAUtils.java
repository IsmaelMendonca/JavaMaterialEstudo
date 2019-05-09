package br.com.estudo.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
