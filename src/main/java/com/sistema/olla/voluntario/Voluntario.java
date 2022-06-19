package com.sistema.olla.voluntario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.sistema.olla.grupo.Grupo;
import com.sistema.olla.tipo.Tipo;

@Entity
public class Voluntario {
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
	
	@ManyToOne
	@JoinColumn(name ="tipo_id")
	private Tipo tipo;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "voluntario_grupo", joinColumns =@JoinColumn(name = "voluntario_id"),
	inverseJoinColumns = @JoinColumn(name="grupo_id"))
	private Set<Grupo> grupos = new HashSet<>();
	
	

	public Voluntario(String dni) {
		super();
		this.dni = dni;
	}

	public Voluntario() {
		super();
	}

	public Voluntario(Integer id) {
		super();
		this.id = id;
	}
	

	


	public Voluntario(String dni, String nombre, String apellido, String sexo, String telefono, String correo,
			Date fecha, Tipo tipo, Set<Grupo> grupos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha = fecha;
		this.tipo = tipo;
		this.grupos = grupos;
	}

	public Voluntario(Integer id, String dni, String nombre, String apellido, String sexo, String telefono,
			String correo, Date fecha, Tipo tipo, Set<Grupo> grupos) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha = fecha;
		this.tipo = tipo;
		this.grupos = grupos;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return dni ;
	}
	
	
}
