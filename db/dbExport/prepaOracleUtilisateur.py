import csv
from datetime import datetime

import re

# CSV file path
festivals_csv_file = "utilisateur.csv"

# Output SQL script file path
output_sql_festival_file = "utilisateur_oracle.sql"
# SQL insert statement template
sql_insert_festival_template = """
INSERT INTO utilisateur ( id_utilisateur, date_naissance, email, mot_de_passe, nom, prenom, telephone) 
VALUES ( {id_utilisateur}, TO_DATE('{date_naissance}', 'YYYY-MM-DD'), '{email}', '{mot_de_passe}', '{nom}', '{prenom}', '{telephone}');
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


        # Convert date strings to the SQL format
        row['date_naissance'] = datetime.strptime(row['date_naissance'], '%Y-%m-%d').strftime('%Y-%m-%d')


        sql_festival_file.write(sql_insert_festival_template.format(**row))

print(f"SQL script for Festival table generated successfully. Please check {output_sql_festival_file}.")