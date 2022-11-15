package com.api.projetofinal.service;

import com.api.projetofinal.model.Usuario;
import com.api.projetofinal.repository.UsuarioRepository;
import com.api.projetofinal.security.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario existeUsuario = usuarioRepository.findBynomeFetchRoles(nome);
        if (existeUsuario != null) {
            throw new Error("Usuario ja existe!");
        }
        return UsuarioPrincipal.create(existeUsuario);
    }
}
