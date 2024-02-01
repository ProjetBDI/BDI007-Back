package fr.uga.miage.m1.departement;

import fr.uga.miage.m1.enums.FestivalStatus;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.*;
import fr.uga.miage.m1.repository.*;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
    private CovoiturageRepository covoiturageRepository;

    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private final List<Commune> communes = new ArrayList<>();

    private final List<Festival> festivals = new ArrayList<>();
    private final Commune commune = new Commune();
    private final Departement departement = new Departement();
    private final Festival festival = new Festival();
    private final Domaine domaine = new Domaine();

    private final Utilisateur utilisateur = new Utilisateur();

    public TestRepository() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        Date dateDebut = calendar.getTime();

        calendar.set(2023, Calendar.AUGUST, 15);
        Date dateFin = calendar.getTime();

        this.utilisateur.setEmail("test@test.com");
        this.utilisateur.setNom("TestNom");
        this.utilisateur.setPrenom("TestPrenom");
        this.utilisateur.setMotDePasse("TestMotDePasse");
        this.utilisateur.setDateNaissance(dateDebut);
        this.utilisateur.setTelephone("0123456789");


        this.commune.setNomCommune("TestVille");
        this.commune.setCodePostal("12345");
        this.commune.setCodeINSEE("123456789");
        this.commune.setLongitude("1.0");
        this.commune.setLatitude("1.0");

        this.communes.add(this.commune);

        this.departement.setNomDepartement("TestDepartement");
        this.departement.setCommunes(communes);
        this.departement.setNumDepartement("01");
        this.departement.setNomRegion("TestRegion");

        this.domaine.setNomDomaine("TestDomaine");
        this.domaine.setSousDomaines("TestSousDomaine");

        this.festival.setNom("TestFestival");


        this.festival.setDateDebut(dateDebut);
        this.festival.setDateFin(dateFin);
        this.festival.setSiteWeb("www.test.com");
        this.festival.setLieuPrincipal("TestLieu");
        this.festival.setNbPassTotal(100);
        this.festival.setNbPassIndispo(25);
        this.festival.setNbPassDispo(50);
        this.festival.setTarifPass(25);
        this.festival.setStatus(FestivalStatus.OUVERT);
        this.festival.setIdCommune(commune);

        this.festival.setIdDomaine(this.domaine);

        this.festivals.add(this.festival);
        this.domaine.setFestivals(this.festivals);




    }

    @Test
    public void testFindByIdCommune() {
        Commune commune = new Commune();
        commune.setCodeINSEE("123456789");
        commune.setCodePostal("12345");
        commune.setNomCommune("TestVille");
        commune.setLongitude("1.0");
        commune.setLatitude("1.0");
        commune.setIdDepartement(departement);

        departementRepository.save(departement);
        communeRepository.save(commune);

        // When
        Commune foundCommune = communeRepository.findById(commune.getIdCommune()).orElse(null);

        // Then
        assertNotNull(foundCommune);
        assertEquals(commune.getIdCommune(), foundCommune.getIdCommune());
    }

    @Test
    public void testFindByEmailUtilisateur() {

        utilisateurRepository.save(this.utilisateur);

//        Utilisateur


    }
}