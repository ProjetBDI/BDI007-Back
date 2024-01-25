create global temporary table CHAZEAUV.HTE_UTILISATEUR
(
    ID_UTILISATEUR NUMBER(19),
    DATE_NAISSANCE DATE,
    EMAIL          VARCHAR2(255 char),
    MOT_DE_PASSE   VARCHAR2(255 char),
    NOM            VARCHAR2(255 char),
    PRENOM         VARCHAR2(255 char),
    TELEPHONE      VARCHAR2(255 char),
    RN_            NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_DEPARTEMENT
(
    ID_DEPARTEMENT  NUMBER(10),
    NOM_DEPARTEMENT VARCHAR2(255 char),
    NOM_REGION      VARCHAR2(255 char),
    NUM_DEPARTEMENT VARCHAR2(255 char),
    RN_             NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_COVOITURAGE
(
    ID_COVOITURAGE NUMBER(19),
    COULEUR        VARCHAR2(255 char),
    DATE_DEPART    TIMESTAMP(6),
    ID_CONDUCTEUR  NUMBER(19),
    ID_FESTIVAL    NUMBER(19),
    MARQUE         VARCHAR2(255 char),
    MODELE         VARCHAR2(255 char),
    NB_PLACE       NUMBER(10),
    NB_PLACE_DISPO NUMBER(10),
    RN_            NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_DOMAINE
(
    ID_DOMAINE       NUMBER(10),
    NOM_DOMAINE      VARCHAR2(255 char),
    NOM_SOUS_DOMAINE VARCHAR2(255 char),
    RN_              NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_ETAPE
(
    ID_ETAPE            NUMBER(19),
    DUREE_DEPUIS_DEPART NUMBER(10),
    ID_COVOITURAGE      NUMBER(19),
    ID_LIEU             NUMBER(19),
    PRIX_ETAPE          FLOAT(24),
    RN_                 NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_PANIER_ETAPE
(
    ID_PANIER_ETAPE  NUMBER(19),
    ID_ETAPE         NUMBER(19),
    ID_PANIER        NUMBER(19),
    NB_PLACE_OCCUPPE NUMBER(19),
    RN_              NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_COMMUNE
(
    ID_COMMUNE     NUMBER(19),
    CODE_INSEE     VARCHAR2(255 char),
    CODE_POSTAL    VARCHAR2(255 char),
    ID_DEPARTEMENT NUMBER(10),
    LATITUDE       VARCHAR2(255 char),
    LONGITUDE      VARCHAR2(255 char),
    NOM_COMMUNE    VARCHAR2(255 char),
    RN_            NUMBER(10) not null
        primary key
)
    on commit delete rows
/

create global temporary table CHAZEAUV.HTE_FESTIVAL
(
    ID_FESTIVAL     NUMBER(19),
    DATE_DEBUT      DATE,
    DATE_FIN        DATE,
    ID_COMMUNE      NUMBER(19),
    ID_DOMAINE      NUMBER(10),
    LIEU_PRINCIPAL  VARCHAR2(255 char),
    NB_PASS_DISPO   NUMBER(10),
    NB_PASS_INDISPO NUMBER(10),
    NB_PASS_TOTAL   NUMBER(10),
    NOM             VARCHAR2(255 char),
    SITE_WEB        VARCHAR2(255 char),
    STATUS          NUMBER(5),
    TARIF_PASS      FLOAT(24),
    RN_             NUMBER(10) not null
        primary key
)
    on commit delete rows
/

---------- TABLES ------------

create table CHAZEAUV.DEPARTEMENT
(
    ID_DEPARTEMENT  NUMBER(10)         not null primary key,
    NOM_DEPARTEMENT VARCHAR2(255 char) not null,
    NOM_REGION      VARCHAR2(255 char),
    NUM_DEPARTEMENT VARCHAR2(255 char) not null
)
/

create table CHAZEAUV.COMMUNE
(
    ID_COMMUNE     NUMBER(19)         not null  primary key,
    CODE_INSEE     VARCHAR2(255 char) not null,
    CODE_POSTAL    VARCHAR2(255 char) not null,
    LATITUDE       VARCHAR2(255 char) not null,
    LONGITUDE      VARCHAR2(255 char) not null,
    NOM_COMMUNE    VARCHAR2(255 char) not null,
    COORD_COMMUNE  SDO_GEOMETRY,
    ID_DEPARTEMENT NUMBER(10)         not null
        constraint FK_COMMUNE_DEPARTEMENT
            references CHAZEAUV.DEPARTEMENT
)
/

create table CHAZEAUV.DOMAINE
(
    ID_DOMAINE       NUMBER(10)         not null    primary key,
    NOM_DOMAINE      VARCHAR2(255 char) not null,
    NOM_SOUS_DOMAINE VARCHAR2(255 char),
    constraint UNQ_NOMDOMAINE_NOMSOUSDOMAINE
        unique (NOM_DOMAINE, NOM_SOUS_DOMAINE)
)
/

create table CHAZEAUV.FESTIVAL
(
    ID_FESTIVAL     NUMBER(19) not null primary key,
    DATE_DEBUT      DATE,
    DATE_FIN        DATE,
    LIEU_PRINCIPAL  VARCHAR2(255 char),
    NB_PASS_DISPO   NUMBER(10),
    NB_PASS_INDISPO NUMBER(10),
    NB_PASS_TOTAL   NUMBER(10),
    NOM             VARCHAR2(255 char),
    SITE_WEB        VARCHAR2(255 char),
    STATUS          NUMBER(5),
    TARIF_PASS      FLOAT(24),
    ID_COMMUNE      NUMBER(19)
        constraint FK_FESTIVAL_COMMUNE
            references CHAZEAUV.COMMUNE,
    ID_DOMAINE      NUMBER(10)
        constraint FK_FESTIVAL_DOMAINE
            references CHAZEAUV.DOMAINE
)
/

create table CHAZEAUV.LIEU
(
    ID_LIEU         NUMBER(19) not null primary key,
    ADRESSE         VARCHAR2(255 char) not null,
    CODE_INSEE_LIEU VARCHAR2(255 char) not null,
    LATITUDE        FLOAT(24)          not null,
    LONGITUDE       FLOAT(24)          not null,
    NOM             VARCHAR2(255 char) not null,
    TYPE_LIEU       VARCHAR2(255 char) not null,
    coord_lieu      SDO_GEOMETRY,
    ID_COMMUNE      NUMBER(19)
        constraint FK_LIEU_COMMUNE
            references CHAZEAUV.COMMUNE
)
/

create table CHAZEAUV.UTILISATEUR
(
    ID_UTILISATEUR NUMBER(19)         not null  primary key,
    DATE_NAISSANCE DATE       not null,
    EMAIL          VARCHAR2(255 char) not null,
    MOT_DE_PASSE   VARCHAR2(255 char),
    NOM            VARCHAR2(255 char) not null,
    PRENOM         VARCHAR2(255 char) not null,
    TELEPHONE      VARCHAR2(255 char)
)
/

create table CHAZEAUV.COVOITURAGE
(
    ID_COVOITURAGE NUMBER(19) not null  primary key,
    COULEUR        VARCHAR2(255 char),
    DATE_DEPART    TIMESTAMP(6),
    MARQUE         VARCHAR2(255 char),
    MODELE         VARCHAR2(255 char),
    NB_PLACE       NUMBER(10),
    NB_PLACE_DISPO NUMBER(10),
    ID_CONDUCTEUR  NUMBER(19)
        constraint FK_COVOITURAGE_CONDUCTEUR
            references CHAZEAUV.UTILISATEUR,
    ID_FESTIVAL    NUMBER(19)
        constraint FK_COVOITURAGE_FESTIVAL
            references CHAZEAUV.FESTIVAL
)
/

create table CHAZEAUV.ETAPE
(
    ID_ETAPE            NUMBER(19) not null primary key,
    DUREE_DEPUIS_DEPART NUMBER(10) not null,
    PRIX_ETAPE          FLOAT(24)  not null,
    ID_COVOITURAGE      NUMBER(19)
        constraint FK_ETAPE_COVOITURAGE
            references CHAZEAUV.COVOITURAGE,
    ID_LIEU             NUMBER(19)
        constraint FK_ETAPE_LIEU
            references CHAZEAUV.LIEU
)
/

create table CHAZEAUV.PANIER
(
    ID_PANIER         NUMBER(19) not null primary key,
    DATE_PAIEMENT     TIMESTAMP(6)       not null,
    NOMS_FESTIVALIERS TEXT not null,
    ID_PROPRIETAIRE   NUMBER(19)
        constraint FK_PANIER_PROPRIETAIRE
            references CHAZEAUV.UTILISATEUR
)
/

create table CHAZEAUV.PANIER_ETAPE
(
    ID_PANIER_ETAPE  NUMBER(19) not null    primary key,
    NB_PLACE_OCCUPPE NUMBER(19) not null,
    ID_ETAPE         NUMBER(19)
        constraint FK_PANIER_ETAPE_ETAPE
            references CHAZEAUV.ETAPE,
    ID_PANIER        NUMBER(19)
        constraint FK_PANIER_ETAPE_PANIER
            references CHAZEAUV.PANIER
)
/
