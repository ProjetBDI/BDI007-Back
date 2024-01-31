CREATE OR REPLACE PROCEDURE procedure_delete_festival_by_panier_etape(
       id_festival IN NUMBER,
       nb_places_liberees IN NUMBER
)
AS
    nb_pass_dispo_festival NUMBER DEFAULT 0;
    nb_pass_vendus_festival NUMBER DEFAULT 0;
BEGIN
    SELECT F.nb_pass_dispo into nb_pass_dispo_festival, F.nb_pass_vendus into nb_pass_vendus_festival
    FROM Festival F
    WHERE F.id_festival = id_festival;

    nb_pass_dispo_festival := nb_pass_dispo_festival + nb_places_liberees;
    nb_pass_vendus_festival := nb_pass_vendus_festival - nb_places_liberees;
    IF nb_pass_vendus_festival < 0 THEN
        RAISE_APPLICATION_ERROR(-20005, 'Le nombre de places vendues ne peut pas être négatif');
    END IF;
    UPDATE Festival F
    SET F.nb_pass_dispo = nb_pass_dispo_festival, F.nb_pass_vendus = nb_pass_vendus_festival
    WHERE F.id_festival = id_festival;
END;
/