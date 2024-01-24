import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
        when(departementRepository.save(departement)).thenReturn(departement);

        Departement departementSaved = departementService.save(departement);

        assertNotNull(departementSaved);
    }

}
