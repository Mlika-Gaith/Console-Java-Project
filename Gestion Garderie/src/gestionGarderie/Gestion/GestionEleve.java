package gestionGarderie.Gestion;

import java.util.Scanner;
import gestionGarderie.Ressources.*;


public class GestionEleve {
	
	/** LES ATTRIBUTS **/
	
	private Eleve [] eleves;
	private int nombreEleves = 0;
	private Scanner sc;
	
	
	/** LES CONSTRUCTEURS **/
	public GestionEleve() {
		
		eleves = new Eleve [500];
	}
	
	/** LES GETTERS **/
	
	public int getNombreEleves() {
		
		return nombreEleves;
	}
	
	public Eleve [] getListeEleves() {
		
		return eleves;
	}
	
	/** LES METHODES **/
	
	private static void menuPartiel (Eleve eleve, Scanner sc) {
		
		System.out.println("Donner Nouveau Nom :");
		System.out.print(">");
		eleve.setNom(sc.nextLine());
		System.out.println("Donner Nouveau Prenom :");
		System.out.print(">");
		eleve.setPrenom(sc.nextLine());
		System.out.println("Donner Nouvelle Numéro Cin Père :");
		System.out.print(">");
		eleve.setNumeroCin(sc.nextLine());
		int numero = 0;
		do {
			System.out.println("Donner Nouveau Numéro Téléphone Père : ");
			System.out.print(">");
			numero = sc.nextInt();
			if (eleve.verifierNumero(numero) == 1)
				eleve.setNumeroTelephone(numero);
			else
				System.out.println("Numero Errone");
		}while (eleve.verifierNumero(numero) == -1);
		
		sc.nextLine();
		String niveauScolaire = "Non définie";
		while (!(niveauScolaire.equalsIgnoreCase("a") || niveauScolaire.equalsIgnoreCase("b")
				|| niveauScolaire.equalsIgnoreCase("c"))) {
				System.out.println("Donner nouveau Niveau Scolaire :");
				System.out.print(">");
				niveauScolaire = sc.nextLine();
		}
		eleve.setNiveauScolaire(niveauScolaire);
	}
	
