package gestionGarderie.Gestion;

import java.util.Scanner;

import gestionGarderie.Ressources.*;


public class GestionClasse {
		
	/** ATTRIBUTS **/
	
	private Classe [] classes;
	private int nombreClasses = 0;
	private Scanner sc ;
	
	public GestionClasse(){
		
		classes = new Classe [50]; // Nombre de Classes Max est 50

	}
	
	/**Les Setters **/
	
	public void setListeClasses (Classe [] classes) {
		this.classes = classes;
	}
	
	/** Les Getters **/
	
	public int getNombreClasses() {
		return nombreClasses;
	}
	public Classe [] getListeClasses () {
		return classes;
	}
	
	/** Méthodes **/
	
	public void ajouterClasse () {
		
		if (nombreClasses < 50) {
			
			sc = new Scanner(System.in);
			System.out.println("Donner Nom Classe : ");
			System.out.print(">");
			Classe classe = new Classe(sc.nextLine());
			
			classes[nombreClasses] = classe;
			nombreClasses ++;
		}
		
		else {
			System.out.println("Nombre Max de Classes atteint.");
		}
		
		
	}
	
	
	
	public void SupprimerClasse() {
		
		Classe classe = null;
		sc = new Scanner(System.in);
		while(classe == null) {
			System.out.println("Donner Code Classe :");
			System.out.print(">");
			classe = this.getClasseParCode(sc.nextLine());
		}
		
		
		boolean found = false;
		for (int i=0; i<nombreClasses; i++) {
			if (classes[i].getCode() == classe.getCode()) {
				
				found = true;
				for (int j=i; j <(nombreClasses-1); j++) {
					classes[j] = classes[++j];
				}
				
				classes[nombreClasses-1]=null;
				nombreClasses --;
				break;
			}
		}
		
		if (found == false) {
			System.out.println("Classe non Trouvée.");
		}
		else {
			System.out.println("Classe Supprimé avec Succès.");
		}
		
		
				
	}
	
	public void modifierClasse (GestionEleve gestion, GestionSeance gestionSe) {
		
		Classe classe = null;
		sc = new Scanner (System.in);
		String choix = "Non Défini";
		while (classe == null) {
			System.out.println("Donner Code Classe :");
			System.out.print(">");
			classe = this.getClasseParCode(sc.nextLine());
			
		}
		while (true) {
			System.out.println("\t[6.2.1].Ajouter Eleve.");
			System.out.println("\t[6.2.2].Ajouter Seance.");
			System.out.println("\t[6.2.3].Supprimer Eleve.");
			System.out.println("\t[6.2.4].Supprimer Seance");
			System.out.println("\t[X].Quitter.");
			System.out.print(">");
			choix = sc.nextLine();
			
			if (choix.equals("1")) {
				
				while (true) {
					System.out.println("\t\t[6.2.1.1].Ajouter Eleve.");
					System.out.println("\t\t[X].Quitter.");
					System.out.print(">");
					choix = sc.nextLine();
					if (choix.equals("1")) {
						System.out.println("Donner Matricule Eleve :");
						System.out.print(">");
						Eleve eleve = gestion.getEleveParMatricule(sc.nextLine());
						if (eleve != null) {
							classe.ajouterEleve(eleve);
							System.out.println("Elève ajouté avec Succès.");
						}
						else {
							System.out.println("Opération a échoué.");
							break;
						}
						
					}
					else if (choix.equalsIgnoreCase("x")) {
						break;
					}
					else {
						System.out.println("Commande Non Reconnue.");
					}
					
				}
			}
			
			else if (choix.equals("2")) {
				
				while (true) {
					System.out.println("\t\t[6.2.2.1].Ajouter Seance.");
					System.out.println("\t\t[X].Quitter");
					System.out.print(">");
					choix=sc.nextLine();
					
					if (choix.equals("1")) {
						System.out.println("Donner Code Seance : ");
						System.out.print(">");
						Seance seance = gestionSe.getSeanceParCode(sc.nextLine());
						if (seance != null) {
							classe.ajouterSeance(seance);
							System.out.println("Seance Ajouté avec Succès");
						}
						else {
							System.out.println("Opération a échoué.");
						}
					}
					
					else if (choix.equalsIgnoreCase("x")) {
						break;
					}
					else {
						System.out.println("Commande Non Reconnue.");
					}
				}
			}
			
			else if (choix.equals("3")) {
				System.out.println("Donner Matricule Eleve :");
				System.out.print(">");
				Eleve eleve = gestion.getEleveParMatricule(sc.nextLine());
				if (eleve != null) {
					classe.supprimerEleve(eleve);
					System.out.println("Elève Supprimé avec Succès");
				}
				else {
					System.out.println("Opération a échoué");
				}
				
			}
			
			else if (choix.equals("4")) {
				System.out.println("Donner Code Seance : ");
				System.out.print(">");
				Seance seance = gestionSe.getSeanceParCode(sc.nextLine());
				if (seance != null) {
					classe.supprimerSeance(seance);
					System.out.println("Seance Supprimé avec Succès");
				}
				else {
					System.out.println("Opération a échoué.");
				}
			}
			
			else if (choix.equalsIgnoreCase("x")) {
				break;
			}
			
			else {
				System.out.println("Commande Non Reconnue.");
			}
		}
	}
	
