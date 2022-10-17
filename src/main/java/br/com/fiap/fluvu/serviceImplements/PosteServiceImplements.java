package br.com.fiap.fluvu.serviceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.fluvu.model.Poste;
import br.com.fiap.fluvu.repository.PosteRepository;
import br.com.fiap.fluvu.service.PosteService;

@Service
public class PosteServiceImplements implements PosteService {

    private PosteRepository posteRepository;

    public PosteServiceImplements(PosteRepository posteRepository) {
        super();
        this.posteRepository = posteRepository;
    }

    @Override
    public List<Poste> getAllPostes(){
        return posteRepository.findAll();
    }

    @Override
    public Poste salvarPoste(Poste poste){
        return posteRepository.save(poste);
    }

    @Override
    public Poste getPosteById(long id){
        return posteRepository.findById(id).get();
    }

    @Override
    public Poste atualizarPoste (Poste poste){
        return posteRepository.save(poste);
    }

    @Override
    public void excluirPosteById(long id) {
        posteRepository.deleteById(id);
        
    }
    
}

