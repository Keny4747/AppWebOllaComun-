package com.sistema.olla.servicio;

import com.sistema.olla.detalleGrupo.DetalleGrupo;
import com.sistema.olla.detalleGrupo.DetalleGrupoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DetalleGrupoServiceImpl implements DetalleGrupoService{

    @Autowired
    private DetalleGrupoRepository detalleGrupoRepository;

    @Override
    public List<DetalleGrupo> buscarPorVoluntario(Integer voluntarioid) {
        return detalleGrupoRepository.buscarPorVoluntario(voluntarioid);
    }

    @Override
    public List<DetalleGrupo> buscarPorGrupo(Integer grupoid) {
        return detalleGrupoRepository.buscarPorGrupo(grupoid);
    }

    @Override
    public Integer eliminarVoluntario(Integer grupoid, Integer voluntarioid) {
        return detalleGrupoRepository.eliminarVoluntario(grupoid, voluntarioid);
    }

    @Override
    public void agregarGrupo(Integer voluntarioid, Integer grupoid) {
        detalleGrupoRepository.agregarGrupo(voluntarioid, grupoid);
    }

}
