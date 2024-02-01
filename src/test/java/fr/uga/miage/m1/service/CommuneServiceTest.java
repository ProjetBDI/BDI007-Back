package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.CommuneRepository;
import fr.uga.miage.m1.repository.DepartementRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Log
class CommuneServiceTest {
    @Autowired
    private CommuneService communeService;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private CommuneRepository communeRepository;
    private Commune communeA;
    private Commune communeB;
    private final Departement departementA = new Departement();
    private Departement departementB;

    @BeforeAll
    void setUp() {
//        departementA = new Departement();
        departementA.setNomDepartement("DepartementA");
        departementA.setNomRegion("RegionA");
        departementA.setNumDepartement("12");

        departementB = new Departement();
        departementB.setNomDepartement("DepartementB");
        departementB.setNomRegion("RegionB");
        departementB.setNumDepartement("21");

        departementRepository.save(departementA);
        departementRepository.save(departementB);

        communeA = new Commune();
        communeA.setNomCommune("CommuneA");
        communeA.setCodeINSEE("123456");
        communeA.setCodePostal("12345");
        communeA.setLatitude("12,34");
        communeA.setLongitude("-12,34");
        communeA.setIdDepartement(departementA);

        communeB = new Commune();
        communeB.setNomCommune("CommuneB");
        communeB.setCodeINSEE("543210");
        communeB.setCodePostal("54321");
        communeB.setLatitude("54,32");
        communeB.setLongitude("-54,32");
        communeB.setIdDepartement(departementB);

        communeRepository.save(communeA);
        communeRepository.save(communeB);

    }

    @Test
    void getById() {
        assertEquals("CommuneA", communeService.getById(1L).getNomCommune());
        assertEquals(2, communeService.getById(2L).getIdCommune());
    }

    @Test
    void getAllCommunes() {
        assertEquals(2, communeService.getAllCommunes().size());
        assertEquals("CommuneA", communeService.getAllCommunes().get(0).getNomCommune());
        assertEquals("CommuneB", communeService.getAllCommunes().get(1).getNomCommune());
    }

    @Test
    void getByNom() {
        assertEquals(1, communeService.getByNom("CommuneB").size());
        assertEquals("CommuneB", communeService.getByNom("CommuneB").get(0).getNomCommune());

        assertEquals(0, communeService.getByNom("Commune").size());
    }

    @Test
    void deleteById() {
        assertEquals("CommuneA", communeService.getAllCommunes().get(0).getNomCommune());
        assertEquals(2, communeService.getAllCommunes().size());
        communeService.deleteById(1L);
        assertEquals(1, communeService.getAllCommunes().size());
        assertEquals("CommuneB", communeService.getAllCommunes().get(0).getNomCommune());
    }

}
