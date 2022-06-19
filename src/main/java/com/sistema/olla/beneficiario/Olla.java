package com.sistema.olla.beneficiario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sistema.olla.distrito.Distrito;


@Entity
public class Olla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =50, nullable=false, unique=false)
	private String nombre;
	
	@Column(length =100, nullable=false, unique=false)
	private String direccion;
	
	@Column(length =7, nullable=true, unique=false)
	private int cantBene;
	
	@Column(length =60, nullable=false, unique=false)
	private String contacto;
	
	@Column(length =9, nullable=false, unique=false)
	private String telefonoC;
	
	 
	@ManyToOne
	@JoinColumn(name ="distrito_id")
	private Distrito distrito;


	
	
	public Olla() {
		super();
	}


	public Olla(Integer id) {
		super();
		this.id = id;
	}


	public Olla(Integer id, String nombre, String direccion, int cantBene, String contacto, String telefonoC,
			Distrito distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantBene = cantBene;
		this.contacto = contacto;
		this.telefonoC = telefonoC;
		this.distrito = distrito;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getCantBene() {
		return cantBene;
	}


	public void setCantBene(int cantBene) {
		this.cantBene = cantBene;
	}


	public String getContacto() {
		return contacto;
	}


	public void setContacto(String contacto) {
		this.contacto = contacto;
	}


	public String getTelefonoC() {
		return telefonoC;
	}


	public void setTelefonoC(String telefonoC) {
		this.telefonoC = telefonoC;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
		
}
