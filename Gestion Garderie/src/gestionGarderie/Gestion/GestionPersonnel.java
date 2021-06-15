package gestionGarderie.Gestion;

import java.util.Scanner;

import gestionGarderie.Ressources.Adresse;
import gestionGarderie.Ressources.Personnel;

public class GestionPersonnel {
	
	/** LES ATTRIBUTS **/
	
	private Personnel [] personnels;
	private int nombrePersonnels = 0;
	private Scanner sc;
	
	/** LES CONSTRUCTEURS **/
	
	public GestionPersonnel() {
		personnels = new Personnel[100];
	}
	
	/** LES GETTERS **/
	
	public  int getNombrePersonnels () {
		
		return nombrePersonnels;
	}
	
	
	public Personnel [] getListePersonnels() {
		
		return personnels;
	}
	
	/** LES METHODES **/
	
	public int getNombreAnimateur ()
	{	
		int compteur = 0;
		for (int i = 0; i< nombrePersonnels; i++) {
			if (personnels[i].getType().equalsIgnoreCase("animateur"))
				compteur ++;
		}
		
		return compteur;
	}
	
	public int getNombreEmployees () {
		int compteur = 0;
		for (int i = 0; i< nombrePersonnels; i++) {
			if (personnels[i].getType().equalsIgnoreCase("employe"))
				compteur ++;
		}
		return compteur;
		
	}
	
	/** UN MENU POUR USER INPUT **/
	private static void menuPartiel (Personnel personnel, Scanner sc) {
		
		String type ="Non Définie";
		while(!(type.equalsIgnoreCase("animateur") || type.equalsIgnoreCase("employee"))) {
			System.out.println("Donner Nouveau Type : ");
			System.out.print(">");
			type = sc.nextLine(); 
		}
		
		personnel.setType(type);
		personnel.setMatricule(type);
		System.out.println("Donner Nouveau Nom :");
		System.out.print(">");
		personnel.setNom(sc.nextLine());
		System.out.println("Donner Nouveau Prénom :");
		System.out.print(">");
		personnel.setPrenom(sc.nextLine());
		System.out.println("Donner Nouveau Numéro Cin :");
		System.out.print(">");
		personnel.setNumeroCin(sc.nextLine());
		int numero = 0;
		do {
			System.out.println("Donner Nouveau Numéro Téléphone : ");
			System.out.print(">");
			numero = sc.nextInt();
			if (personnel.verifierNumero(numero) == 1)
				personnel.setNumeroTelephone(numero);
			else
				System.out.println("Numero Errone");
		}while (personnel.verifierNumero(numero) == -1);
		sc.nextLine();
		
								
	}
	
	private static void menuComplet(Personnel personnel, Scanner sc) {
		String type ="Non Définie";
		while(!(type.equalsIgnoreCase("animateur") || type.equalsIgnoreCase("employee"))) {
			System.out.println("Donner Nouveau Type : ");
			System.out.print(">");
			type = sc.nextLine(); 
		}
		
		personnel.setType(type);
		personnel.setMatricule(type);
		System.out.println("Donner Nouveau Nom : ");
		System.out.print(">");
		personnel.setNom(sc.nextLine());
		System.out.println("Donner Nouveau Prenom : ");
		System.out.print(">");
		personnel.setPrenom(sc.nextLine());
		System.out.println("Donner Nouveau Prenom Père : ");
		System.out.print(">");
		personnel.setPrenomPere(sc.nextLine());
		System.out.println("Donner Nouvelle Numéro Cin : ");
		System.out.print(">");
		personnel.setNumeroCin(sc.nextLine());
		int numero = 0;
		do {
			System.out.println("Donner Nouveau Numéro Téléphone : ");
			System.out.print(">");
			numero = sc.nextInt();
			if (personnel.verifierNumero(numero) == 1)
				personnel.setNumeroTelephone(numero);
			else
				System.out.println("Numero Errone");
		}while (personnel.verifierNumero(numero) == -1);
		
		sc.nextLine();
		
		String date = "";
		do {
			
			System.out.println("Donner Nouvelle Date Naissance : ");
			System.out.print(">");
			date = sc.nextLine();
			if (personnel.verifierDate(date) == -1)
				System.out.println("Date Erronee");
			else
				personnel.setDateNaissance(date);
		}while(personnel.verifierDate(date) == -1);
		
		
		Adresse adresse = new Adresse();
		System.out.println("Donner Nouveau Numéro Rue_Avenue : ");
		System.out.print(">");
		adresse.setNumeroRue_Avenue(Integer.parseInt(sc.nextLine()));
		System.out.println("Donner Nouvelle Désignation Rue_Avenue : ");
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
		personnel.setAdresse(adresse);
		System.out.println("Donner Nouvelle Image de Profil : ");
		System.out.print(">");
		personnel.setImageProfil(sc.nextLine());
	}

	
	
