import csv
from datetime import datetime

import re

# CSV file path
festivals_csv_file = "covoiturage.csv"

# Output SQL script file path
output_sql_festival_file = "covoiturage_oracle.sql"
# SQL insert statement template
sql_insert_festival_template = """
INSERT INTO covoiturage ( id_covoiturage, couleur, date_depart, marque, modele, nb_place, nb_place_dispo, id_conducteur, id_festival) 
VALUES ( {id_covoiturage}, '{couleur}', TO_TIMESTAMP('{date_depart}', 'YYYY-MM-DD HH24:MI:SS.FF'), '{marque}', '{modele}', {nb_place}, {nb_place_dispo}, {id_conducteur}, {id_festival});
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
        row['nb_place_dispo'] = f"{row['nb_place_dispo'] or 'NULL'}"
    

        # Convert timestamp strings to the SQL format
        row['date_depart'] = datetime.strptime(row['date_depart'], '%Y-%m-%d %H:%M:%S.%f').strftime('%Y-%m-%d %H:%M:%S.%f')
        

        sql_festival_file.write(sql_insert_festival_template.format(**row))

print(f"SQL script for Festival table generated successfully. Please check {output_sql_festival_file}.")