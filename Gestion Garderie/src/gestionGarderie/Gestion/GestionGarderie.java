package gestionGarderie.Gestion;

import java.util.Scanner;

import gestionGarderie.Ressources.Adresse;
import gestionGarderie.Ressources.Garderie;

public class GestionGarderie {
		
		private Scanner sc;
		
		public GestionGarderie () {
			sc = new Scanner(System.in);
		}
		
		
		public void modifierGardeire(Garderie garderie) {
			
			String choix = "";
			while (true) {
				System.out.println("\t[1.2.1].Modifier Informations Garderie.");
				System.out.println("\t[X].Quitter");
				System.out.print(">");
				choix = sc.nextLine();
				
				if (choix.equals("1")) {
					System.out.println("Donner Nouveau Nom : ");
					System.out.print(">");
					garderie.setNom(sc.nextLine());
					System.out.println("Donner Nouveau Email : ");
					System.out.print(">");
					garderie.setEmail(sc.nextLine());
					int numero;
					do {
						System.out.println("Donner Nouveau Numero Telephone : ");
						System.out.print(">");
						numero = sc.nextInt();
						if (verifierNumero(numero) == 1)
							garderie.setNumero(numero);
						else
							System.out.println("Numero Errone");
						
					}while(verifierNumero(numero) == -1);
					sc.nextLine(); // parce que nextInt ne lie pas the /n (new line)
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
					garderie.setAdresse(adresse);
					System.out.println("Modification Avec Succes");
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
		
		private static int verifierNumero (int numero) {
			
			int longueur = (int) (Math.floor(Math.log10(numero))+1);
			
			
			if (longueur != 8 || numero <0 )
				return -1;
			
			
			return 1;
		}
		
		public void afficherDetails(Garderie garderie) {
			
			Affichage a = new Affichage ();
			
			a.setColumnWidth(32);
			a.setColumnNumber(8);
			a.setTitle("Informations Garderie");
			String [] titles = {"Nom","Email","Numero Tel",
								"Numero Rue/Avenue","Designation Rue/Avenue","Ville","Gouvernorat","Code Postal"};
			a.setColumnTitles(titles);
			
				
				a.addColumn(garderie.getNom());
				a.addColumn(garderie.getEmail());
				a.addColumn(""+garderie.getNumero());
				
				a.addColumn(""+garderie.getAdresse().getNumeroRue_Avenue());
				a.addColumn(garderie.getAdresse().getDesignationRue_Avenue());
				a.addColumn(garderie.getAdresse().getVille());
				a.addColumn(garderie.getAdresse().getGouvernorat());
				a.addLastColumn(""+garderie.getAdresse().getCodePostal());
	
				a.endLine();
			
		}
}
