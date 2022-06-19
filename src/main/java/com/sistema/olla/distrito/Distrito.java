package com.sistema.olla.distrito;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.olla.provincia.Provincia;

@Entity
public class Distrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =50, nullable=false, unique=true)
	private String nombre;
	
	@Column(length =7, nullable=false, unique=true)
	private Integer cantPob;
	
	@ManyToOne
	@JoinColumn(name ="provincia_id")
	private Provincia provincia;

	
	
	
	public Distrito() {
		super();
	}

	public Distrito(Integer id) {
		super();
		this.id = id;
	}

	public Distrito(Integer id, String nombre, Integer cantPob, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantPob = cantPob;
		this.provincia = provincia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantPob() {
		return cantPob;
	}

	public void setCantPob(Integer cantPob) {
		this.cantPob = cantPob;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
	
	
	
}
