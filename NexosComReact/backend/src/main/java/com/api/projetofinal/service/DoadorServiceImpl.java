package com.api.projetofinal.service;

import com.api.projetofinal.model.Doador;
import com.api.projetofinal.repository.DoadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorServiceImpl implements DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    @Override
    public Doador salvarDoadores(Doador doador) {
        return doadorRepository.save(doador);
    }

    @Override
    public List<Doador> getAllDoadores() {
        return doadorRepository.findAll();
    }
}
