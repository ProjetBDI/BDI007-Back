import pandas as pd

def main():
    # Charger vos données depuis un fichier ou une autre source
    # Par exemple, si vous avez un fichier CSV :
    df_festivals = pd.read_csv('Opendata_Projet.csv', encoding='ISO-8859-1')

    # Appeler les fonctions de traitement
    festival(df_festivals)
    commune(df_festivals)
    departement(df_festivals)
    region(df_festivals)
    lieu(df_festivals)



def lieu(df_festivals):

    df_covoiturage = pd.read_csv('Opendata_Projet_covoit.csv', encoding='ISO-8859-1')

    # Renommer les colonnes
    df_covoiturage = df_covoiturage.rename(columns={
        'idLieu': 'idLieu',
        'nomLieu': 'nomLieu',
        'adresseLieu': 'adresseLieu',
        'communeLIEU': 'commune',
        'codeINSEELieu': 'codeINSEELieu',
        'typeLieu': 'typeLieu',
        'longitude': 'longitude',
        'latitude': 'latitude'
    })

    # Sélectionner les colonnes nécessaires
    colonnes_covoiturage = ['idLieu', 'nomLieu', 'adresseLieu', 'commune', 'codeINSEELieu', 'typeLieu', 'longitude', 'latitude']

    # Supprimer les doublons pour obtenir des valeurs uniques
    df_covoiturage = df_covoiturage.drop_duplicates()

    # enlever les nan
    df_covoiturage = df_covoiturage.dropna()

    # Créer la table "Etape" avec les colonnes spécifiées
    df_covoiturage = df_covoiturage[colonnes_covoiturage]

    df_covoiturage.to_csv('Lieu.csv', index=False)

def region(df_festivals):
    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['region']

    df_festivals[colonnes_necessaires] = df_festivals[colonnes_necessaires].astype(str)

    df_region = df_festivals[colonnes_necessaires]

        # Supprimer les doublons pour obtenir des valeurs uniques
    df_region_unique = df_region.drop_duplicates()

        # enlever les nan
    df_region_unique = df_region_unique.dropna()

        # Enregistrer les résultats dans la feuille "region"
    df_region_unique.to_csv('Region.csv', index=False)


def departement(df_festivals):
    
    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['departement', 'departement2', 'region']

    df_festivals[colonnes_necessaires] = df_festivals[colonnes_necessaires].astype(str)

    df_departement = df_festivals[colonnes_necessaires]

    df_departement['departement'] = df_departement['departement'].str.replace('.0', '')

    # Supprimer les doublons pour obtenir des valeurs uniques
    df_departement_unique = df_departement.drop_duplicates()

    # enlever les nan
    df_departement_unique = df_departement_unique.dropna()

    # Renommer les colonnes
    df_departement_unique = df_departement_unique.rename(columns={
        'departement': 'departement',
        'departement2': 'nomDepartement',
        'nomRegion': 'nomRegion',
    })

    # Enregistrer les résultats dans la feuille "Departement"
    df_departement_unique.to_csv('Departement.csv', index=False)




def commune(df_festivals):
    

    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['codeINSEE', 'communeINSEE', 'codePostal', 'latitude', 'longitude', 'departement']

    df_festivals[colonnes_necessaires] = df_festivals[colonnes_necessaires].astype(str)

    df_festivals['codePostal'] = df_festivals['codePostal'].str.replace('.0', '')

    df_festivals['departement'] = df_festivals['departement'].str.replace('.0', '')

    df_commune = df_festivals[colonnes_necessaires]

    # Supprimer les doublons pour obtenir des valeurs uniques
    df_commune_unique = df_commune.drop_duplicates()

    # Enregistrer les résultats dans lun fichier "Commune.csv"
    df_commune_unique.to_csv('Commune.csv', index=False)
    
def sousDomaine(df_festivals):
    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['sousDomaine', 'domaine']

    df_festivals[colonnes_necessaires] = df_festivals[colonnes_necessaires].astype(str)
    
    df_sousDomaine = df_festivals[colonnes_necessaires]
    
    # Supprimer les doublons pour obtenir des valeurs uniques
    df_sousDomaine_unique = df_sousDomaine.drop_duplicates()
    
    # Enregistrer les résultats dans la feuille "sousDomaine"
    df_sousDomaine_unique.to_csv('sousDomaine.csv', index=False)
    




def festival(df_festivals):
    # Sélectionner les colonnes nécessaires
    # Remplacer les valeurs vides dans la colonne 'sousDomaine' par les valeurs de 'Domaine'
    df_festivals['sousDomaine'].fillna(df_festivals['domaine'], inplace=True)

    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['nomManifestation', 'dateDebut', 'dateFin', 'siteWEB', 'tarifPass', 'lieuPrincipal', 'codeINSEE', 'sousDomaine', ]

    df_commune = df_festivals[colonnes_necessaires]

    # Enregistrer les résultats dans la feuille "Commune"
    # Assurez-vous d'adapter le nom du fichier à votre situation
    df_commune.to_csv('Festival.csv', index=False)


def commune(df_festivals):
    # Sélectionner les colonnes nécessaires
    colonnes_necessaires = ['codeINSEE', 'communeINSEE', 'codePostal', 'latitude', 'longitude', 'departement']

    df_festivals[colonnes_necessaires] = df_festivals[colonnes_necessaires].astype(str)

    df_festivals['codePostal'] = df_festivals['codePostal'].str.replace('.0', '')

    df_festivals['departement'] = df_festivals['departement'].str.replace('.0', '')

    df_commune = df_festivals[colonnes_necessaires]

    # Supprimer les doublons pour obtenir des valeurs uniques
    df_commune_unique = df_commune.drop_duplicates()

    # Enregistrer les résultats dans lun fichier "Commune.csv"
    df_commune_unique.to_csv('/output/Commune.csv', index=False)
    
if __name__ == '__main__':
    main()
    