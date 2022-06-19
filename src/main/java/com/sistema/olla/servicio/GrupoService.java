package com.sistema.olla.servicio;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sistema.olla.grupo.Grupo;

public interface GrupoService {
	public List<Grupo> findAll();
	public Page<Grupo> findAll(Pageable pageable);
	
	public void save(Grupo grupo);
	
	public Grupo findOne(Integer id);
	
	public void delete(Integer id);

	Integer contarGrupo();
}
