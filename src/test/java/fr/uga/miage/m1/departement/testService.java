package fr.uga.miage.m1.departement;

import fr.uga.miage.m1.model.Departement;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fr.uga.miage.m1.repository.DepartementRepository;
import fr.uga.miage.m1.service.DepartementService;

import org.mockito.Mock;

@SpringBootTest
public class testService {

    @Mock
    DepartementRepository departementRepository;

    @InjectMocks
    DepartementService departementService;

    @Test
    public void test() {
        Departement departement = new Departement();
        Mockito.when(departementRepository.save(departement)).thenReturn(departement);

        departementService.save(departement);

        assertNotNull(departementSaved);
    }

}
