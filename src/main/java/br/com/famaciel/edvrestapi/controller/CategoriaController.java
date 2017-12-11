package br.com.famaciel.edvrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.famaciel.edvrestapi.model.Categoria;
import br.com.famaciel.edvrestapi.model.Produto;
import br.com.famaciel.edvrestapi.repository.CategoriaRepository;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController extends AbstractCrudController<Categoria> {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("/produtos/{categoriaID}")
	public @ResponseBody List<Produto> produtosPorCategoria(@PathVariable("categoriaID") Integer categoriaID) {
		return categoriaRepository.produtosPorCategoria(categoriaID);
	}

	@Override
	protected boolean validacaoIncluir(Categoria objeto) {
		// Não existe validação para a inclusão de categoria
		return true;
	}

	@Override
	protected boolean validacaoAlterar(Categoria objeto) {
		// Não existe validação para a alteração de categoria
		return true;
	}

	@Override
	protected boolean validacaoExcluir(Categoria objeto) {
		// TODO: Realizar validação para a exclusão de categoria
		return true;
	}

}
