package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.repository.DomaineRepository;

@Service
public class DomaineService {
    
    private final DomaineRepository domaineRepository;

    public DomaineService(DomaineRepository domaineRepository) {
        this.domaineRepository = domaineRepository;
    }

    // SAVE
    public Domaine save(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    // GET
    public Domaine getById(Long id) {
        return domaineRepository.findById(id).get();
    }

    public Domaine getByDomaine(String nomDomaine) {
        return domaineRepository.findByNomDomaine(nomDomaine);
    }

    public List<Domaine> getBySousDomaine(String sousDomaine) {
        return domaineRepository.findBySousDomaines(sousDomaine);
    }

    // DELETE

    public void delete(Long id) {
        domaineRepository.deleteById(id);
    }

    public void delete(Domaine domaine) {
        domaineRepository.delete(domaine);
    }

    //get All
    public List<Domaine> getAllDomaines(){return domaineRepository.findAll();}
}
