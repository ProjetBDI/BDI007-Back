package fr.uga.miage.m1.service;

import fr.uga.miage.m1.mapper.DomaineMapper;
import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.repository.DomaineRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DomaineServiceTest {
    @Autowired
    private DomaineService domaineService;

    @Autowired
    private DomaineRepository domaineRepository;

    @Autowired
    private DomaineMapper domaineMapper;

    private Domaine domaineA;
    private Domaine domaineB;

    @BeforeEach
    void setUp() {
        domaineA = new Domaine();
        domaineA.setNomDomaine("DomaineA");
        domaineA.setSousDomaines("SousDomaineA");

        domaineB = new Domaine();
        domaineB.setNomDomaine("DomaineB");
        domaineB.setSousDomaines("SousDomaineB");

        domaineRepository.save(domaineA);
        domaineRepository.save(domaineB);
    }

    @AfterEach
    void cleanUp() {
        domaineRepository.deleteAll();
    }

    @Test
    void testSave() {
        Domaine domaineC = new Domaine();
        domaineC.setNomDomaine("DomaineC");
        domaineC.setSousDomaines("SousDomaineC");
        domaineService.save(domaineMapper.entityToDTO(domaineC));
        assertEquals(3, domaineService.getAllDomaines().size());
    }

    @Test
    void testGetAllDomaines() {
        assertEquals(2, domaineService.getAllDomaines().size());
    }

    @Test
    void testGetById() {
        assertEquals("DomaineB", domaineService.getById((long) domaineB.getIdDomaine()).getNomDomaine());
    }

    @Test
    void testDeleteById() {
        domaineService.delete((long) domaineA.getIdDomaine());
        assertEquals(1, domaineService.getAllDomaines().size());
    }

    @Test
    void testDelete() {
        domaineService.delete(domaineB);
        assertEquals(1, domaineService.getAllDomaines().size());
    }

}
