package br.com.famaciel.edvrestapi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Atendente")
public class AtendenteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer atendenteID;
	@Column
	private String nome;
	@Column
	private String senha;
	/**
	 * @return the atendenteID
	 */
	public Integer getAtendenteID() {
		return atendenteID;
	}
	/**
	 * @param atendenteID the atendenteID to set
	 */
	public void setAtendenteID(Integer atendenteID) {
		this.atendenteID = atendenteID;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
