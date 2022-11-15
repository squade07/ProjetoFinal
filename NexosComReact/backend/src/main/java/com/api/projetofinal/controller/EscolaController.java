package com.api.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetofinal.model.Escola;
import com.api.projetofinal.service.EscolaService;

@RestController
@RequestMapping("/Escola")
@CrossOrigin
public class EscolaController {

    @Autowired
    private EscolaService EscolaService;

    @PostMapping("/add")
    public String add(@RequestBody Escola escola){
        EscolaService.salvarEscolas(escola);
        return "novo Escola foi adicionada";
    }

    @GetMapping("/getAll")
    public List<Escola> getAllEscolaes(){
        return  EscolaService.getAllEscolas();
    }
}
