package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.olla.beneficiario.Olla;


public interface Ollaservice {
	public List<Olla> findAll();
	public Page<Olla> findAll(Pageable pageable);
	
	public void save(Olla olla);
	
	public Olla findOne(Integer id);
	
	public void delete(Integer id);

	List<Olla> listaOllas(Integer distrito_id);

	Integer contarOllas();
}
