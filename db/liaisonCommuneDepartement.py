import pandas as pd

df_commune = pd.read_csv('Commune.csv', encoding='ISO-8859-1')
df_departement = pd.read_csv('Departement1.csv', encoding='ISO-8859-1')


df_merge = pd.merge(df_commune, df_departement, on='departement', how='inner')
df_merge.to_csv('LiaisonCommuneDepartement.csv', index=False, encoding='ISO-8859-1')