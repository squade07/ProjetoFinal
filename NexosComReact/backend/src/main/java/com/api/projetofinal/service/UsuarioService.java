package com.api.projetofinal.service;

import com.api.projetofinal.model.Usuario;
import java.util.List;

public interface UsuarioService {
    public Usuario salvarUsuario(Usuario usuario);

    public List<Usuario> getAllUsuarios();
}
