package br.com.estudo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.modelo.TipoMovimentacaoEnum;
import br.com.estudo.financas.util.JPAUtils;

public class TesteJPQL {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();

		try {
			em.getTransaction().begin();
			
			Conta conta = new Conta();
			conta.setId(1);
			
//			String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.id = 1";
			String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta "
					+ "AND m.tipo = :pTipo "
					+ "ORDER BY m.valor";
			
			TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
			query.setParameter("pConta", conta);
			query.setParameter("pTipo", TipoMovimentacaoEnum.SAIDA);
			
			List<Movimentacao> resultado = query.getResultList();
			
			resultado.forEach(x -> {
				System.out.println("Descricao: " + x.getDescricao());
				System.out.println("Conta.id: " + x.getConta().getId());
			});
			
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
