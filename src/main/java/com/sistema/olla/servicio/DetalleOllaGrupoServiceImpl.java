package com.sistema.olla.servicio;


import com.sistema.olla.detalleOllaGrupo.DetalleOllaGrupoRepository;
import com.sistema.olla.detalleOllaGrupo.DetalleOllagrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleOllaGrupoServiceImpl implements DetalleOllaGrupoService{

    @Autowired
    private DetalleOllaGrupoRepository detalleOllaGrupoRepository;

    @Override
    public List<DetalleOllagrupo> buscarPorOlla(Integer ollaid) {
        return detalleOllaGrupoRepository.buscarPorOlla(ollaid);
    }

    @Override
    public List<DetalleOllagrupo> buscarPorGrupo(Integer grupoid) {
        return detalleOllaGrupoRepository.buscarPorGrupo(grupoid);
    }

    @Override
    public Integer eliminarOlla(Integer grupoid, Integer ollaid) {
        return detalleOllaGrupoRepository.eliminarOlla(grupoid, ollaid);
    }
}
