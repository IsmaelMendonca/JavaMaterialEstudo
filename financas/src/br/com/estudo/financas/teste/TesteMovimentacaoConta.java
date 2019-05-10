package br.com.estudo.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.modelo.TipoMovimentacaoEnum;
import br.com.estudo.financas.util.JPAUtils;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("453453");
		conta.setBanco("BRB");
		conta.setNumero("640123");
		conta.setTitular("Leonardo Vieira");
		
		Movimentacao mv1 = new Movimentacao();
		mv1.setConta(conta);
		mv1.setData(Calendar.getInstance());
		mv1.setDescricao("VIAGEM A SÃO PAULO");
		mv1.setTipo(TipoMovimentacaoEnum.SAIDA);
		mv1.setValor(new BigDecimal("200.0"));
		
		Movimentacao mv2 = new Movimentacao();
		mv2.setConta(conta);
		mv2.setData(Calendar.getInstance());
		mv2.setDescricao("VIAGEM AO RIO DE JANEIRO");
		mv2.setTipo(TipoMovimentacaoEnum.SAIDA);
		mv2.setValor(new BigDecimal("500.0"));
		
		EntityManager em = new JPAUtils().getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			//Muda o status de Transient para Detached (o que é valido para a inserção por relacionamento)
//			conta.setId(3);
			
			em.persist(conta);
			
			em.persist(mv1);
			em.persist(mv2);
			
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
		
	}
}
