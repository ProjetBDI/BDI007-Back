CREATE OR REPLACE PROCEDURE procedure_update_festival_by_panier_etape(
    id_festival IN NUMBER,
    nb_prises IN NUMBER
) AS
    nb_pass_dispo_festival NUMBER DEFAULT 0;
    nb_pass_vendus_festival NUMBER DEFAULT 0;
    nb_pass_total_festival NUMBER DEFAULT 0;
    nb_pass_indispo_festival NUMBER DEFAULT 0;
BEGIN
    SELECT
        F.nb_pass_dispo INTO nb_pass_dispo_festival,
        F.nb_pass_vendus INTO nb_pass_vendus_festival,
        F.nb_pass_total INTO nb_pass_total_festival,
        F.nb_pass_indispo INTO nb_pass_indispo_festival
    FROM festival F
    WHERE F.id_festival = id_festival;

    nb_pass_dispo_festival := nb_pass_dispo_festival - nb_prises;
    IF nb_pass_dispo_festival < 0
        THEN RAISE_APPLICATION_ERROR(-20002, 'Il n y a pas assez de pass disponibles pour ce festival');
    END IF;

    nb_pass_vendus_festival := nb_pass_vendus_festival + nb_prises;
    IF nb_pass_vendus_festival > nb_pass_total_festival
        THEN RAISE_APPLICATION_ERROR(-20003, 'Nombre de pass vendus supérieur au nombre total de pass');
    ELSIF nb_pass_total_festival =! (nb_pass_dispo_festival + nb_pass_vendus_festival + nb_pass_indispo_festival)
        THEN RAISE_APPLICATION_ERROR(-20004, 'Incoherence dans le nombre de pass')
    ENDIF;

    UPDATE FESTIVAL F
    SET F.NB_PASS_DISPO = nb_pass_dispo_festival, F.NB_PASS_VENDUS = nb_pass_vendus_festival
    WHERE F.ID_FESTIVAL = id_festival;
END;
/