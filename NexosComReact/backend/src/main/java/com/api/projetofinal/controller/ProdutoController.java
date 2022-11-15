package com.api.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetofinal.model.Produto;
import com.api.projetofinal.service.ProdutoService;

@RestController
@RequestMapping("/Produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/add")
    public String add(@RequestBody Produto produto){
        produtoService.salvarProdutos(produto);
        return "novo Produto foi adicionada";
    }
    @GetMapping("/getAll")
    public List<Produto> getAllProdutoes(){
        return  produtoService.getAllProdutos();
    }
}
