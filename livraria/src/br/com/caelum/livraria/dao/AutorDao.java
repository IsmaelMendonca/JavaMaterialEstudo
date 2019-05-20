package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) //opcional
public class AutorDao {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED) //opcional
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
		
		em.persist(autor);
		
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return em.find(Autor.class, autorId);
	}
}
