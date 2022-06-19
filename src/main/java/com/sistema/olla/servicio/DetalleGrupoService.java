package com.sistema.olla.servicio;

import com.sistema.olla.detalleGrupo.DetalleGrupo;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleGrupoService {

    List<DetalleGrupo> buscarPorVoluntario(Integer voluntarioid);

    List<DetalleGrupo> buscarPorGrupo(@Param("grupoid") Integer grupoid);

    Integer eliminarVoluntario(Integer grupoid, Integer voluntarioid);

    void agregarGrupo(Integer voluntarioid, Integer grupoid);
}
