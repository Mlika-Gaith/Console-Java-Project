package gestionGarderie.Gestion;

import java.util.Scanner;

import gestionGarderie.Ressources.Administrateur;
import gestionGarderie.Ressources.Adresse;

public class GestionAdministrateur {
		
		private Scanner sc;
		
		
		public GestionAdministrateur() {
			sc = new Scanner (System.in);
		}
		
		
		
		private static void menuPartiel (Administrateur administrateur, Scanner sc) {
			
			System.out.println("Donner Nouveau Nom :");
			System.out.print(">");
			administrateur.setNom(sc.nextLine());
			System.out.println("Donner Nouveau Prenom :");
			System.out.print(">");
			administrateur.setPrenom(sc.nextLine());
			System.out.println("Donner Nouvelle Numéro Cin : ");
			System.out.print(">");
			administrateur.setNumeroCin(sc.nextLine());
			int numero = 0;
			do {
				System.out.println("Donner Nouveau Numéro Téléphone : ");
				System.out.print(">");
				numero = sc.nextInt();
				if (administrateur.verifierNumero(numero) == 1)
					administrateur.setNumeroTelephone(numero);
				else
					System.out.println("Numero Errone");
			}while (administrateur.verifierNumero(numero) == -1);
			sc.nextLine();
		}
		
		private static void menuComplet (Administrateur administrateur, Scanner sc) {
			
			System.out.println("Donner Nouveau Nom : ");
			System.out.print(">");
			administrateur.setNom(sc.nextLine());
			System.out.println("Donner Nouveau Prenom : ");
			System.out.print(">");
			administrateur.setPrenom(sc.nextLine());
			System.out.println("Donner Nouveau Prenom Père : ");
			System.out.print(">");
			administrateur.setPrenomPere(sc.nextLine());
			System.out.println("Donner Nouvelle Numéro Cin : ");
			System.out.print(">");
			administrateur.setNumeroCin(sc.nextLine());
			
			int numero = 0;
			do {
				System.out.println("Donner Nouveau Numéro Téléphone : ");
				System.out.print(">");
				numero = sc.nextInt();
				if (administrateur.verifierNumero(numero) == 1)
					administrateur.setNumeroTelephone(numero);
				else
					System.out.println("Numero Errone");
			}while (administrateur.verifierNumero(numero) == -1);
			sc.nextLine();
			String date = "";
			do {
				
				System.out.println("Donner Nouvelle Date Naissance : ");
				System.out.print(">");
				date = sc.nextLine();
				if (administrateur.verifierDate(date) == -1)
					System.out.println("Date Erronee");
				else
					administrateur.setDateNaissance(date);
			}while(administrateur.verifierDate(date) == -1);
			
			
			Adresse adresse = new Adresse();
			System.out.println("Donner Nouveau Numéro Rue/Avenue : ");
			System.out.print(">");
			adresse.setNumeroRue_Avenue(Integer.parseInt(sc.nextLine()));
			System.out.println("Donner Nouvelle Désignation Rue/Avenue : ");
			System.out.print(">");
			adresse.setDesignationRue_Avenue(sc.nextLine());
			System.out.println("Donner Nouvelle Ville : ");
			System.out.print(">");
			adresse.setVille(sc.nextLine());
			System.out.println("Donner Nouveau Code Postal : ");
			System.out.print(">");
			adresse.setCodePostal(Integer.parseInt(sc.nextLine()));
			System.out.println("Donner Nouvelle Gouvernorat : ");
			System.out.print(">");
			adresse.setGouvernorat(sc.nextLine());
			administrateur.setAdresse(adresse);
			System.out.println("Donner Nouvelle Image de Profil : ");
			System.out.print(">");
			administrateur.setImageProfil(sc.nextLine());
		}
		
		public void modifierInfoPersonnelles (Administrateur administrateur) {
			String choix = "Non Défini";
			
			
			while (true) {
				System.out.println("\t[2.2.1].Modifier Vos  Informations Personnelles Partiellement.");
				System.out.println("\t[2.2.2].Modifier Toutes Vos Informations Personnelles.");
				System.out.println("\t[X].Quitter.");
				System.out.print(">");
				choix = sc.nextLine();
				
				if (choix.equals("1")) {
					menuPartiel(administrateur,sc);
					System.out.println("Modification avec Succès");
					break;
				}
				
				else if(choix.equals("2")) {
					menuComplet(administrateur,sc);
					System.out.println("Modification avec Succès");
					break;
				}
				else if (choix.equalsIgnoreCase("x")) {
					break;
				}
				else {
					System.out.println("Commande Non Reconnue.");
				}
			}
		}
		
		
		public void modifierLogin (Administrateur administrateur) {
			String choix = "Non Défini";
			
			while (true) {
				System.out.println("\t[2.3.1].Modifier Nom Utilisateur et Mot de Passe.");
				System.out.println("\t[X].Quitter.");
				System.out.print(">");
				choix = sc.nextLine();
				if (choix.equals("1")) {
					System.out.println("Donner Nouveau Nom Utilisateur : ");
					administrateur.setNomUtilisateur(sc.nextLine());
					System.out.println("Donner Nouveau Mot De Passe : ");
					System.out.print(">");
					administrateur.setMotDePasse(sc.nextLine());
					System.out.println("Modification avec Succès");
					break;
				}
				else if (choix.equalsIgnoreCase("x")) {
					break;
				}
				else {
					System.out.println("Commande Non Reconnue");
				}
			}
		}
		
		
		public int login(Administrateur administrateur) {
			
			int tentative = 0;
			String nomU = "", mdp = "";
			
			while (tentative < 3) {
				System.out.println("Nom Utilisateur : ");
				System.out.print(">");
				nomU = sc.nextLine();
				System.out.println("Mot De Passe : ");
				System.out.print(">");
				mdp = sc.nextLine();
				if (nomU.equals(administrateur.getNomUtilisateur()) && mdp.equals(administrateur.getMotDePasse())) {
					
					return 1;
				}
				tentative ++;
			}
			
			return -1;
		}
		
		public void afficherInfoPersonnelles(Administrateur administrateur) {
			
			Affichage a = new Affichage ();
			
			a.setColumnWidth(32);
			a.setColumnNumber(13);
			a.setTitle("Informations Personnelles");
			String [] titles = {"Nom","Prenom","Numero Cin","Numero Tel","Date Naissance","Nom Utilisateur","Mot de Passe",
								"Numero Rue/Avenue","Designation Rue/Avenue","Ville","Gouvernorat","Code Postal","Image Profil"};
			a.setColumnTitles(titles);
			
				
				a.addColumn(administrateur.getNom());
				a.addColumn(administrateur.getPrenom()+" Ben "+administrateur.getPrenomPere());
				a.addColumn(administrateur.getNumeroCin());
				a.addColumn(""+administrateur.getNumeroTelephone());
				a.addColumn(administrateur.getDateNaissance());
				a.addColumn(administrateur.getNomUtilisateur());
				a.addColumn(administrateur.getMotDePasse());
				a.addColumn(""+administrateur.getAdresse().getNumeroRue_Avenue());
				a.addColumn(administrateur.getAdresse().getDesignationRue_Avenue());
				a.addColumn(administrateur.getAdresse().getVille());
				a.addColumn(administrateur.getAdresse().getGouvernorat());
				a.addColumn(""+administrateur.getAdresse().getCodePostal());
				a.addLastColumn(administrateur.getImageProfil());
				a.endLine();
			
			
		}
		
}
