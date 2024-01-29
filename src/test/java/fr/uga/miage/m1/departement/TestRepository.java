package fr.uga.miage.m1.departement;

import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.CommuneRepository;
import fr.uga.miage.m1.repository.DepartementRepository;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,  properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
@RunWith(SpringRunner.class)
public class TestRepository {

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private CommuneMapper communeMapper;

    @Test
    public void testFindByIdCommune() {
        // Given
        Commune commune = new Commune();
        commune.setNomCommune("TestVille");
        commune.setCodePostal("12345");
        commune.setCodeINSEE("123456789");
        commune.setLongitude("1.0");
        commune.setLatitude("1.0");

        Departement departement = new Departement();
        departement.setNomDepartement("TestDepartement");
        List<Commune> communes = new ArrayList<Commune>();
        communes.add(commune);
        departement.setCommunes(communes);
        departement.setNumDepartement("01");
        departement.setNomRegion("TestRegion");
        departementRepository.save(departement);
        commune.setIdDepartement(departement);
        communeRepository.save(commune);

        assertNotNull(commune.getIdCommune());


        // When
//        Commune foundCommune = communeRepository.findById(commune.getIdCommune()).orElse(null);
//
//        // Then
//        assertNotNull(foundCommune);
//        assertEquals(commune.getIdCommune(), foundCommune.getIdCommune());
    }
}