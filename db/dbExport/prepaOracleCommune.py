import csv
from datetime import datetime

import re

# CSV file path
commune_csv_file = "commune.csv"

# Output SQL script file path
output_sql_commune_file = "commune_oracle.sql"
# SQL insert statement template
sql_insert_commune_template = """
INSERT INTO commune ( id_commune, code_insee, code_postal, latitude, longitude, nom_commune, id_departement, coord_commune) 
VALUES ( {id_commune}, '{code_insee}', '{code_postal}', '{latitude}', '{longitude}', '{nom_commune}', {id_departement}, SDO_GEOMETRY( 2001, 4326, SDO_POINT_TYPE({longitude}, {latitude}, NULL), NULL, NULL) );
"""

# Read CSV file and generate SQL script
with open(commune_csv_file, 'r', encoding='ISO-8859-1') as csv_file, open(output_sql_commune_file, 'w', encoding='ISO-8859-1') as sql_festival_file:
    csv_reader = csv.DictReader(csv_file, delimiter=',')

    # Write SQL statements to the script file
    for row in csv_reader:
        # Properly escape special characters in string fields
        for key in row.keys():
            row[key] = re.sub(r"'", "''", row[key])

        # Convert empty strings to NULL for numeric columns

        sql_festival_file.write(sql_insert_commune_template.format(**row))

print(f"SQL script for Festival table generated successfully. Please check {output_sql_commune_file}.")