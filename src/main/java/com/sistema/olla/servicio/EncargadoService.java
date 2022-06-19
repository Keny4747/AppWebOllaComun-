package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sistema.olla.encargado.Encargado;

public interface EncargadoService {
	public List<Encargado> findAll();
	public Page<Encargado> findAll(Pageable pageable);
	
	public void save(Encargado encargado);
	
	public Encargado findOne(Integer id);
	
	public void delete(Integer id);

	Integer contarEncargado();
}