	private static void menuComplet (Eleve eleve, Scanner sc) {
		
		System.out.println("Donner Nouveau Nom : ");
		System.out.print(">");
		eleve.setNom(sc.nextLine());
		System.out.println("Donner Nouveau Prenom : ");
		System.out.print(">");
		eleve.setPrenom(sc.nextLine());
		System.out.println("Donner Nouveau Prenom Père : ");
		System.out.print(">");
		eleve.setPrenomPere(sc.nextLine());
		System.out.println("Donner Nouveau Prenom Grand Père : ");
		System.out.print(">");
		eleve.setPrenomGrandPere(sc.nextLine());
		System.out.println("Donner Nouveau Nom Mère : ");
		System.out.print(">");
		eleve.setNomMere(sc.nextLine());
		System.out.println("Donner Nouveau Prénom Mère: ");
		System.out.print(">");
		eleve.setPrenomMere(sc.nextLine());
		System.out.println("Donner Nouvelle Numéro Cin Père : ");
		System.out.print(">");
		eleve.setNumeroCin(sc.nextLine());
		int numero = 0;
		do {
			System.out.println("Donner Nouveau Numéro Téléphone Père : ");
			System.out.print(">");
			numero = sc.nextInt();
			if (eleve.verifierNumero(numero) == 1)
				eleve.setNumeroTelephone(numero);
			else
				System.out.println("Numero Errone");
		}while (eleve.verifierNumero(numero) == -1);
		
		sc.nextLine();
		String date = "";
		do {
			
			System.out.println("Donner Nouvelle Date Naissance : ");
			System.out.print(">");
			date = sc.nextLine();
			if (eleve.verifierDate(date) == -1)
				System.out.println("Date Erronee");
			else
				eleve.setDateNaissance(date);
		}while(eleve.verifierDate(date) == -1);
		
		
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
		eleve.setAdresse(adresse);
		String niveauScolaire ="Non définie";
		while (!(niveauScolaire.equalsIgnoreCase("a") || niveauScolaire.equalsIgnoreCase("b")
				|| niveauScolaire.equalsIgnoreCase("c"))) {
			System.out.println("Donner nouveau Niveau Scolaire : ");
			System.out.print(">");
			niveauScolaire = sc.nextLine();
		}
		
		eleve.setNiveauScolaire(niveauScolaire);
		System.out.println("Donner Nouvelle Image de Profil : ");
		System.out.print(">");
		eleve.setImageProfil(sc.nextLine());
	}
	
	
	public void ajouterEleve() {
		
		if (nombreEleves < 500) {
			Eleve eleve = new Eleve ();
			
			sc = new Scanner (System.in);
			String choix = "Non Défini";
			
			while (true) {
				System.out.println("\t[4.1.1].Ajout avec Informations Partielles.");
				System.out.println("\t[4.1.2].Ajout avec Informations Complètes.");
				System.out.println("\t[X].Quitter.");
				System.out.print(">");
				choix = sc.nextLine();
				
				if (choix.equals("1")) {
					menuPartiel(eleve,sc);
					eleves[nombreEleves] = eleve;
					nombreEleves ++;
					System.out.println("Ajout avec Succès");
					break;
				}
				
				else if(choix.equals("2")) {
					menuComplet(eleve,sc);
					eleves[nombreEleves] = eleve;
					nombreEleves ++;
				
					System.out.println("Ajout avec Succès");
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
			System.out.println("Nombre Max d'Eleves atteint.");
		}
		
		
	}
	
	
	public void modifierEleve () {
		
		Eleve eleve = null;
		sc = new Scanner (System.in);
		String choix = "Non Défini";
		
		System.out.println("Donner Matricule Eleve : ");
		System.out.print(">");
		eleve = this.getEleveParMatricule(sc.nextLine());
		
		if (eleve != null) {
			
			for ( int i=0; i<nombreEleves; i++) {
				if (eleves[i].getMatricule() == eleve.getMatricule()) {
					while (true) {
						System.out.println("\t[4.2.1].Modification Partielle.");
						System.out.println("\t[4.2.2].Modification Complète.");
						System.out.println("\t[X].Quitter.");
						System.out.print(">");
						choix = sc.nextLine();
						
						if (choix.equals("1")) {
							
							menuPartiel(eleve,sc);
							System.out.println("Modification avec Succes.");
							break;				
						}
						
						else if (choix.equals("2")) {
										
							menuComplet(eleve,sc);
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
	
	public void supprimerEleve (GestionClasse gestion) {
	
		sc = new Scanner(System.in);
		Eleve eleve = null;
		System.out.println("Donner matricule Eleve : ");
		System.out.print(">");
		eleve = this.getEleveParMatricule(sc.nextLine());
		
		if (eleve != null) {
			for (int i=0; i<nombreEleves; i++) {
				if(eleves[i].getMatricule() == eleve.getMatricule()) {
					
					for (int j=i; j<(nombreEleves-1); j++) {
						eleves[j]=eleves[++j];
					}
					
					eleves[nombreEleves-1]=null;
					nombreEleves --;
					gestion.supprimerEleve(eleve);
					System.out.println ("Eleve Supprimé.");
					break;
				}
			}
		}
	}
	
	public Eleve getEleveParMatricule(String matricule) {
		
		for (int i=0; i<nombreEleves; i++) {
			if (eleves[i].getMatricule().equals(matricule)) {
				return eleves[i];
			}
		}
		System.out.println("Aucun Eleve Avec Ce Matricule.");
		return null;
		
		
	}
	
	public void afficherListeEleves () {
	
		if (nombreEleves > 0) {
			Affichage a =new Affichage();
			a.setColumnWidth(28);
			a.setColumnNumber(7);
			a.setTitle("liste des eleve");
			String [] titles = {"Matricule","Nom","Prenom","Numero Cin Pere","Numero Tel Pere","Niveau Scolaire","Payement"};
			a.setColumnTitles(titles);
			for (int i=0; i<nombreEleves; i++) {
				a.addColumn(eleves[i].getMatricule());
				a.addColumn(eleves[i].getNom());
				a.addColumn(eleves[i].getPrenom());
				a.addColumn(eleves[i].getNumeroCin());
				a.addColumn(""+eleves[i].getNumeroTelephone());
				a.addColumn(eleves[i].getNiveauScolaire());
				if (eleves[i].isPayer() == false)
					a.addLastColumn("Frais Non Payes");
				else
					a.addLastColumn("Frais Payes");
				a.endLine();
			}
		}
		
		else {
			System.out.println("Pas d'eleves à Afficher");
		}
		
	}
	
	public void afficherListeElevesDetails() {
		
		if (nombreEleves > 0) {
			Affichage a =new Affichage();
			a.setColumnWidth(40);
			a.setColumnNumber(15);
			a.setTitle("liste des eleve");
			String [] titles = {"Matricule","Nom","Prenom","Nom et Prenom Mere","Numero Cin Pere","Numero Tel Pere","Niveau Scolaire","Date Naissance",
								"NumeroRue/Avenue","DesignationRue/Avenue","Ville","Gouvernorat","Code Postal","Image Profil","Payement"};
			a.setColumnTitles(titles);
			for (int i=0; i<nombreEleves; i++) {
				a.addColumn(eleves[i].getMatricule());
				a.addColumn(eleves[i].getNom());
				a.addColumn(eleves[i].getPrenom()+" Ben "+eleves[i].getPrenomPere()+ " Ben "+eleves[i].getPrenomGrandPere());
				a.addColumn(eleves[i].getNomMere()+" "+eleves[i].getPrenomMere());
				a.addColumn(eleves[i].getNumeroCin());
				a.addColumn(""+eleves[i].getNumeroTelephone());
				a.addColumn(eleves[i].getNiveauScolaire());
				a.addColumn(eleves[i].getDateNaissance());
				a.addColumn(""+eleves[i].getAdresse().getNumeroRue_Avenue());
				a.addColumn(eleves[i].getAdresse().getDesignationRue_Avenue());
				a.addColumn(eleves[i].getAdresse().getVille());
				a.addColumn(eleves[i].getAdresse().getGouvernorat());
				a.addColumn(""+eleves[i].getAdresse().getCodePostal());
				a.addColumn(eleves[i].getImageProfil());
				if (eleves[i].isPayer() == false)
					a.addLastColumn("Frais Non Payes");
				else
					a.addLastColumn("Frais Payes");
				a.endLine();
			}
		}
		
		else {
			System.out.println("Pas d'eleves à Afficher");
		}
		
	}
	
}
