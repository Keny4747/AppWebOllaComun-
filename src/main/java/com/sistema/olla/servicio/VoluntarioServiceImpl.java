package com.sistema.olla.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.olla.voluntario.Voluntario;
import com.sistema.olla.voluntario.VoluntarioRepository;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {
	
	@Autowired
	private VoluntarioRepository voluntarioRepository;
	
	
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Voluntario> findAll() {
		return (List<Voluntario>) voluntarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Voluntario> findAll(Pageable pageable) {
		return voluntarioRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Voluntario voluntario) {
		voluntarioRepository.save(voluntario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Voluntario findOne(Integer id) {
		 return voluntarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		voluntarioRepository.deleteById(id);
		
	}

	@Override
	public Integer contarVoluntario() {
		return voluntarioRepository.contarVoluntario();
	}


}
