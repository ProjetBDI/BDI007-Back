package fr.uga.miage.m1;

import fr.uga.miage.m1.enums.FestivalStatus;
import fr.uga.miage.m1.enums.TypeLieu;
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
    private CommuneRepository communeRepository;

//    @Autowired
//    DepartementService departementService;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private DomaineRepository domaineRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private CovoiturageRepository covoiturageRepository;

    @Autowired
    private LieuRepository lieuRepository;

    @Autowired
    private EtapeRepository etapeRepository;

    private final Commune commune = new Commune();
    private final Departement departement = new Departement();
    private final Festival festival = new Festival();
    private final Domaine domaine = new Domaine();
    private final Utilisateur utilisateur = new Utilisateur();
    private final Covoiturage covoiturage = new Covoiturage();
    private final Lieu lieu = new Lieu();
    private final Etape etape = new Etape();

    @BeforeAll
    void initialisation() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        Date dateDebut = calendar.getTime();

        calendar.set(2023, Calendar.AUGUST, 15);
        Date dateFin = calendar.getTime();


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


        domaine.setNomDomaine("TestDomaine");
        domaineRepository.save(domaine);


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
        festivalRepository.save(festival);


        utilisateur.setEmail("test@test.com");
        utilisateur.setNom("TestNom");
        utilisateur.setPrenom("TestPrenom");
        utilisateur.setMotDePasse("TestMotDePasse");
        utilisateur.setDateNaissance(dateDebut);
        utilisateur.setTelephone("0123456789");
        utilisateurRepository.save(utilisateur);


        covoiturage.setNbPlace(4);
        covoiturage.setNbPlaceDispo(25);
        covoiturage.setModele("Clio");
        covoiturage.setMarque("Renault");
        covoiturage.setCouleur("Rouge");
        covoiturage.setDateDepart(dateDebut);
        covoiturageRepository.save(covoiturage);


        lieu.setAdresse("TestAdresse");
        lieu.setNom("TestLieu");
        lieu.setLatitude(1.0f);
        lieu.setLongitude(1.0f);
        lieu.setCodeINSEELieu("123456789");
        lieu.setTypeLieu(TypeLieu.AUTOSTOP);
        lieuRepository.save(lieu);


        //etape
        etape.setPrixEtape(25);
        etape.setDureeDepuisDepart(25);
        etape.setIdLieu(lieu);
        etape.setIdCovoiturage(covoiturage);
        etapeRepository.save(etape);

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
    void findByIdDomaineTest() {

        // When
        Domaine foundDomaine = domaineRepository.findById((long) domaine.getIdDomaine()).orElse(null);

        // Then
        Assertions.assertNotNull(foundDomaine);
        Assertions.assertEquals(domaine.getIdDomaine(), foundDomaine.getIdDomaine());
    }

    @Test
    void findByIdFestivalTest() {

        // When
        Festival foundFestival = festivalRepository.findById(festival.getIdFestival()).orElse(null);

        // Then
        Assertions.assertNotNull(foundFestival);
        Assertions.assertEquals(festival.getIdFestival(), foundFestival.getIdFestival());
    }

    @Test
    void findByIdUtilisateurTest() {

        // When
        Utilisateur foundUtilisateur = utilisateurRepository.findById(utilisateur.getIdUtilisateur()).orElse(null);

        // Then
        Assertions.assertNotNull(foundUtilisateur);
        Assertions.assertEquals(utilisateur.getIdUtilisateur(), foundUtilisateur.getIdUtilisateur());
    }

    @Test
    void findByIdCovoiturageTest() {

        Covoiturage foundCovoiturage = covoiturageRepository.findById(this.covoiturage.getIdCovoiturage()).orElse(null);

        //then
        Assertions.assertNotNull(foundCovoiturage);
        Assertions.assertEquals(this.covoiturage.getIdCovoiturage(), foundCovoiturage.getIdCovoiturage());

    }

    @Test
    void findByIdLieuTest() {

        Lieu foundLieu = lieuRepository.findById(this.lieu.getIdLieu()).orElse(null);

        //then
        Assertions.assertNotNull(foundLieu);
        Assertions.assertEquals(this.lieu.getIdLieu(), foundLieu.getIdLieu());

    }

    @Test
    void findByIdEtapeTest() {

        Etape foundEtape = etapeRepository.findById(this.etape.getIdEtape()).orElse(null);

        //then
        Assertions.assertNotNull(foundEtape);
        Assertions.assertEquals(this.etape.getIdEtape(), foundEtape.getIdEtape());

    }
}