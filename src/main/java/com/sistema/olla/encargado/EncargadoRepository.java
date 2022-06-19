package com.sistema.olla.encargado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EncargadoRepository extends JpaRepository<Encargado, Integer> {

    @Query(
            value = "select count(*) from encargado",
            nativeQuery = true
    )
    Integer contarEncargado();

}
