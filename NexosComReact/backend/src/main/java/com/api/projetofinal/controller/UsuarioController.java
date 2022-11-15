package com.api.projetofinal.controller;

import com.api.projetofinal.model.Usuario;
import com.api.projetofinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }
    @GetMapping("/getAll")
    public List<Usuario> getAllUsuarios(){
        return  usuarioService.getAllUsuarios();
    }
}
