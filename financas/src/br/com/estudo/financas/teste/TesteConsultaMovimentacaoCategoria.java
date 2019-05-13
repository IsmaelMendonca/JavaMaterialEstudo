package br.com.estudo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estudo.financas.modelo.Categoria;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.util.JPAUtils;

public class TesteConsultaMovimentacaoCategoria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();

		try {
			@SuppressWarnings("deprecation")
			Categoria categoria = new Categoria();
			categoria.setId(1);
			
			String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";
			
			TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
			query.setParameter("pCategoria", categoria);
			
			List<Movimentacao> resultado = query.getResultList();
			
			resultado.forEach(x -> {
				System.out.println("Descricao: " + x.getDescricao());
				System.out.println("Conta.id: " + x.getConta().getId());
			});
		} finally {
			em.close();
		}
	}

}
