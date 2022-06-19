package com.sistema.olla.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(
            value = "select * from usuario where user = :user ",
            nativeQuery = true
    )
    Usuario loggin(@Param("user")String user);

}
