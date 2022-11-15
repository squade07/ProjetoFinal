package com.api.projetofinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.api.projetofinal.model.Usuario;
import com.api.projetofinal.model.Role;
import com.api.projetofinal.dto.UsuarioRoleDTO;
import com.api.projetofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario execute(UsuarioRoleDTO usuarioRoleDTO) {

        Optional<Usuario> userExists = usuarioRepository.findById(usuarioRoleDTO.getIdUsuarios());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }

        roles = usuarioRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        Usuario usuario = userExists.get();

        usuario.setRoles(roles);

        usuarioRepository.save(usuario);

        return usuario;

    }
}