package com.api.projetofinal.service;

import com.api.projetofinal.model.Produto;
import java.util.List;

public interface ProdutoService {
    public Produto salvarProdutos(Produto produto);

    public List<Produto> getAllProdutos();
}
