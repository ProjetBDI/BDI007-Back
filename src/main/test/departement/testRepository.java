import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.DepartementRepository;

@SpringBootTest
public class testRepository {

    @Autowired
    private DepartementRepository departementRepository;

    @Test
    public void test() {

        Departement departement = new Departement();
        departementRepository.save(departement);

        assertNotNull(departementRepository.findById(departement.getId()));
    }
}