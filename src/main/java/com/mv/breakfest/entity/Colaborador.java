package com.mv.breakfest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -517295792202922057L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@Column
	private String cpf;

	//@ElementCollection
	@Column
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OpcaoCafeManha> opcaoCafeManha = new ArrayList<OpcaoCafeManha>();

	public Colaborador() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<OpcaoCafeManha> getOpcaoCafeManha() {
		return opcaoCafeManha;
	}

	public void setOpcaoCafeManha(List<OpcaoCafeManha> opcaoCafeManha) {
		this.opcaoCafeManha = opcaoCafeManha;
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", opcaoCafeManha=" + opcaoCafeManha + "]";
	}

}
