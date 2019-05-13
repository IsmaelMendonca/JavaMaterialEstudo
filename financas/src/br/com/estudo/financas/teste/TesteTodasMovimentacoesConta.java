package br.com.estudo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.util.JPAUtils;

public class TesteTodasMovimentacoesConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();

		try {
//			String jpql = "SELECT c FROM Conta c";
			String jpql = "SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes";
			
			TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
			
			List<Conta> contas = query.getResultList();
			
			contas.forEach(x -> {
				System.out.println("Titular: " + x.getTitular());
				System.out.println("Movimentações: ");
				System.out.println(x.getMovimentacoes());
			});
		} finally {
			em.close();
		}
	}
}
