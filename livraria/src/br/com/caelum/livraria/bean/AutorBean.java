package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Model
public class AutorBean {

	private Autor autor = new Autor();

	@Inject
	private AutorService service; // AutorDao dao; // = new AutorDao();

	public Autor getAutor() {
		return autor;
	}

	public void cadastra() {
		// this.dao.salva(autor);
		this.service.adiciona(autor);
		this.autor = new Autor();
	}

	public List<Autor> getAutores() {
		// return this.dao.todosAutores();
		return this.service.todosAutores();
	}
}
