import random
import pandas as pd
from faker import Faker

def main():

    __path__ = '../dev/BDI007-Back/db'
    __pathDB__ = '../dev/BDI007-Back/db'

    df_commune = pd.read_csv(__path__+'/commune.csv', encoding='ISO-8859-1')

    df_festival = pd.read_csv(__path__+'/festival.csv', encoding='ISO-8859-1')
    df_festival = df_festival[:-1]
    # mettre tout en str dans festival
    df_festival['date_debut'] = df_festival['date_debut'].astype(str)
    df_festival['date_fin'] = df_festival['date_fin'].astype(str)

    df_utilisateur = pd.read_csv(__pathDB__+'/utilisateurs.csv', encoding='ISO-8859-1')

    df_covoiturage = pd.read_csv(__path__+'/covoiturages.csv', encoding='ISO-8859-1')

    df_panier = pd.read_csv('Panier2.csv', encoding='ISO-8859-1')

    df_etape = pd.read_csv(__path__+'/Etape2.csv', encoding='ISO-8859-1')

    df_lieu = pd.read_csv(__path__+'/lieu.csv', encoding='ISO-8859-1')



    # définir les noms des colonnes de panier_etape qui est une nouvelle table
    colonnes_panier_etape = ['id_panier_etape', 'id_etape', 'id_panier', 'nbPlaceOccupee']

    # créer la table panier_etape
    df_panier_etape = pd.DataFrame(columns=colonnes_panier_etape)



    for index,row in df_panier.copy().iterrows():
        nbEtapes = random.randint(1, 5)
        panier = df_panier.at[index, 'id_panier']
        for i in range(nbEtapes):
            random_index_etape = random.randint(0, len(df_etape) - 1)
            # il faut le nombre de noms dans la liste noms_festivaliers dans panier 
            nbFestivaliers = len([df_panier.at[index, 'noms_festivaliers']])
            # aller chercher le nb place dans covoiturage à partir de l'id covoiturage dans panier
            idCovoiturage = df_etape.at[index, 'id_covoiturage']
            nbPlace = df_covoiturage.at[idCovoiturage, 'nombre_de_places']

            # si il y a trop de festivaliers, on ne peut pas ajouter plus de place, alors on cherche un autre covoiturage avec assez de place
            while nbFestivaliers > nbPlace:
                idCovoiturage = random.randint(0, len(df_covoiturage) - 1)
                nbPlace = df_covoiturage.at[idCovoiturage, 'nombre_de_places']

            new_row = {
                'id_etape': df_etape.at[random_index_etape, 'id_etape'],
                'id_panier': panier,
                'nbPlaceOccupee': nbFestivaliers
            }

            df_panier_etape.loc[(len(df_panier_etape))] = new_row

    df_panier_etape.to_csv('Panier_etape2.csv', index=False)





    # fake = Faker('fr_FR')

    # for i in range(100000):
    #     new_row = {
    #         'id_panier': i,
    #         'date_paiement': fake.date_time_between(start_date = '-1d', end_date='-230d').strftime('%Y-%m-%d %H:%M:%S'),
    #         'noms_festivaliers' : [fake.name() for _ in range(random.randint(1,5))],
    #         'status' : 1,
    #         'proprietaire': df_utilisateur.at[random.randint(0, len(df_utilisateur) - 1), 'id_utilisateur'],
    #     }
    #     df_panier.loc[(len(df_panier))] = new_row

    # df_panier.to_csv('Panier2.csv', index=False)












    # df_etape = pd.DataFrame(columns=['id_etape', 'id_lieu', 'id_covoiturage', 'duree_depuis_depart', 'prix_etape'])
    # for index,row in df_covoiturage.copy().iterrows():
    #     nbEtapes = random.randint(1, 5)
    #     random_duree_dep = random.randint(5, 500)
    #     covoiturage = df_covoiturage.at[index, 'id_covoiturage']
    #     for i in range(nbEtapes):
    #         random_index_lieu = random.randint(0, len(df_lieu) - 1)
    #         previous_duree = int(random_duree_dep)
    #         previous_prix = random.randint(3, 20)

    #         new_row = {
    #             'id_lieu': df_lieu.at[random_index_lieu, 'id_lieu'],
    #             'id_covoiturage': covoiturage
    #         }

    #         if i == 0:
    #             new_row['duree_depuis_depart'] = 0
    #             new_row['prix_etape'] = previous_prix
    #         else:
    #             random_duree_dep = random.randint(previous_duree, previous_duree + 200)
    #             previous_duree = random_duree_dep
    #             new_row['duree_depuis_depart'] = random_duree_dep

    #             random_prix = random.randint(2, previous_prix)
    #             new_row['prix_etape'] = random_prix
            

    #         df_etape.loc[(len(df_etape))] = new_row
            

    # df_etape.to_csv('Etape2.csv', index=False)


    # Ajout de 200 festivals au covoiturages
    # for index, row in df_covoiturage.copy().iterrows():
    #     random_index = random.randint(0, len(df_festival) - 1)
    #     df_covoiturage.at[index, 'festival'] = df_festival.at[random_index, 'id_festival'].astype(str)
    #     df_covoiturage.at[index, 'email_conducteur'] = df_utilisateur.at[random_index, 'email']


    # print(df_covoiturage)



    # df_covoiturage.to_csv('Covoiturage2.csv', index=False)

if __name__ == "__main__":
    main()