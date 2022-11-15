package com.api.projetofinal.service;

import com.api.projetofinal.model.Escola;
import com.api.projetofinal.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaServiceImpl implements EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    @Override
    public Escola salvarEscolas(Escola escola) {
        return escolaRepository.save(escola);
    }

    @Override
    public List<Escola> getAllEscolas() {
        return escolaRepository.findAll();
    }
}
