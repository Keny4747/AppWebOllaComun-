package com.sistema.olla.servicio;

import com.sistema.olla.detalleOllaGrupo.DetalleOllagrupo;

import java.util.List;

public interface DetalleOllaGrupoService {

    List<DetalleOllagrupo> buscarPorOlla(Integer ollaid);

    List<DetalleOllagrupo> buscarPorGrupo(Integer grupoid);

    Integer eliminarOlla(Integer grupoid, Integer ollaid);

}
