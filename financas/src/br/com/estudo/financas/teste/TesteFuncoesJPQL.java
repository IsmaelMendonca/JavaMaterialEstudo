package br.com.estudo.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.TipoMovimentacaoEnum;
import br.com.estudo.financas.util.JPAUtils;

public class TesteFuncoesJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();

		try {
			Conta conta = new Conta();
			conta.setId(1);
			
			String jpql = "SELECT SUM(m.valor) FROM Movimentacao m WHERE m.conta = :pConta "
					+ "AND m.tipo = :pTipo "
					+ "ORDER BY m.valor";
			
			TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
			query.setParameter("pConta", conta);
			query.setParameter("pTipo", TipoMovimentacaoEnum.SAIDA);
			
			BigDecimal soma = (BigDecimal) query.getSingleResult();
			
			System.out.println("A soma é: " + soma);
			
			String jpqlMedia = "SELECT AVG(m.valor) FROM Movimentacao m WHERE m.conta = :pConta "
					+ "AND m.tipo = :pTipo "
					+ "ORDER BY m.valor";
			
			TypedQuery<Double> queryMedia = em.createQuery(jpqlMedia, Double.class);
			queryMedia.setParameter("pConta", conta);
			queryMedia.setParameter("pTipo", TipoMovimentacaoEnum.SAIDA);
			
			Double media = (Double) queryMedia.getSingleResult();
			
			System.out.println("A media é: " + media);
			
			Conta conta2 = em.find(Conta.class, 4);
			
			String maxJPQL = "SELECT MAX(m.valor) FROM Movimentacao m WHERE m.conta = :pConta "
					+ "AND m.tipo = :pTipo "
					+ "ORDER BY m.valor";
			
			TypedQuery<BigDecimal> maxQuery = em.createQuery(maxJPQL, BigDecimal.class);
			maxQuery.setParameter("pConta", conta2);
			maxQuery.setParameter("pTipo", TipoMovimentacaoEnum.SAIDA);
			
			BigDecimal max = maxQuery.getSingleResult();
			
			System.out.println("Valor Máximo: " + max);
		} finally {
			em.close();
		}
	}
}
