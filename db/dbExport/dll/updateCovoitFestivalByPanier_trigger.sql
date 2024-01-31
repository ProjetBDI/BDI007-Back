CREATE OR REPLACE TRIGGER update_covoit_festival_by_panier_trigger
BEFORE UPDATE OF date_paiement ON panier
FOR EACH ROW
WHEN (OLD.date_paiement IS NULL AND NEW.date_paiement IS NOT NULL)
DECLARE
    nb_prises NUMBER;
    id_festival NUMBER;
BEGIN
    -- Logique du premier traitement
    procedure_update_covoiturage_by_panier_etape(:old.id_panier, nb_prises, id_festival);

    -- Logique du deuxième traitement
    procedure_update_festival_by_panier_etape(id_festival, nb_prises);
END;
/