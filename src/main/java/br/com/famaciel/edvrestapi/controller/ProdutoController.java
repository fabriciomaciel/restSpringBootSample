package br.com.famaciel.edvrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.famaciel.edvrestapi.model.Produto;
import br.com.famaciel.edvrestapi.repository.ProdutoRepository;

@RestController
@RequestMapping("api/v1/produto")
public class ProdutoController extends AbstractCrudController<Produto> {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	protected boolean validacaoIncluir(Produto objeto) {
		// TODO Realizar as validações para inclusão do produto
		return true;
	}

	@Override
	protected boolean validacaoAlterar(Produto objeto) {
		// TODO Realizar as validações para alteração do produto
		return true;
	}

	@Override
	protected boolean validacaoExcluir(Produto objeto) {
		// TODO Realizar as validações para exclusão do produto
		return true;
	}

}
