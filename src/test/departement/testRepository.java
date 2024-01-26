package departement;

import fr.uga.miage.m1.model.Departement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@SpringBootTest
public class testRepository {

    @Autowired
    private DepartementRepository departementRepository;

    @Test
    public void test() {

        Departement departement = new Departement();
        departementRepository.save(departement);

        assertNotNull(departementRepository.findById(departement));
    }
}