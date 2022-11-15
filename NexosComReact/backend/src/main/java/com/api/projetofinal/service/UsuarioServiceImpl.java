package com.api.projetofinal.service;

import com.api.projetofinal.model.Usuario;
import com.api.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {

        Usuario existeUsuario = usuarioRepository.findBynome(usuario.getNome());
        if (existeUsuario != null) {
            throw new Error("Usuario ja existe!");
        }
        usuario.setSenha(passwordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
