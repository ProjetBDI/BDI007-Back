package fr.uga.miage.m1.departement;

import fr.uga.miage.m1.repository.DepartementRepository;
import fr.uga.miage.m1.service.DepartementService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {

    @Mock
    DepartementRepository departementRepository;

    @InjectMocks
    DepartementService departementService;

    @Test
    public void test() {
//        Departement mockDepartement = new Departement();
//        Mockito.when(departementRepository.save(mockDepartement)).thenReturn(mockDepartement);
//
//        departementService.save(departement);

//        Assert.assertNotNull(departementSaved);
    }

}
