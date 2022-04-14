package com.mv.breakfest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OPCAO_CAFE_MANHA")
public class OpcaoCafeManha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8787461888397954675L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String item;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	public OpcaoCafeManha() {}

	public OpcaoCafeManha(String item, Colaborador colaborador) {
		this.item = item;
		this.colaborador = colaborador;
	}

	public OpcaoCafeManha(String item) {
		this.item = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OpcaoCafeManha [id=" + id + ", item=" + item + "]";
	}

}
