import csv
from faker import Faker
import random

fake = Faker()

# Nombre d'utilisateurs à générer
nombre_utilisateurs = 100000

# Génération des données
utilisateurs = []
for _ in range(nombre_utilisateurs):
    email = fake.email()
    nom = fake.last_name()
    prenom = fake.first_name()
    date_naissance = fake.date_of_birth().strftime('%Y-%m-%d')
    utilisateurs.append([email, nom, prenom, date_naissance])

# Écriture des données dans un fichier CSV
nom_fichier_csv = 'utilisateurs.csv'
with open(nom_fichier_csv, 'w', newline='') as fichier_csv:
    writer = csv.writer(fichier_csv)
    # Écriture de l'en-tête
    writer.writerow(['Email', 'Nom', 'Prénom', 'Date de Naissance'])
    # Écriture des données des utilisateurs
    writer.writerows(utilisateurs)

print(f"Le fichier {nom_fichier_csv} a été généré avec succès.")
