package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudo.financas.modelo.*;
import br.com.estudo.financas.util.JPAUtils;

public class TesteConta {
	public static void main(String[] args) {

		// Estado Transient
		Conta conta = new Conta();
		conta.setTitular("Eduardo Mendonça");
		conta.setBanco("Nubank");
		conta.setNumero("123");
		conta.setAgencia("456");

		EntityManager em = new JPAUtils().getEntityManager();

		try {
			em.getTransaction().begin();

			// Muda estado Transient -> Managed
			em.persist(conta);

			conta.setBanco("Bradesco");

			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
