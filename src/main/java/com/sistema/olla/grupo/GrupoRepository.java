package com.sistema.olla.grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    @Query(
            value = "select count(*) from grupo",
            nativeQuery = true
    )
    Integer contarGrupo();

}
