package com.sistema.olla.grupo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sistema.olla.encargado.Encargado;

@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =10, nullable=false, unique=true)
	private String codigo;
	
	@Column(length =3, nullable=false, unique=false)
	private Integer cantidad;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name ="encargado_id")
	private Encargado encargado;

	
		
	public Grupo(String codigo) {
		super();
		this.codigo = codigo;
	}

	public Grupo() {
		super();
	}

	public Grupo(Integer id) {
		super();
		this.id = id;
	}
	
	

	public Grupo(Integer id, String codigo, Integer cantidad, Date fecha, Encargado encargado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.encargado = encargado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	

	
}
