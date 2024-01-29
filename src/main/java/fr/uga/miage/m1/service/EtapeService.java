package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import org.springframework.stereotype.Service;

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
        return etapeRepository.findById(id).orElse(null);
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
