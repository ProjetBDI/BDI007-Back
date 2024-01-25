import csv
from datetime import datetime

import re

# CSV file path
festivals_csv_file = "Festival.csv"

# Output SQL script file path
output_sql_festival_file = "festival_oracle.sql"
# SQL insert statement template
sql_insert_festival_template = """
INSERT INTO festival ( id_festival, date_debut, date_fin, lieu_principal, nb_pass_dispo, nb_pass_indispo, nb_pass_total, nom, site_web, status, tarif_pass, id_commune, id_domaine) 
VALUES ( {id_festival}, TO_DATE('{date_debut}', 'YYYY-MM-DD'), TO_DATE('{date_fin}', 'YYYY-MM-DD'), '{lieu_principal}', {nb_pass_dispo}, {nb_pass_indispo}, {nb_pass_total}, '{nom}', '{site_web}', {status}, {tarif_pass}, {id_commune}, {id_domaine});
"""

# Read CSV file and generate SQL script
with open(festivals_csv_file, 'r', encoding='ISO-8859-1') as csv_file, open(output_sql_festival_file, 'w', encoding='ISO-8859-1') as sql_festival_file:
    csv_reader = csv.DictReader(csv_file, delimiter=',')

    # Write SQL statements to the script file
    for row in csv_reader:
        # Properly escape special characters in string fields
        for key in row.keys():
            row[key] = re.sub(r"'", "''", row[key])

        # Convert empty strings to NULL for numeric columns
        row['nb_pass_dispo'] = f"{row['nb_pass_dispo'] or 'NULL'}"
        row['nb_pass_indispo'] = f"{row['nb_pass_indispo'] or 'NULL'}"
        row['status'] = f"{row['status'] or 'NULL'}"

        # Convert date strings to the SQL format
        row['date_debut'] = datetime.strptime(row['date_debut'], '%Y-%m-%d').strftime('%Y-%m-%d')
        row['date_fin'] = datetime.strptime(row['date_fin'], '%Y-%m-%d').strftime('%Y-%m-%d')

        sql_festival_file.write(sql_insert_festival_template.format(**row))

print(f"SQL script for Festival table generated successfully. Please check {output_sql_festival_file}.")