package com.sistema.olla.encargado;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Encargado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 8, nullable = false, unique = true )
	private String dni;
	
	@Column(length = 30, nullable = false, unique = false )
	private String nombre;
	
	@Column(length = 40, nullable = false, unique = false )
	private String apellido;
	
	@Column(length = 9, nullable = false, unique = false )
	private String sexo;
	
	@Column(length = 9, nullable = false, unique = false )
	private String telefono;
	
	@Column(length = 40, nullable = true, unique = false )
	private String correo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	
	
	public Encargado() {
		super();
	}


	public Encargado(Integer id) {
		super();
		this.id = id;
	}


	public Encargado(Integer id, String dni, String nombre, String apellido, String sexo, String telefono,
			String correo,Date fecha) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha=fecha;
		
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return dni ;
	}


	
	
}
