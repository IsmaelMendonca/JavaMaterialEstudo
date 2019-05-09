package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estudo.financas.modelo.*;
import br.com.estudo.financas.util.JPAUtils;

public class TesteRemoverConta {
	public static void main(String[] args) {
		
		//Estado Transient
		Conta conta = new Conta();
		conta.setId(8);
		conta.setTitular("Daniel Mendonça");
		conta.setBanco("Nubank");
		conta.setNumero("123");
		conta.setAgencia("456");
		
		EntityManager em = new JPAUtils().getEntityManager();
		
		em.getTransaction().begin();
		
		//Estado Managed
		conta = em.find(Conta.class, 8);
		
		System.out.println(conta.getTitular());
		
		//Muda estado Managed -> Removed
		em.remove(conta);
		
		//Ignorado, pois a entidade não existe mais no banco
		conta.setBanco("Corintias");
		
		//Muda estado Removed -> Managed
		em.persist(conta);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
