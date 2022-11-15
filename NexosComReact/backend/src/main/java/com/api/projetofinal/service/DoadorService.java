package com.api.projetofinal.service;

import com.api.projetofinal.model.Doador;
import java.util.List;

public interface DoadorService {
    public Doador salvarDoadores(Doador doador);

    public List<Doador> getAllDoadores();
}
