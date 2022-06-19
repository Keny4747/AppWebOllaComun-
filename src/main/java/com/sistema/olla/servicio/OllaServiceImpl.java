package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.olla.beneficiario.Olla;
import com.sistema.olla.beneficiario.OllaRepository;

@Service
public class OllaServiceImpl implements Ollaservice {


	@Autowired
	private OllaRepository ollaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Olla> findAll() {
		return (List<Olla>) ollaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Olla> findAll(Pageable pageable) {
		return ollaRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Olla olla) {
		ollaRepository.save(olla);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Olla findOne(Integer id) {
		 return ollaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		ollaRepository.deleteById(id);
		
	}

	@Override
	public List<Olla> listaOllas(Integer distrito_id) {
		return ollaRepository.listaOllas(distrito_id);
	}

	@Override
	public Integer contarOllas() {
		return ollaRepository.contarOllas();
	}

}
