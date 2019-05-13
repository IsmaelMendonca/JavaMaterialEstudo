package br.com.estudo.financas.teste;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.util.JPAUtils;

public class TesteBuscaMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtils().getEntityManager();

		try {
			Movimentacao movimentacao = em.find(Movimentacao.class, 4);
			Conta conta = movimentacao.getConta();
			
			System.out.println(conta.getTitular());
			System.out.println(conta.getMovimentacoes().size());
			
		} finally {
			em.close();
		}
	}
}
