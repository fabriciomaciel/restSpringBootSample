package br.com.famaciel.edvrestapi.model;

import java.math.BigDecimal;

public class Produto {

	private Integer produtoID;

	private String nome;

	private String descricao;

	private BigDecimal preco;
	
	private String foto;
	
	private Integer categoria;
	
	private Integer status;

	/**
	 * Default constructor
	 */
	public Produto() {
		super();
	}

	/**
	 * @param produtoID
	 */
	public Produto(Integer produtoID) {
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

	/**
	 * @return the categoria
	 */
	public Integer getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Integer categoria) {
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
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
