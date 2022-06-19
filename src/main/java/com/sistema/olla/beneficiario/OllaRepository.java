package com.sistema.olla.beneficiario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OllaRepository extends JpaRepository<Olla, Integer>{

    @Query(
            value = "SELECT * FROM olla WHERE distrito_id = :distrito_id",
            nativeQuery = true
    )
    List<Olla> listaOllas(@Param("distrito_id") Integer distrito_id);

    @Query(
            value = "select count(*) from olla",
            nativeQuery = true
    )
    Integer contarOllas();

}
