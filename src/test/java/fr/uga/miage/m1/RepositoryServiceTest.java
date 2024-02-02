package fr.uga.miage.m1;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.enums.FestivalStatus;
import fr.uga.miage.m1.enums.TypeLieu;
import fr.uga.miage.m1.mapper.*;
import fr.uga.miage.m1.model.*;
import fr.uga.miage.m1.repository.*;
import fr.uga.miage.m1.service.*;
import lombok.extern.java.Log;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Log
class RepositoryServiceTest {

    @Autowired
    private CommuneMapper communeMapper;

    @Autowired
    private DepartementMapper departementMapper;

    @Autowired
    private DomaineMapper domaineMapper;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Autowired
    private FestivalMapper festivalMapper;

    @Autowired
    private CovoiturageMapper covoiturageMapper;

    @Autowired
    private LieuMapper lieuMapper;

    @Autowired
    private EtapeMapper etapeMapper;

    @Autowired
    private PanierMapper panierMapper;

    @Autowired
    private PanierEtapeMapper panierEtapeMapper;

    @Autowired
    private CommuneService communeService;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private DomaineService domaineService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private FestivalService festivalService;

    @Autowired
    private CovoiturageService covoiturageService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LieuService lieuService;

    @Autowired
    private EtapeService etapeService;

    @Autowired
    private PanierService panierService;

    @Autowired
    private PanierEtapeService panierEtapeService;

    @Autowired
    private CommuneRepository communeRepository;

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

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private PanierEtapeRepository panierEtapeRepository;


    private final Commune commune = new Commune();
    private final Departement departement = new Departement();
    private final Festival festival = new Festival();
    private final Domaine domaine = new Domaine();
    private final Utilisateur utilisateur = new Utilisateur();
    private final Covoiturage covoiturage = new Covoiturage();
    private final Lieu lieu = new Lieu();
    private final Etape etape = new Etape();
    private final Panier panier = new Panier();
    private final PanierEtape panierEtape = new PanierEtape();

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
        covoiturage.setIdFestival(festival);
        covoiturageRepository.save(covoiturage);


        lieu.setAdresse("TestAdresse");
        lieu.setNom("TestLieu");
        lieu.setLatitude(1.0f);
        lieu.setLongitude(1.0f);
        lieu.setCodeINSEELieu("123456789");
        lieu.setTypeLieu(TypeLieu.AUTOSTOP);
        lieuRepository.save(lieu);


        etape.setPrixEtape(25);
        etape.setDureeDepuisDepart(25);
        etape.setIdLieu(lieu);
        etape.setIdCovoiturage(covoiturage);
        etapeRepository.save(etape);


        panier.setDatePaiement(dateDebut);
        panier.setNomsFestivaliers("TestFestivalier");
        //panier.setIdProprietaire(utilisateur);
        panierRepository.save(panier);


        panierEtape.setNbPlaceOccuppe(25L);
        panierEtape.setIdEtape(etape);
        panierEtape.setIdPanier(panier);
        panierEtapeRepository.save(panierEtape);
    }

    @AfterAll
    void cleanUp() {
        etapeRepository.delete(etape);
        lieuRepository.delete(lieu);
        covoiturageRepository.delete(covoiturage);
        utilisateurRepository.delete(utilisateur);
        festivalRepository.delete(festival);
        domaineRepository.delete(domaine);
        communeRepository.delete(commune);
        departementRepository.delete(departement);
    }

    @Test
    void findByIdDepartementTest() {

        // When
        Departement foundDepartement = departementRepository.findById((long) departement.getIdDepartement()).orElse(null);

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

    @Test
    void findByIdPanierTest() {

        Panier foundPanier = panierRepository.findById(this.panier.getIdPanier()).orElse(null);

        //then
        Assertions.assertNotNull(foundPanier);
        Assertions.assertEquals(this.panier.getIdPanier(), foundPanier.getIdPanier());
    }

    @Test
    void findByIdPanierEtapeTest() {

        PanierEtape foundPanierEtape = panierEtapeRepository.findById(this.panierEtape.getIdPanierEtape()).orElse(null);

        //then
        Assertions.assertNotNull(foundPanierEtape);
        Assertions.assertEquals(this.panierEtape.getIdPanierEtape(), foundPanierEtape.getIdPanierEtape());
    }

    @Test
    void findByEmailUtilisateur() {

        // When
        UtilisateurDTO foudUtilisateurDTO = utilisateurService.getByEmail("test@test.com");
        Utilisateur foudUtilisateur = utilisateurMapper.dtoToEntity(foudUtilisateurDTO);

        // Then
        Assertions.assertNotNull(foudUtilisateur);
        Assertions.assertEquals(foudUtilisateur.getEmail(), utilisateur.getEmail());
    }


    @Test
    void getPanierByPanierEtapeTest() {
        // When
        List<PanierEtapeDTO> panierEtapeDTO = panierEtapeService.getPanierByPanierEtape(panier.getIdPanier());
        Panier panierTest = panierMapper.dtoToEntity(panierEtapeDTO.get(0).getIdPanier());
        // Then
        Assertions.assertNotNull(panierTest);
        Assertions.assertEquals(panierTest.getIdPanier(), panier.getIdPanier());
    }

    @Test
    void getAllPanierEtapesTest() {
        // When
        List<PanierEtapeDTO> panierEtapes = panierEtapeService.getAllPanierEtapes();
        PanierEtape panierEtapeTest = panierEtapeMapper.dtoToEntity(panierEtapes.get(0));
        // Then
        Assertions.assertNotNull(panierEtapeTest);
    }

    @Test
    void getAllDomainesTest() {
        // When
        List<DomaineDTO> domaines = domaineService.getAllDomaines();
        Domaine domaineTest = domaineMapper.dtoToEntity(domaines.get(0));
        // Then
        Assertions.assertNotNull(domaineTest);
    }

    @Test
    void getAllCovoituragesByFestivalUsingPagesTest() {
        // When
        List<CovoiturageDTO> covoiturages = covoiturageService.getAllCovoituragesByFestivalUsingPages(1, festival.getIdFestival());
        Covoiturage covoiturageTest = covoiturageMapper.dtoToEntity(covoiturages.get(0));
        // Then
        Assertions.assertNotNull(covoiturageTest);
    }
//
//    @Test
//    void envoyerEmailTest() throws IOException {
//        // When
//        boolean emailSent = emailService.envoyerEmail("test.test@gmail.com", "test sujet", "msg de test");
//        // Then
//        Assertions.assertTrue(emailSent);
//    }
}