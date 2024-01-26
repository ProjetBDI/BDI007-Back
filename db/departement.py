import pandas as pd

df_departement = pd.read_csv('Departement.csv', encoding='ISO-8859-1')

df_departement['id_department'] = [i for i in range(len(df_departement))]


    
df_departement.to_csv('Departement1.csv', index=False, encoding='ISO-8859-1')