package com.sistema.olla.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sistema.olla.encargado.Encargado;
import com.sistema.olla.encargado.EncargadoRepository;


@Service
public class EncargadoServiceImpl implements EncargadoService{
	@Autowired
	private EncargadoRepository encargadoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Encargado> findAll() {
		return (List<Encargado>) encargadoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Encargado> findAll(Pageable pageable) {
		return encargadoRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Encargado encargado) {
		encargadoRepository.save(encargado);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Encargado findOne(Integer id) {
		 return encargadoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		encargadoRepository.deleteById(id);
		
	}

	@Override
	public Integer contarEncargado() {
		return encargadoRepository.contarEncargado();
	}
}
