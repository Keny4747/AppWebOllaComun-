package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.olla.grupo.Grupo;
import com.sistema.olla.grupo.GrupoRepository;


@Service
public class GrupoServiceImpl implements GrupoService{
	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findAll() {
		return (List<Grupo>) grupoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Grupo> findAll(Pageable pageable) {
		return grupoRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Grupo grupo) {
		grupoRepository.save(grupo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Grupo findOne(Integer id) {
		 return grupoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		grupoRepository.deleteById(id);
		
	}

	@Override
	public Integer contarGrupo() {
		return grupoRepository.contarGrupo();
	}
}
