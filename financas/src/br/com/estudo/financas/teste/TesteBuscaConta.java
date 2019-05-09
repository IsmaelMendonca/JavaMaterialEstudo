package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtils;

public class TesteBuscaConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();
		
		em.getTransaction().begin();
		
		//Estado Managed
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getAgencia());
		
		conta.setTitular("J�ao");
		conta.setAgencia("987");
		
		System.out.println(conta.getTitular());
		System.out.println(conta.getAgencia());
	
		em.getTransaction().commit();
		
		//Estado Detached (j� foi gerenciado pelo JPA mas n�o � mais porque ser� fechado o EntityManager)
		em.close();
		
		EntityManager em2 = new JPAUtils().getEntityManager();
		em2.getTransaction().begin();
	
		conta.setTitular("Leonardo");
		
		//S� trabalha com entidades Transient
		//em.persist(conta);
		
		// Muda estado Detached -> Managed
		em2.merge(conta);
		
		em2.getTransaction().commit();
		//Estado Detached (j� foi gerenciado pelo JPA mas n�o � mais porque ser� fechado o EntityManager)
		em2.close();
		
	}
}
