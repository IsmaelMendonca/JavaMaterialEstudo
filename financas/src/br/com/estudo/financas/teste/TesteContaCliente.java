package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Cliente;
import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtils;

public class TesteContaCliente {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Adalberto");
		cliente.setEndereco("Quadra x gama leste casa 23");
		cliente.setProfissao("Radiologista");

		Cliente cliente2 = new Cliente();
		cliente2.setNome("Elias");
		cliente2.setEndereco("Quadra x gama leste casa 60");
		cliente2.setProfissao("Radiologista");
		
		Conta conta = new Conta();
		conta.setId(4);
		
		cliente.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtils().getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.persist(cliente);
			em.persist(cliente2);
			
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
