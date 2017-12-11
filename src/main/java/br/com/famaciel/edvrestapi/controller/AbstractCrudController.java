package br.com.famaciel.edvrestapi.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Transactional
public abstract class AbstractCrudController<T> {

	@Autowired
	private CrudRepository<T, Integer> repository;
	
	public AbstractCrudController() {
		super();
	}
	
	@GetMapping("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public String status() {
		Response.status(Status.OK);
		return "{ \"status\" : \"online\" }";
	}
	
	@GetMapping("/")
	public Iterable<T> listar() {
		return repository.findAll() ;//repository.findAll().;
	}
	
	@GetMapping("/{objetoId}")
	public T detalhar(@PathVariable("objetoId") Integer objetoId) {
		return repository.findOne(objetoId);
	}
	@PostMapping("/incluir")
	@Transactional(readOnly = false)
	public T incluir(@RequestBody T objeto) {
		if(validacaoIncluir(objeto)) {
			return repository.save(objeto);
		} else {
			throw new IllegalArgumentException("Erro na inclusão do objeto: " + objeto) ;
		}
	}

	@PostMapping("/alterar")
	@Transactional(readOnly = false)
	public T alterar(@RequestBody T objeto) {
		if(validacaoAlterar(objeto)) {
			return repository.save(objeto);
		} else {
			throw new IllegalArgumentException("Erro na alteração do objeto: " + objeto) ;
		}		
	}
	
	
	@GetMapping("/excluir/{objetoId}")
	public boolean excluir(@PathVariable("objetoId") Integer objetoId) {
		if(objetoId != null && objetoId > 0) {
			repository.delete(objetoId);
			return true;
		} else {
			return false;
		}
	}	
	
	@PostMapping("/excluir")
	@Transactional(readOnly = false)
	public boolean excluir(@RequestBody T objeto) {
		if(validacaoExcluir(objeto)) {
			repository.delete(objeto);
			return true;
		} else {
			return false;
		}
	}
	
	protected abstract boolean validacaoIncluir(T objeto);
	protected abstract boolean validacaoAlterar(T objeto);
	protected abstract boolean validacaoExcluir(T objeto);	
}
