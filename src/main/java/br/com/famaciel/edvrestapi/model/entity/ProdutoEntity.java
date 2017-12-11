package br.com.famaciel.edvrestapi.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
public class ProdutoEntity {

	/**
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @param foto
	 * @param categoria
	 */
	public ProdutoEntity(String nome, String descricao, BigDecimal preco, String foto,
			CategoriaEntity categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer produtoID;

	@Column
	private String nome;

	@Column
	private String descricao;

	@Column
	private BigDecimal preco;

	@Column
	private String foto;

	@ManyToOne
	@JoinColumn(nullable = false, name = "categoriaID", foreignKey = @ForeignKey(name = "categoriaPK"))
	private CategoriaEntity categoria;

	/**
	 * Default constructor
	 */
	public ProdutoEntity() {
		super();
	}

	/**
	 * @param produtoID
	 */
	public ProdutoEntity(Integer produtoID) {
		super();
		this.produtoID = produtoID;
	}

	public Integer getProdutoID() {
		return produtoID;
	}

	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto
	 *            the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

}
