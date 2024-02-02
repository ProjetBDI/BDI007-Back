package fr.uga.miage.m1.service;

import fr.uga.miage.m1.mapper.DepartementMapper;
import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.DepartementRepository;
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
class DepartementServiceTest {
    @Autowired
    private DepartementService departementService;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private DepartementMapper departementMapper;

    private Departement departementA;
    private Departement departementB;
    private Departement departementC;

    @BeforeEach
    void setUp() {
        departementA = new Departement();
        departementA.setNomDepartement("DepartementA");
        departementA.setNomRegion("RegionA");
        departementA.setNumDepartement("12");

        departementB = new Departement();
        departementB.setNomDepartement("DepartementB");
        departementB.setNomRegion("RegionB");
        departementB.setNumDepartement("21");

        departementRepository.save(departementA);
        departementRepository.save(departementB);

        departementC = new Departement();
    }

    @AfterEach
    void cleanUp() {
        departementRepository.deleteAll();
    }

    @Test
    void testSave() {
        departementC.setNomDepartement("DepartementC");
        departementC.setNomRegion("RegionC");
        departementC.setNumDepartement("33");
        departementService.save(departementMapper.entityToDTO(departementC));
        assertEquals(3, departementService.getAllDepartements().size());
    }

    @Test
    void testGetById() {
        assertEquals("DepartementA", departementService.getById((long) departementA.getIdDepartement()).getNomDepartement());
    }

    @Test
    void testGetAllDepartements() {
        assertEquals(2, departementService.getAllDepartements().size());
    }

    @Test
    void testDeleteById() {
        departementService.deleteById((long) departementA.getIdDepartement());
        assertEquals(1, departementService.getAllDepartements().size());
    }


    @Test
    void testDelete() {
        departementService.delete(departementA);
        assertEquals(1, departementService.getAllDepartements().size());
    }
}
