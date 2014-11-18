package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
// @Interceptors({ LogInterceptador.class })
public class AutorDao {

	// @Inject
	// private Banco banco; // = new Banco();

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	// @TransactionAttribute(TransactionAttributeType.MANDATORY)
	// @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());

		// try {
		// Thread.sleep(20000); // 20 segundos
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// banco.save(autor);
		manager.persist(autor);

		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	}

	public List<Autor> todosAutores() {
		// return banco.listaAutores();
		return manager.createQuery("select a from Autor a", Autor.class)
				.getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		// Autor autor = this.banco.buscaPelaId(autorId);
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}

}
