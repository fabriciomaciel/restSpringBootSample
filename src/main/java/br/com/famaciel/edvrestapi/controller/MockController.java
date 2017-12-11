package br.com.famaciel.edvrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.famaciel.edvrestapi.repository.CategoriaRepository;
import br.com.famaciel.edvrestapi.repository.ProdutoRepository;

@RestController
public class MockController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@GetMapping("/mock")
	public String iniciar() {
		categoriaRepository.inicializar();
		produtoRepository.inicializar();
		return "Mock complete";
	}
}
