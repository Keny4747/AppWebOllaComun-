package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.olla.voluntario.Voluntario;

public interface VoluntarioService {
	public List<Voluntario> findAll();
	public Page<Voluntario> findAll(Pageable pageable);
	
	public void save(Voluntario voluntario);
	
	public Voluntario findOne(Integer id);
	
	public void delete(Integer id);

	Integer contarVoluntario();
}
