package br.com.famaciel.edvrestapi.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoriaID;

	@Column
	private String nome;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private List<ProdutoEntity> produtos;

	/**
	 * Default constructor
	 */
	public CategoriaEntity() {
		super();
	}

	/**
	 * @param codigo
	 */
	public CategoriaEntity(Integer codigo) {
		super();
		this.categoriaID = codigo;
	}

	/**
	 * @param nome
	 */
	public CategoriaEntity(String nome) {
		super();
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutoEntity> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoEntity> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the categoriaID
	 */
	public Integer getCategoriaID() {
		return categoriaID;
	}

	/**
	 * @param categoriaID the categoriaID to set
	 */
	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

}
