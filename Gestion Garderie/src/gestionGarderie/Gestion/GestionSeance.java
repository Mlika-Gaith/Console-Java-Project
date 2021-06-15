package gestionGarderie.Gestion;

import java.util.Scanner;


import gestionGarderie.Ressources.*;

public class GestionSeance {
	
	
	/** LES ATTRIBUTS **/
	private Seance [] seances;
	private int nombreSeances = 0;
	private Scanner sc;
	
	/** LES CONSTRUCTEURS **/
	
	public GestionSeance () {
		
		seances = new Seance [200];
	}
	/** Les SETTERS **/
	
	public void setNombreSeances (int nombreSeances) {
		this.nombreSeances = nombreSeances;
	}
	
	/** LES GETTERS **/
	
	public  int getNombreSeances () {
		
		return nombreSeances;
	}
	
	public Seance [] getListeSeances () {
		
		return seances;
	}
	
	/** LES METHODES **/
	
	public int getNombreCours () {
		int compteur = 0;
		for (int i = 0; i< nombreSeances; i++) {
			if (seances[i].getType().equalsIgnoreCase("cours"))
				compteur ++;
		}
		
		return compteur;
	}
	
	public int getNombreActivites() {
		int compteur = 0;
		for (int i = 0; i<nombreSeances; i++) {
			if (seances[i].getType().equalsIgnoreCase("activité"))
				compteur ++;
		}
		
		return compteur ++;
	}
	
	public void ajouterSeance (GestionPersonnel personnelG) {
		
		if ( nombreSeances <200) {
			
			
			sc = new Scanner (System.in);
			Seance seance = new Seance ();
			String numero = seance.getCodeNumero();
			String choix = "Non Défini";
			while (true) {
				System.out.println("\t[5.1.1].Ajouter Une Séance.");
				System.out.println("\t[X].Quitter.");
				System.out.print(">");
				choix=sc.nextLine();
				
				if (choix.equals("1")) {
					String type ="Non Défini";
					while (!(type.equalsIgnoreCase("activité") || type.equalsIgnoreCase("cours"))) {
						System.out.println("Donner Type Séance : ");
						System.out.print(">");
						type = sc.nextLine();
					}
					seance.setType(type);
					seance.setCode(numero);
					System.out.println("Donner Désignation Séance : ");
					System.out.print(">");
					seance.setDesignation(sc.nextLine());
					String mat = "";
					Personnel personnel = null;
					do {
						System.out.println("Donner Matricule du Personnel : ");
						System.out.print(">");
						mat = sc.nextLine();
						if (mat.contains("animateur"))
							personnel = personnelG.getPersonnelParMatricule(mat);
						else 
							System.out.println("ce type d'Employee ne peut pas assurer une Seance.");
					}while(!mat.contains("animateur"));
					
					if (personnel != null) {
						seance.setResponsable(personnel);
						seances[nombreSeances] =seance;
						nombreSeances ++;
						
						System.out.println("Seance Ajoutée avec Succes.");
						break;
					}
					else {
						System.out.println("Opération a échoué");
						break;
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
		
		else {
			System.out.println("Nombre Max de Seances atteint.");
		}
		
		
		
	}
	
	public void modifierSeance (GestionPersonnel personnelG) {
		
		Seance seance = null;
		sc = new Scanner (System.in);
		System.out.println("Donner Code Seance : ");
		System.out.print(">");
		seance = this.getSeanceParCode(sc.nextLine());
		
		if (seance != null) {
			String numero = seance.getCodeNumero();
			String choix = "Non défini";
			
			for (int i=0; i<nombreSeances; i++) {
				if (seances[i].getCode() == seance.getCode()) {
					
					while (true) {
						System.out.println("\t[5.2.1].Modifier Seance.");
						System.out.println("\t[X].Quitter.");
						System.out.print(">");
						choix = sc.nextLine();
						
						if (choix.equals("1")) {
							String type = "Non Défini";
							while (!(type.equalsIgnoreCase("activité") || type.equalsIgnoreCase("cours"))) {
								System.out.println("Donner Type Séance : ");
								System.out.print(">");
								type = sc.nextLine();
							}
							seance.setType(type);
							seance.setCode(numero);
							System.out.println("Donner Désignation : ");
							seance.setDesignation(sc.nextLine());
							Personnel personnel =null;
							while (personnel == null) {
								String mat = "";
								do {
									System.out.println("Donner Matricule Animateur : ");
									System.out.print(">");
									mat = sc.nextLine();
									if (mat.contains("animateur"))
										personnel = personnelG.getPersonnelParMatricule(mat);
									else
										System.out.println("Ce Personnel ne peut pas assurer une Seance");
								}while(!mat.contains("animateur"));
								
							}
							seance.setResponsable(personnel);
							System.out.println("Modification Avec Succes.");
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
	
	public void supprimerSeance (GestionClasse gestionC) {
		
		Seance seance = null;
		sc = new Scanner (System.in);
		System.out.println("Donner Code Seance :");
		System.out.print(">");
		seance = this.getSeanceParCode(sc.nextLine());
		
		if (seance != null) {
			for (int i=0; i<nombreSeances; i++) {
				if (seances[i].getCode() == seance.getCode()) {
					for (int j=i; j<nombreSeances-1; j++) {
						seances[j] = seances[++j];
					}
					seances[nombreSeances]=null;
					nombreSeances --;
					gestionC.supprimerSeance(seance);
					System.out.println("Suppression avec Succes.");
					break;
				}
				
			}
		}	
	}
	
	public Seance getSeanceParCode (String code) {
		
		for (int i=0; i<nombreSeances; i++) {
			if (seances[i].getCode().equals(code)) {
				return seances[i];
			}
		}
		System.out.println("Aucune Seance Avec ce Code.");
		return null;
	}
	
	public void afficherSeanceDetails () {
		
		if (nombreSeances > 0) {
			Affichage a = new Affichage ();
			a.setColumnWidth(28);
			a.setColumnNumber(5);
			a.setTitle("Liste de Toutes les Seances");
			String [] titles = {"Code","Type","Désignation","Animateur","Matricule Animateur"};
			a.setColumnTitles(titles);
			
			for (int i=0; i<nombreSeances; i++) {
				a.addColumn(seances[i].getCode());
				a.addColumn(seances[i].getType());
				a.addColumn(seances[i].getDesignation());
				a.addColumn(seances[i].getPersonnel().getNom() +" "+
							seances[i].getPersonnel().getPrenom());
				a.addLastColumn(seances[i].getPersonnel().getMatriculePersonnel());
				a.endLine();
			}
			
		}
		else {
			System.out.println("Aucune Seance à Afficher.");
		}
		
	}
	
	protected void supprimerSeance (Personnel personnel) { /*Suppression Automatique de toutes les seances
																				Dans la liste des seances (seances) lorsque vous supprimez un animateur dans Gestion
																				Personnel*/
		
		String matricule = personnel.getMatriculePersonnel();
		int compteur = 0;
		for (int i=0; i<nombreSeances; i++) {
			Personnel p = seances [i].getPersonnel();
			if (p.getMatriculePersonnel().equals(matricule)) {
				compteur ++;
				for (int j=i; j<(nombreSeances-1); j++) {
					seances[j] = seances[++j];
				}
			}
		}
		for (int k=(nombreSeances-compteur); k<nombreSeances; k++) {
			seances[k]=null;
		}
		this.setNombreSeances((nombreSeances - compteur));
		
	}
}
