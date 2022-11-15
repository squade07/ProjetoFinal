package com.api.projetofinal.service;

import com.api.projetofinal.model.Escola;
import java.util.List;

public interface EscolaService {
    public Escola salvarEscolas(Escola escola);

    public List<Escola> getAllEscolas();
}
