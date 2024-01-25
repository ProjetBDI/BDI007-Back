package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;

@Service
public class EtapeService {
    
    private final EtapeRepository etapeRepository;

    public EtapeService(EtapeRepository etapeRepository) {
        this.etapeRepository = etapeRepository;
    }

    // SAVE
    public Etape save(Etape etape) {
        return etapeRepository.save(etape);
    }

    // GET
    public Etape getById(Long id) {
        return etapeRepository.findById(id).get();
    }



    public Iterable<Etape> getAllEtapes() {
        return etapeRepository.findAll();
    }

    // DELETE
    public void deleteById(Long id) {
        etapeRepository.deleteById(id);
    }

    public void delete(Etape etape) {
        etapeRepository.delete(etape);
    }
}
