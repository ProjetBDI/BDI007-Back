UPDATE COVOITURAGE j
SET j.NB_PLACE_DISPO = j.NB_PLACE - COALESCE((SELECT SUM(k.NB_PLACE_OCCUPPE)
                                              FROM PANIER_ETAPE k
                                                       JOIN Etape i ON k.ID_ETAPE = i.ID_ETAPE
                                              WHERE i.ID_COVOITURAGE = j.ID_COVOITURAGE), 0)
WHERE EXISTS (SELECT 1
              FROM Etape i
              WHERE i.ID_ETAPE IS NOT NULL);


--- Mettre à jour les nb_place = nb_place + valAbsolue(nb_place_dispo) quand nb_place < 0
UPDATE COVOITURAGE j
SET j.NB_PLACE = j.NB_PLACE + ABS(j.NB_PLACE_DISPO)
WHERE j.NB_PLACE_DISPO < 0;


UPDATE COVOITURAGE j
SET j.NB_PLACE_DISPO = j.NB_PLACE - COALESCE((SELECT SUM(k.NB_PLACE_OCCUPPE)
                                              FROM PANIER_ETAPE k
                                                       JOIN Etape i ON k.ID_ETAPE = i.ID_ETAPE
                                              WHERE i.ID_COVOITURAGE = j.ID_COVOITURAGE), 0)
WHERE EXISTS (SELECT 1
              FROM Etape i
              WHERE i.ID_ETAPE IS NOT NULL);

COMMIT;