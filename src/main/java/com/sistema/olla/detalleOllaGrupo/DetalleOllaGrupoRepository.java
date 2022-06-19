package com.sistema.olla.detalleOllaGrupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleOllaGrupoRepository extends JpaRepository<DetalleOllagrupo, Integer> {

    @Query(
            value = "SELECT * FROM detalle_ollagrupo WHERE ollaid = :ollaid",
            nativeQuery = true
    )
    List<DetalleOllagrupo> buscarPorOlla(@Param("ollaid") Integer ollaid);

    @Query(
            value = "SELECT * FROM detalle_ollagrupo WHERE grupoid = :grupoid",
            nativeQuery = true
    )
    List<DetalleOllagrupo> buscarPorGrupo(@Param("grupoid") Integer grupoid);

    @Query(
            value = "SELECT id FROM detalle_ollagrupo WHERE grupoid = :grupoid AND ollaid = :ollaid",
            nativeQuery = true
    )
    Integer eliminarOlla(@Param("grupoid") Integer grupoid, @Param("ollaid") Integer ollaid);

}
