package com.sistema.olla.servicio;

import com.sistema.olla.usuario.Usuario;
import com.sistema.olla.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario loggin(String user) {
        return usuarioRepository.loggin(user);
    }
}