	public void ajouterPersonnel () {
		
		if (nombrePersonnels < 100) {
			
			
			Personnel personnel = new Personnel();
			String choix = "Non Définie";
			sc = new Scanner(System.in);
			while (true) {
				System.out.println("\t[3.1.1].Ajout avec Informations Partielles.");
				System.out.println("\t[3.1.2].Ajout avec Informations Complètes.");
				System.out.println("\t[X].Quitter.");
				System.out.print(">");
				choix = sc.nextLine();
				
				if (choix.equals("1")){
					
					menuPartiel (personnel, sc);
					personnels[nombrePersonnels] =personnel;
					nombrePersonnels ++;
					
					System.out.println("Personnel Ajouté avec Succes.");
					break;
				}
				
				else if (choix.equals("2")) {
					
					menuComplet(personnel,sc);
					personnels[nombrePersonnels] = personnel;
					nombrePersonnels ++;
					
					System.out.println("Personnel Ajouté avec Succes.");
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
		
		else {
			System.out.println("Nombre Max de Personnels atteint.");
		}
		
	}
	
	public void modifierPersonnel() {
		
		Personnel personnel = null;
		sc = new Scanner(System.in);
		String choix = "Non Défini";
		
		System.out.println("Donner Matricule Personnel : ");
		System.out.print(">");
		personnel = this.getPersonnelParMatricule(sc.nextLine());
		
		if (personnel != null) {
			
			for (int i=0; i<nombrePersonnels; i++) {
				
				if (personnels[i].getMatriculePersonnel().equals(personnel.getMatriculePersonnel())) {
					
					
					while (true) {
						System.out.println("\t[3.2.1].Modification Partielle.");
						System.out.println("\t[3.2.2].Modification Complète.");
						System.out.println("\t[X].Quitter.");
						System.out.print(">");
						choix = sc.nextLine();
						
						if (choix.equals("1")) {
							String matricule = personnel.getMatriculeNumero();
							menuPartiel(personnel,sc);
							personnel.setMatricule(personnel.getType(), matricule);
							System.out.println("Modification avec Succes.");
							break;
						}
						
						else if (choix.equals("2")) {
							String matricule = personnel.getMatriculeNumero();
							menuComplet(personnel,sc);
							personnel.setMatricule(personnel.getType(),matricule);
							System.out.println("Modification avec Succes.");
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
			}
			
		}
		
	}
	
	public void supprimerPersonnel(GestionSeance gestionS, GestionClasse gestionC) {
		sc = new Scanner (System.in);
		Personnel personnel = null;
		System.out.println("Donner Matricule Personnel :");
		System.out.print(">");
		personnel = this.getPersonnelParMatricule(sc.nextLine());
		if (personnel != null) {
			for (int i=0; i<nombrePersonnels; i++) {
				if (personnels[i].getMatriculePersonnel().equals(personnel.getMatriculePersonnel())) {
					
					
					for (int j=i; j<(nombrePersonnels-1); j++) {
						personnels[j]=personnels[++j];
					}
					
					personnels[nombrePersonnels-1]=null;
					nombrePersonnels --;
					if (personnel.getMatriculePersonnel().contains("animateur")) {
						gestionS.supprimerSeance(personnel);
						gestionC.supprimerSeance(personnel);
					}
					System.out.println("Personnel Supprimé.");
					break;
				}
			}
		}
		

	}
	
	public  Personnel getPersonnelParMatricule (String matricule) {
		
		int i=0;
		
		for (i= 0; i<nombrePersonnels; i++) {
			
			if (personnels[i].getMatriculePersonnel().equals(matricule) ) {
			
				return personnels[i];
			}
		}
		
		System.out.println("Aucun Animateur Avec ce Matricule.");
		return null;
		
		
	}
	
	public void afficherListePersonnel() {
		
		if (nombrePersonnels > 0) {
			
			Affichage a = new Affichage();
			a.setColumnWidth(20);
			a.setColumnNumber(4);
			a.setTitle("Liste du Personnels de La Garderie");
			String [] titles = {"Type","Matricule","Nom","Prenom"};
			a.setColumnTitles(titles);
			
			for (int i=0; i<nombrePersonnels; i++) {
				
				a.addColumn(personnels[i].getType());
				a.addColumn(personnels[i].getMatriculePersonnel());
				a.addColumn(personnels[i].getNom());
				a.addLastColumn(personnels[i].getPrenom());
				a.endLine();
			}
		}
		
		else {
			System.out.println("Aucun Personnel(s) à Afficher");
		}
		
	}
	
	public void afficherListePersonnelDetails() {
		
		if (nombrePersonnels > 0) {
			Affichage a = new Affichage();
			a.setColumnWidth(32);
			a.setColumnNumber(13);
			a.setTitle("Liste du Personnels de la Garderie");
			String [] titles = {"Type","Matricule","Nom","Prenom","Numero Cin","Telephone","Date de Naissance","(Avenue ou Rue) Num","Désignation (Avenue ou Rue)",
					"Ville","Gouvernorat","Code Postal","Image du Profil"};
			a.setColumnTitles(titles);
			for (int i=0; i<nombrePersonnels; i++) {
				
				a.addColumn(personnels[i].getType());
				a.addColumn(personnels[i].getMatriculePersonnel());
				a.addColumn(personnels[i].getNom());
				a.addColumn(personnels[i].getPrenom()+" Ben "+
							personnels[i].getPrenomPere());
				a.addColumn(personnels[i].getNumeroCin());
				a.addColumn(""+personnels[i].getNumeroTelephone());
				a.addColumn(personnels[i].getDateNaissance());
				a.addColumn(""+personnels[i].getAdresse().getNumeroRue_Avenue());
				a.addColumn(personnels[i].getAdresse().getDesignationRue_Avenue());
				a.addColumn(personnels[i].getAdresse().getVille());
				a.addColumn(personnels[i].getAdresse().getGouvernorat());
				a.addColumn(""+personnels[i].getAdresse().getCodePostal());
				a.addLastColumn(personnels[i].getImageProfil());
				a.endLine();
							
			}
		}
	}
	
	
		
}
