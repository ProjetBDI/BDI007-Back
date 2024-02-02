CREATE OR REPLACE TRIGGER delete_covoit_festival_by_pannier_trigger
BEFORE DELETE ON panier
FOR EACH ROW
DECLARE
    nb_places_liberees NUMBER;
    id_festival NUMBER;
BEGIN
    procedure_delete_covoiturage_by_panier_etape(:old.id_panier, nb_places_liberees, id_festival);
    procedure_delete_festival_by_panier_etape(id_festival);

END;
/