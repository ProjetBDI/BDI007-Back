-- PANIER_ETAPE
CREATE INDEX IDX_PANIER_ETAPE_ID_ETAPE ON PANIER_ETAPE (ID_ETAPE);
CREATE INDEX IDX_PANIER_ETAPE_ID_PANIER ON PANIER_ETAPE (ID_PANIER);

-- ETAPE
CREATE INDEX IDX_ETAPE_ID_COVOITURAGE ON ETAPE (ID_COVOITURAGE);
CREATE INDEX IDX_ETAPE_ID_LIEU ON ETAPE (ID_LIEU);

-- COVOITURAGE
CREATE INDEX IDX_COVOITURAGE_NB_PLACE ON COVOITURAGE (NB_PLACE);
CREATE INDEX IDX_COVOITURAGE_NB_PLACE_DISPO ON COVOITURAGE (NB_PLACE_DISPO);