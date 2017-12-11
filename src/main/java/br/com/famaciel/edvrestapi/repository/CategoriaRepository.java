package br.com.famaciel.edvrestapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.famaciel.edvrestapi.model.Categoria;
import br.com.famaciel.edvrestapi.model.Produto;
import br.com.famaciel.edvrestapi.model.entity.CategoriaEntity;
import br.com.famaciel.edvrestapi.model.entity.ProdutoEntity;

@Repository
@Transactional
public class CategoriaRepository implements CrudRepository<Categoria, Integer> {

	@PersistenceContext(name = "h2EntityManager")
	private EntityManager entityManager;

	@Override
	public void delete(Integer arg0) {
		try {
			CategoriaEntity categoriaEntity = entityManager.getReference(CategoriaEntity.class, arg0);
			entityManager.remove(categoriaEntity);
		} catch (EntityNotFoundException e) {
			// Categoria não encontrada na base
		}
	}

	@Override
	public void delete(Categoria arg0) {
		try {
			CategoriaEntity categoriaEntity = entityManager.getReference(CategoriaEntity.class, arg0.getCategoriaID());
			entityManager.remove(categoriaEntity);
		} catch (EntityNotFoundException e) {
			// Categoria não encontrada na base
		}
	}

	@Override
	public boolean exists(Integer categoriaID) {
		CategoriaEntity categoriaEntity = entityManager.getReference(CategoriaEntity.class, categoriaID);
		return (categoriaEntity != null);
	}

	@Override
	public Iterable<Categoria> findAll() {
		//
		Query query = entityManager.createQuery("SELECT c FROM CategoriaEntity c");
		@SuppressWarnings("unchecked")
		List<CategoriaEntity> resultList = query.getResultList();
		List<Categoria> listaRetorno = new ArrayList<Categoria>();
		for (CategoriaEntity cEntity : resultList) {
			Categoria c = new Categoria();
			BeanUtils.copyProperties(cEntity, c);
			listaRetorno.add(c);
		}
		return listaRetorno;
	}

	@Override
	public Categoria findOne(Integer categoriaID) {
		CategoriaEntity categoriaEntity = entityManager.getReference(CategoriaEntity.class, categoriaID);
		Categoria categoria = new Categoria();
		BeanUtils.copyProperties(categoriaEntity, categoria);
		return categoria;
	}

	@Override
	public <S extends Categoria> S save(S arg0) {
		CategoriaEntity categoria = new CategoriaEntity();
		BeanUtils.copyProperties(arg0, categoria);
		// UPDATE AN EXISTING ENTITY
		if (categoria.getCategoriaID() != null && exists(categoria.getCategoriaID())) {
			entityManager.merge(categoria);
		} else {// INCLUDE A NEW ENTITY
			entityManager.persist(categoria);
			BeanUtils.copyProperties(categoria, arg0);
		}
		return arg0;
	}

	public List<Produto> produtosPorCategoria(Integer categoriaID) {
		List<Produto> retorno = new ArrayList<Produto>();
		try {
			CategoriaEntity categoria = entityManager.getReference(CategoriaEntity.class, categoriaID);
			for (ProdutoEntity produtoEntity : categoria.getProdutos()) {
				Produto p = new Produto();
				BeanUtils.copyProperties(produtoEntity, p);
				p.setCategoria(categoriaID);
				retorno.add(p);
			}

		} catch (EntityNotFoundException e) {
			// Categoria inexistente
		}
		return retorno;
	}
	
	
	
	/**
	 * Unused
	 */

	@Override
	public <S extends Categoria> Iterable<S> save(Iterable<S> entities) {
		// Unused
		return null;
	}

	@Override
	public Iterable<Categoria> findAll(Iterable<Integer> ids) {
		// Unused
		return null;
	}

	@Override
	public long count() {
		// Unused
		return 0;
	}

	@Override
	public void delete(Iterable<? extends Categoria> entities) {
		// Unused
	}

	@Override
	public void deleteAll() {
		// Unused		
	}

	/**
	 * Inicializa o MOCK da tabela Categoria
	 */
	public void inicializar() {
		CategoriaEntity[] categorias = { 
				new CategoriaEntity("Espetos")
				,new CategoriaEntity("Porções")		
				,new CategoriaEntity("Acompanhamentos")				
				,new CategoriaEntity("Bebidas") 
				,new CategoriaEntity("Drinks")
				,new CategoriaEntity("Outros")};
		for (CategoriaEntity c : categorias) {
			entityManager.persist(c);
		}
	}

}
