import pandas as pd

df_commune = pd.read_csv('Commune.csv', encoding='ISO-8859-1')
df_domaine = pd.read_csv('Domaine.csv', encoding='ISO-8859-1')
df_festival = pd.read_csv('Festival.csv', encoding='ISO-8859-1')

df_festival['nb_pass_dispo'] = [0 for i in range(len(df_festival))]
df_festival['nb_pass_indispo'] = [0 for i in range(len(df_festival))]

df_merge = pd.merge(df_festival, df_domaine, left_on=['domaine', 'sous_domaine'], right_on=['nom_domaine', 'nom_sous_domaine'])
df_merge_merge = pd.merge(df_merge, df_commune, left_on=['codeINSEE'], right_on=['code_insee'], how='inner')


colonnes_necessaires = ['id_festival', 'date_debut', 'date_fin', 'lieu_principal', 'nb_pass_dispo', 'nb_pass_indispo','nbPassTotal', 'nom_manifestation',  'site_web', 'tarif_pass',  'id_commune', 'id_domaine']
df_merge_merge = df_merge_merge[colonnes_necessaires]

df_merge_merge.to_csv('LiaisonFestivalLieuCommune.csv', index=False, encoding='ISO-8859-1')