package br.com.fiap.fluvu.service;

import java.util.List;

import br.com.fiap.fluvu.model.Poste;

public interface PosteService {

    List<Poste> getAllPostes();

    Poste salvarPoste(Poste poste);

    Poste getPosteById(long id);

    Poste atualizarPoste(Poste poste);

    void excluirPosteById(long id);
    
}