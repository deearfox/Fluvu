package br.com.fiap.fluvu.serviceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.fluvu.model.Central;
import br.com.fiap.fluvu.repository.CentralRepository;
import br.com.fiap.fluvu.service.CentralService;

@Service
public class CentralServiceImplements implements CentralService {

    private CentralRepository centralRepository;

    public CentralServiceImplements(CentralRepository centralRepository) {
        super();
        this.centralRepository = centralRepository;
    }

    @Override
    public List<Central> getAllCentrais(){
        return centralRepository.findAll();
    }

    @Override
    public Central salvarCentral(Central central){
        return centralRepository.save(central);
    }

    @Override
    public Central getCentralById(long id){
        return centralRepository.findById(id).get();
    }

    @Override
    public Central atualizarCentral (Central central){
        return centralRepository.save(central);
    }

    @Override
    public void excluirCentralById(long id) {
        centralRepository.deleteById(id);
        
    }
    
}
