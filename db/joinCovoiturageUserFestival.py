import pandas as pd
from faker import Faker
faker = Faker()

df_covoiturage = pd.read_csv('Covoiturage2.csv', encoding='ISO-8859-1')
df_utilisateur = pd.read_csv('utilisateurs.csv', encoding='ISO-8859-1')
df_festival = pd.read_csv('festival_.csv', encoding='ISO-8859-1')
for _ in range (len(df_covoiturage)):
    indexUser = faker.random_int(min=0, max=len(df_utilisateur)-1)
    df_covoiturage.loc[_, 'id_utilisateur'] = df_utilisateur.at[indexUser, 'id_utilisateur']
    indexFestival = faker.random_int(min=0, max=len(df_festival)-1)
    df_covoiturage.loc[_, 'festival'] = df_festival.at[indexFestival, 'id_festival']
    

colonnes_necessaires = ['id_covoiturage','couleur','date_depart','marque','modele','nb_place','nb_place_dispo', 'id_utilisateur', 'festival']
df_merge = df_covoiturage[colonnes_necessaires]

df_merge.to_csv('LiaisonCovoitUserFestival.csv', index=False, encoding='ISO-8859-1')