package br.com.famaciel.edvrestapi.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.famaciel.edvrestapi.model.Produto;
import br.com.famaciel.edvrestapi.model.entity.CategoriaEntity;
import br.com.famaciel.edvrestapi.model.entity.ProdutoEntity;

@Repository
@Transactional
public class ProdutoRepository implements CrudRepository<Produto, Integer> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Produto arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Produto> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Produto> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Produto> S save(S arg0) {
		ProdutoEntity produto = new ProdutoEntity();
		BeanUtils.copyProperties(arg0, produto);
		produto.setCategoria(new CategoriaEntity(arg0.getCategoria()));
		entityManager.persist(produto);
		BeanUtils.copyProperties(produto, arg0);
		return arg0;
	}


	@Override
	public <S extends Produto> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Inicializa o MOCK da tabela Produtos
	 */	
	public void inicializar() {
		ProdutoEntity[] produtos = {
				//Categoria Espetos
				new ProdutoEntity("Espeto de carne", "Carne: Filé Mignon", new BigDecimal(2.00), "", new CategoriaEntity(1))
				,new ProdutoEntity("Espeto de frango", "Frango temperado com alho e salsa", new BigDecimal(1.50), "", new CategoriaEntity(1))
				,new ProdutoEntity("Espeto de coração", "Coração de frango", new BigDecimal(1.50), "", new CategoriaEntity(1))
				,new ProdutoEntity("Espeto de Linguiça Toscana", "Linguiça toscana", new BigDecimal(1.50), "", new CategoriaEntity(1))
				//Categoria Porções
				,new ProdutoEntity("Calabresa acebolada", "Desc", new BigDecimal(1.50), "", new CategoriaEntity(2))
				,new ProdutoEntity("Mix de Carne e Frango", "Uma porção de carne e frango", new BigDecimal(15.50), "", new CategoriaEntity(2))
				,new ProdutoEntity("Porção de churrasco", "Uma porção com carne, frango, coração e linguiça toscana", new BigDecimal(25.00), "", new CategoriaEntity(2))
				,new ProdutoEntity("Currasco completo", "Porções de carne, frango, coração, linguiça acompanados de arroz, cesta de pães e creme de alho", new BigDecimal(35.00), "", new CategoriaEntity(2))
				//Categoria Acompanhamentos
				,new ProdutoEntity("Arroz", "Arroz branco", new BigDecimal(1.50), "", new CategoriaEntity(3))
				,new ProdutoEntity("Farofa", "Farofa temperada", new BigDecimal(1.50), "", new CategoriaEntity(3))
				,new ProdutoEntity("Cesta de pães", "Cesta com pães cortados em formato de torradas", new BigDecimal(1.50), "", new CategoriaEntity(3))
				,new ProdutoEntity("Creme de Alho", "Delicioso creme de alho feito com alho leite e especiarias", new BigDecimal(1.50), "", new CategoriaEntity(3))
				//Categoria Bebidas
				,new ProdutoEntity("Refrigerante em lata 350ml", "opções disponíveis: Coca-cola, Sprite, Fanta Laranja, Fanta Uva", new BigDecimal(4.50), "", new CategoriaEntity(4))
				,new ProdutoEntity("H20 500ml", "opções disponíveis: Original ou Citrus", new BigDecimal(5.00), "", new CategoriaEntity(4))
				,new ProdutoEntity("Cervejas 600ml", "Skol, Bhrama, Itaipava", new BigDecimal(9.00), "", new CategoriaEntity(4))
				,new ProdutoEntity("Cervejas Especiais 600ml", "Serra Malte, Original, Proibida puro Malte", new BigDecimal(11.00), "", new CategoriaEntity(4))
				,new ProdutoEntity("Cervejas de trigo 600ml", "Erdinger, Baden Baden", new BigDecimal(12.50), "", new CategoriaEntity(4))
				//Categoria Drinks
				,new ProdutoEntity("Juripinga - Dose 50ml", "Bebida original de cana de açúcar com frutas.", new BigDecimal(3.50), "", new CategoriaEntity(5))
				,new ProdutoEntity("Capirinha - copo 300ml", "Tradicional caipirinha de limão e cachaça", new BigDecimal(8.50), "", new CategoriaEntity(5))
				//Categoria outros
				,new ProdutoEntity("Chiclete Trident", "opções: Melancia, Menta, Hortlã", new BigDecimal(2.00), "", new CategoriaEntity(6)) };
		for (ProdutoEntity p : produtos) {
			entityManager.persist(p);
		}
	}
}
