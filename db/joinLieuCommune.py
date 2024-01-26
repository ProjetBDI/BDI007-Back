import pandas as pd

df_commune = pd.read_csv('Commune.csv', encoding='ISO-8859-1')
df_lieu = pd.read_csv('Lieu.csv', encoding='ISO-8859-1')

df_merge = pd.merge(df_commune, df_lieu, left_on='communeINSEE', right_on='commune' , how='inner')

df_merge.to_csv('LiaisonCommuneLieu.csv', index=False, encoding='ISO-8859-1')