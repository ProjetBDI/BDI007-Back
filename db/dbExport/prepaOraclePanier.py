import csv
from datetime import datetime

import re

# CSV file path
festivals_csv_file = "panier.csv"

# Output SQL script file path
output_sql_festival_file = "panier_oracle.sql"
# SQL insert statement template
sql_insert_festival_template = """
INSERT INTO panier ( id_panier, date_paiement, noms_festivaliers, id_proprietaire) 
VALUES ( {id_panier}, TO_TIMESTAMP('{date_paiement}', 'YYYY-MM-DD HH24:MI:SS.FF'), '{noms_festivaliers}',{id_proprietaire});
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
    

        # Convert timestamp strings to the SQL format
        row['date_paiement'] = datetime.strptime(row['date_paiement'], '%Y-%m-%d %H:%M:%S.%f').strftime('%Y-%m-%d %H:%M:%S.%f')
        

        sql_festival_file.write(sql_insert_festival_template.format(**row))

print(f"SQL script for Festival table generated successfully. Please check {output_sql_festival_file}.")