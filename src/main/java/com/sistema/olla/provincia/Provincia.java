package com.sistema.olla.provincia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =4, nullable=false, unique=true)
	private String numUbigeo;
	
	@Column(length =40, nullable=false, unique=true)
	private String nombre;

	
	
	
	
	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Provincia(Integer id) {
		super();
		this.id = id;
	}

	public Provincia() {
		super();
	}

	public Provincia(Integer id, String numUbigeo, String nombre) {
		super();
		this.id = id;
		this.numUbigeo = numUbigeo;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumUbigeo() {
		return numUbigeo;
	}

	public void setNumUbigeo(String numUbigeo) {
		this.numUbigeo = numUbigeo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
