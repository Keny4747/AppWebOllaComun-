package com.sistema.olla.voluntario;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer>{

    @Query(
            value = "select count(*) from voluntario",
            nativeQuery = true
    )
    Integer contarVoluntario();
	
}
