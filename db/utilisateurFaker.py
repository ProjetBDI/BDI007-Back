import csv
from faker import Faker
import random

fake = Faker('fr_FR')
# Nombre d'utilisateurs à générer
nombre_utilisateurs = 100000

# Génération des données
utilisateurs = []
for _ in range(nombre_utilisateurs):
    identifiant = _
    nom = fake.last_name()
    prenom = fake.first_name()
    email = f"{prenom.lower()}.{nom.lower()}{_}@{fake.free_email_domain()}"
    date_naissance = fake.date_of_birth().strftime('%Y-%m-%d')
    telephone = fake.phone_number()
    utilisateurs.append([identifiant,email, nom, prenom, date_naissance, telephone])

# Écriture des données dans un fichier CSV
nom_fichier_csv = 'utilisateurs.csv'
with open(nom_fichier_csv, 'w', newline='') as fichier_csv:
    writer = csv.writer(fichier_csv)
    # Écriture de l'en-tête
    writer.writerow(['identifiant','Email', 'Nom', 'Prénom', 'Date de Naissance', 'Téléphone'])
    # Écriture des données des utilisateurs
    writer.writerows(utilisateurs)

print(f"Le fichier {nom_fichier_csv} a été généré avec succès.")
