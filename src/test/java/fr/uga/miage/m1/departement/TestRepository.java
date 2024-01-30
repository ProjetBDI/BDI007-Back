package fr.uga.miage.m1.departement;

import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.*;
import fr.uga.miage.m1.repository.CommuneRepository;
import fr.uga.miage.m1.repository.CovoiturageRepository;
import fr.uga.miage.m1.repository.DepartementRepository;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private List<Commune> communes = new ArrayList<>();

    private Departement departement = new Departement();

    public TestRepository() {
        Commune commune = new Commune();
        commune.setNomCommune("TestVille");
        commune.setCodePostal("12345");
        commune.setCodeINSEE("123456789");
        commune.setLongitude("1.0");
        commune.setLatitude("1.0");

        this.communes.add(commune);

        this.departement.setNomDepartement("TestDepartement");
        this.departement.setCommunes(communes);
        this.departement.setNumDepartement("01");
        this.departement.setNomRegion("TestRegion");
    }

    @Test
    public void testFindByIdCommune() {
        Commune commune = new Commune();
        commune.setNomCommune("TestVille");
        commune.setCodePostal("12345");
        commune.setCodeINSEE("123456789");
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
    public void testFindByIdCvoiturage() {
        // Given
        Covoiturage covoiturage = new Covoiturage();
        covoiturage.setCouleur("Rouge");
        covoiturage.setMarque("Renault");
        covoiturage.setModele("Clio");
        covoiturage.setNbPlaceDispo(5);
        covoiturage.setNbPlace(5);

        List<Etape> etapes = new ArrayList<>();
        Etape etape = new Etape();
        etape.setPrixEtape(10.0f);

        List<PanierEtape> panierEtapes = new ArrayList<>();
        PanierEtape panierEtape = new PanierEtape();
//        panierEtape.set(etape);
//        panierEtape.setPanier(covoiturage);
//        panierEtapes.add(panierEtape);
//        covoiturage.setPanierEtapes(panierEtapes);

//        etape.setPanierEtapes();
//        etape.setHeureArrivee("12:00");
//        etape.setHeureDepart("11:00");
//        etape.setJour("Lundi");
//        etape.setNumeroEtape(1);
//
//        covoiturage.setEtapes();
//        covoiturage.setAnnee(2010);


//        Departement departement = new Departement();
//        departement.setNomDepartement("TestDepartement");
//        List<Commune> communes = new ArrayList<>();
//        communes.add(commune);
//        departement.setCommunes(communes);
//        departement.setNumDepartement("01");
//        departement.setNomRegion("TestRegion");
//        departementRepository.save(departement);
//        communeRepository.save(commune);
//
//        assertNotNull(commune.getIdCommune());


        // When
//        Commune foundCommune = communeRepository.findById(commune.getIdCommune()).orElse(null);
//
//        // Then
//        assertNotNull(foundCommune);
//        assertEquals(commune.getIdCommune(), foundCommune.getIdCommune());
    }
}