package br.com.livraria.bean;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "livroBean") // opcional
public class LivroBean {

	private String titulo;
	private String isbn;
	private BigDecimal preco;
	private String dataLancamento;

	public void gravar() {
		System.out.println("Gravando livro: ");
		System.out.println("Título - " + titulo);
		System.out.println("ISBN - " + isbn);
		System.out.println("Preço - " + preco);
		System.out.println("Data de Lancamento - " + dataLancamento);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}
