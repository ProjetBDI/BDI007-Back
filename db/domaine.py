import pandas as pd

df_domaine = pd.read_csv('sousDomaine.csv', encoding='ISO-8859-1')

df_domaine['id_domaine'] = [i for i in range(len(df_domaine))]
    
df_domaine.to_csv('Domaine.csv', index=False, encoding='ISO-8859-1')