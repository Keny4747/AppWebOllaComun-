package com.sistema.olla.detalleGrupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface DetalleGrupoRepository extends JpaRepository<DetalleGrupo, Integer> {

    @Query(
            value = "SELECT * FROM detalle_grupo WHERE voluntarioid = :voluntarioid",
            nativeQuery = true
    )
    List<DetalleGrupo> buscarPorVoluntario(@Param("voluntarioid") Integer voluntarioid);

    @Query(
            value = "SELECT * FROM detalle_grupo WHERE grupoid = :grupoid",
            nativeQuery = true
    )
    List<DetalleGrupo> buscarPorGrupo(@Param("grupoid") Integer grupoid);

    @Query(
            value = "SELECT id FROM detalle_grupo WHERE grupoid = :grupoid AND voluntarioid = :voluntarioid",
            nativeQuery = true
    )
    Integer eliminarVoluntario(@Param("grupoid") Integer grupoid, @Param("voluntarioid") Integer voluntarioid);

    @Modifying
    @Query(
            value = "INSERT INTO detalle_grupo(voluntarioid, grupoid) VALUES(?1, ?2)",
            nativeQuery = true
    )
    void agregarGrupo(Integer voluntarioid, Integer grupoid);

}
