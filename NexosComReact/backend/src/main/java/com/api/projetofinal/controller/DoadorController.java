package com.api.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetofinal.model.Doador;
import com.api.projetofinal.service.DoadorService;

@RestController
@RequestMapping("/doador")
@CrossOrigin
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @PostMapping("/add")
    public String add(@RequestBody Doador doador) {
        doadorService.salvarDoadores(doador);
        return "Novo doador foi adicionado";
    }

    @GetMapping("/getAll")
    public List<Doador> getAllDoadores() {
        return doadorService.getAllDoadores();
    }
}
