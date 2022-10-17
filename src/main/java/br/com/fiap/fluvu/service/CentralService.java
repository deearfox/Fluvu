package br.com.fiap.fluvu.service;

import java.util.List;

import br.com.fiap.fluvu.model.Central;

public interface CentralService {

    List<Central> getAllCentrais();

    Central salvarCentral(Central central);

    Central getCentralById(long id);

    Central atualizarCentral(Central central);

    void excluirCentralById(long id);
    
}
