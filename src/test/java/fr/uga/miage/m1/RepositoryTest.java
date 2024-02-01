package fr.uga.miage.m1;

import fr.uga.miage.m1.enums.FestivalStatus;
import fr.uga.miage.m1.model.*;

import fr.uga.miage.m1.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,  properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryTest {

    @Autowired
    CommuneRepository communeRepository;

//    @Autowired
//    DepartementService departementService;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    private  static UtilisateurRepository utilisateurRepository;


    private static List<Commune> communes = new ArrayList<>();

    private static List<Festival> festivals = new ArrayList<>();
    private static Commune commune = new Commune();
    private Departement departement = new Departement();
    private static Festival festival = new Festival();
    private static Domaine domaine = new Domaine();

    private static Utilisateur utilisateur = new Utilisateur();

    @BeforeAll
    void initialisation() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        Date dateDebut = calendar.getTime();

        calendar.set(2023, Calendar.AUGUST, 15);
        Date dateFin = calendar.getTime();
        utilisateur.setEmail("test@test.com");
        utilisateur.setNom("TestNom");
        utilisateur.setPrenom("TestPrenom");
        utilisateur.setMotDePasse("TestMotDePasse");
        utilisateur.setDateNaissance(dateDebut);
        utilisateur.setTelephone("0123456789");

        departement.setIdDepartement(1);
        departement.setNomDepartement("TestDepartement");
        departement.setNumDepartement("01");
        departement.setNomRegion("TestRegion");
        departementRepository.save(departement);

        commune.setCodeINSEE("123456789");
        commune.setCodePostal("12345");
        commune.setNomCommune("TestVille");
        commune.setLongitude("1.0");
        commune.setLatitude("1.0");
        commune.setIdDepartement(departement);
        communeRepository.save(commune);

        communes.add(commune);

        departement.setNomDepartement("TestDepartement");
        departement.setCommunes(communes);
        departement.setNumDepartement("01");
        departement.setNomRegion("TestRegion");

        domaine.setNomDomaine("TestDomaine");
        domaine.setSousDomaines("TestSousDomaine");

        festival.setNom("TestFestival");


        festival.setDateDebut(dateDebut);
        festival.setDateFin(dateFin);
        festival.setSiteWeb("www.test.com");
        festival.setLieuPrincipal("TestLieu");
        festival.setNbPassTotal(100);
        festival.setNbPassIndispo(25);
        festival.setNbPassDispo(50);
        festival.setTarifPass(25);
        festival.setStatus(FestivalStatus.OUVERT);
        festival.setIdCommune(commune);

        festival.setIdDomaine(domaine);

        festivals.add(festival);
        domaine.setFestivals(festivals);

    }

    @Test
    void findByIdDepartementTest() {

        // When
        Departement foundDepartement = departementRepository.findById((long)departement.getIdDepartement()).orElse(null);

        // Then
        Assertions.assertNotNull(foundDepartement);
        Assertions.assertEquals(departement.getIdDepartement(), foundDepartement.getIdDepartement());
    }

    @Test
    void findByIdCommuneTest() {

        // When
        Commune foundCommune = communeRepository.findById(commune.getIdCommune()).orElse(null);

        // Then
        Assertions.assertNotNull(foundCommune);
        Assertions.assertEquals(commune.getIdCommune(), foundCommune.getIdCommune());
    }



    @Test
    void findByIdUtilisateurTest() {

        Utilisateur foundUtilisateur = utilisateurRepository.findById(this.utilisateur.getIdUtilisateur()).orElse(null);

        //then
        Assertions.assertNotNull(foundUtilisateur);
        Assertions.assertEquals(utilisateur.getIdUtilisateur(), foundUtilisateur.getIdUtilisateur());

    }

//    @Test
//    void findByIdCovoiturageTest() {
//
//        Covoiturage foundCovoiturage = covoiturageRepository.findById(this.covoiturage.getIdCovoiturage()).orElse(null);
//
//        //then
//        Assertions.assertNotNull(foundCovoiturage);
//        Assertions.assertEquals(this.covoiturage.getIdCovoiturage(), foundCovoiturage.getIdCovoiturage());
//
//    }

//    @Test
//    void findByIdDomaineTest() {
//
//        Domaine foundDomaine = domaineRepository.findById((long) this.domaine.getIdDomaine()).orElse(null);
//
//        //then
//        Assertions.assertNotNull(foundDomaine);
//        Assertions.assertEquals(this.domaine.getIdDomaine(), foundDomaine.getIdDomaine());
//    }

//    @Test
//    void findByIdFestivalTest() {
//
//        Festival foundFestival = festivalRepository.findById(this.festival.getIdFestival()).orElse(null);
//
//        //then
//        Assertions.assertNotNull(foundFestival);
//        Assertions.assertEquals(this.festival.getIdFestival(), foundFestival.getIdFestival());
//
//    }

}