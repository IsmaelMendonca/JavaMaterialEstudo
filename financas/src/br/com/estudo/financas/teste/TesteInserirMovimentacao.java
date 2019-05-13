package br.com.estudo.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estudo.financas.modelo.Conta;
import br.com.estudo.financas.modelo.Movimentacao;
import br.com.estudo.financas.util.JPAUtils;

public class TesteInserirMovimentacao {
	public static void main(String[] args) {

        EntityManager em = new JPAUtils().getEntityManager();

        Conta conta = em.find(Conta.class, 1);
        
        List<Movimentacao> movimentacoes = conta.getMovimentacoes();
        
        em.close();

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }
    }
}
