package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.mapper.DepartementMapper;
import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.DepartementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService {

    private final DepartementRepository departementRepository;
    private final DepartementMapper departementMapper;


    // SAVE
    public void save(DepartementDTO departement) {
        departementRepository.save(departementMapper.dtoToEntity(departement));
    }

    // GET
    public DepartementDTO getById(Long id) {
        return departementMapper.entityToDTO(departementRepository.findById(id).orElse(null));
    }

    // DELETE
    public void deleteById(Long id) {
        departementRepository.deleteById(id);
    }

    public void delete(Departement departement) {
        departementRepository.delete(departement);
    }

    //get All
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }
}
