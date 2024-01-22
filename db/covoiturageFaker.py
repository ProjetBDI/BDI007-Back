import csv
from faker import Faker
from faker_vehicle import VehicleProvider

fake = Faker()
fake.add_provider(VehicleProvider)
# Nombre de covoiturages à générer
nombre_covoiturages = 50000

# Génération des données
covoiturages = []
for _ in range(nombre_covoiturages):
    identifiant = _
    nb_places = fake.random_int(min=1, max=4)  # Nombre aléatoire de places entre 1 et 4
    marqueModele = fake.vehicle_make_model().split(' ')
    marque = marqueModele[0]
    modele = marqueModele[1]
    couleur = fake.color_name()
    date_depart = fake.date_time_between(start_date = '+1d', end_date='+230d').strftime('%Y-%m-%d %H:%M:%S')
    covoiturages.append([identifiant, nb_places, marque, modele, couleur, date_depart])

# Écriture des données dans un fichier CSV
nom_fichier_csv = 'covoiturages.csv'
with open(nom_fichier_csv, 'w', newline='') as fichier_csv:
    writer = csv.writer(fichier_csv)
    # Écriture de l'en-tête
    writer.writerow(['ID', 'Nombre de Places', 'Marque', 'Modèle', 'Couleur', 'Date de Départ'])
    # Écriture des données des covoiturages
    writer.writerows(covoiturages)

print(f"Le fichier {nom_fichier_csv} a été généré avec succès.")