	private  Classe getClasseParCode (String code) {
		
		int i=0;
		for (i =0; i<nombreClasses; i++) {
			
			if (classes[i].getCode().equals(code)) {
				return classes[i];
			}
		}
		
		if (i == nombreClasses) {
			System.out.println("Classe Non Définie.");
		}
		return null;
		
	}
	
	public void afficherDetailsClasses () {
		
		sc = new Scanner (System.in);
		String choix = "", choix2="";
		
		while (true) {
			System.out.println("\t[6.4.1].Afficher Détails D'une classe.");
			System.out.println("\t[6.4.2].Afficher Liste des Eleves d'une Classe.");
			System.out.println("\t[6.4.3].Afficher Liste des Seances d'une classe.");
			System.out.println("\t[X].Quitter.");
			System.out.print(">");
			choix = sc.nextLine();
			if (choix.equals("1")) {
				System.out.println("Donner code Classe :");
				System.out.print(">");
				choix2 = sc.nextLine();
				int i=0;
				for (i=0; i<nombreClasses; i++) {
					if (classes[i].getCode().equals(choix2)) {
						classes[i].afficherDetails();
						break;
					}
				}
				if (i == nombreClasses) {
					System.out.println("Classe Non Définie");
				}
				
			}
			
			else if (choix.equals("2")) {
				System.out.println("Donner code Classe :");
				System.out.print(">");
				choix2 = sc.nextLine();
				int i=0;
				for (i=0; i<nombreClasses; i++) {
					if (classes[i].getCode().equals(choix2)) {
						classes[i].afficherListeEleves();
						break;
					}
				}
				if (i == nombreClasses) {
					System.out.println("Classe Non Définie");
				}
			}
			
			else if (choix.equals("3")) {
				System.out.println("Donner code Classe :");
				System.out.print(">");
				choix2 = sc.nextLine();
				int i=0;
				for (i=0; i<nombreClasses; i++) {
					if (classes[i].getCode().equals(choix2)) {
						classes[i].afficherListeSeances();
						break;
					}
				}
				if (i == nombreClasses) {
					System.out.println("Classe Non Définie");
				}
			}
			
			else if (choix.equalsIgnoreCase("x")) {
				break;
			}
			else {
				System.out.println("Commande Non Reconnue");
			}
			
		}
		
		
	}
	
	
	protected void supprimerEleve(Eleve e) {
		
		for (int i=0; i<nombreClasses; i++) {
			int nombreEleves = classes[i].getNombreEleves();
			Eleve [] eleves = classes[i].getListeEleve();
			Eleve [] eleves2 = new Eleve [20];
			int compteur = 0;
			for (int j=0; j<nombreEleves; j++) {
				if (!(eleves[j].getMatricule().equals(e.getMatricule()))) {
					eleves2[compteur] = eleves[j];
					compteur ++;
					
				}
			}
			classes[i].setListeEleves(eleves2);
			classes[i].setNombreEleves(compteur);
		}
	}
	
	protected void supprimerSeance (Seance s) {
		
		int compteur =0;
		for (int i=0; i<nombreClasses; i++) {
			int nombreSeances = classes[i].getNombreSeances();
			Seance [] seances = classes[i].getListeSeance();
			Seance [] seances2 = new Seance[20];
			for (int j=0; j<nombreSeances; j++) {
				if (!(seances[j].getCode().equals(s.getCode()))) {
					seances2[compteur] = seances[j]; 
					compteur ++;
						
				}
			}
			
			classes[i].setListeSeances(seances2);
			classes[i].setNombreSeances(compteur);
		}
	}
	
	protected void supprimerSeance (Personnel personnel) { /*Pour la suppression automatique des seances assurées par un
															personnel lorsque vous le suprrimer dans gestionPersonnel*/
		
		String matricule = personnel.getMatriculePersonnel();
		
		for (int i=0; i<nombreClasses; i++) {
			Seance [] seances = classes[i].getListeSeance();
			int nombreSeances = classes[i].getNombreSeances();
			int compteur = 0;
            Seance [] seances2 = new Seance [20];
			for (int j=0; j<nombreSeances; j++) {
				if (!(seances[j].getPersonnel().getMatriculePersonnel().equals(matricule))) {
					seances2[compteur] = seances[j];
					compteur ++;
				}
			}
			
			classes[i].setListeSeances(seances2);
			classes[i].setNombreSeances(compteur);
		}
		
	}
	
	
	
	
	
	
}
