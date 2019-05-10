package br.com.estudo.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Categoria;
import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.modelo.TipoMovimentacaoEnum;
import br.com.estudo.financas.util.JPAUtils;

public class TesteMovimentacaoComCategoria {
	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Conta conta = new Conta();
		conta.setId(4);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem à São Paulo");
		movimentacao1.setTipo(TipoMovimentacaoEnum.SAIDA);
		movimentacao1.setValor(new BigDecimal("250.0"));
		movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
		
		movimentacao1.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem ao Afeganistão");
		movimentacao2.setTipo(TipoMovimentacaoEnum.SAIDA);
		movimentacao2.setValor(new BigDecimal("2250.0"));
		movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
		
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtils().getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.persist(categoria1);
			em.persist(categoria2);
			
			em.persist(movimentacao1);
			em.persist(movimentacao2);
			
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
