package br.com.famaciel.edvrestapi.model;

public class Categoria {

	private Integer categoriaID;

	private String nome;

	/**
	 * Default constructor
	 */
	public Categoria() {
		super();
	}

	/**
	 * @param codigo
	 */
	public Categoria(Integer codigo) {
		super();
		this.categoriaID = codigo;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
