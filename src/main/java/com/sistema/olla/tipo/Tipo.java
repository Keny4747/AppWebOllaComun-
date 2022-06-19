package com.sistema.olla.tipo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =4, nullable=false, unique=true)
	private Integer cod;
	
	@Column(length =50, nullable=false, unique=true)
	private String descTipo;


	
	
	
	public Tipo(String descTipo) {
		super();
		this.descTipo = descTipo;
	}

	public Tipo() {
		super();
	}

	public Tipo(Integer id) {
		super();
		this.id = id;
	}

	public Tipo(Integer id, Integer cod, String descTipo) {
		super();
		this.id = id;
		this.cod = cod;
		this.descTipo = descTipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	@Override
	public String toString() {
		return  descTipo ;
	}
	
	
}
