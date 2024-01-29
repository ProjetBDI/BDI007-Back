package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.repository.DomaineRepository;
import org.springframework.stereotype.Service;

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
        return domaineRepository.findById(id).orElse(null);
    }


    public void delete(Long id) {
        domaineRepository.deleteById(id);
    }

    public void delete(Domaine domaine) {
        domaineRepository.delete(domaine);
    }

    //get All
    public Iterable<Domaine> getAllDomaines() {
        return domaineRepository.findAll();
    }
}
