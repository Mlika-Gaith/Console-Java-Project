package gestionGarderie.Ressources;

import gestionGarderie.Gestion.Affichage;

public class Classe {
	
	/** LES ATTRIBUTS **/
	
	private static int classeId = 0;
	private String nom = "Non Définie",
				   code = "Non Défini";
	private Eleve [] listeEleve;
	private Seance [] listeSeance;
	private int nombreEleves = 0,
				nombreSeances = 0;
	
	
	/** LES CONSTRUCTEURS **/
	
	public Classe () {
		
		classeId++;
		listeEleve = new Eleve [20]; //20 ELEVES PAR CLASSE
		listeSeance = new Seance[20]; //20 SEANCES COMME MAX POUR CHAQUE CLASSE
		code ="Classe00"+classeId;
	}
	
	public Classe (String nom) {
		
		classeId++;
		this.nom = nom;
		listeEleve = new Eleve[20];
		listeSeance = new Seance[20];
		code ="classe00"+classeId;
	}
	
	/** SETTERS **/
	
	public void setNom (String nom) {
		
		this.nom = nom;
		
	}
	
	public void setNombreEleves (int nombreEleves) {
		this.nombreEleves = nombreEleves;
	}
	
	public void setListeEleves (Eleve [] eleves) {
		listeEleve = eleves;
	}
	
	public void setNombreSeances( int nombreSeances) {
		this.nombreSeances = nombreSeances;
	}
	
	public void setListeSeances (Seance [] seances) {
		listeSeance = seances;
	}
	
	/** GETTERS **/
	
	public String getNom () {
		
		return nom;
		
	}
	
	public String getCode() {
		return code;
	}
	
	public Seance [] getListeSeance () {
		
		return listeSeance;
	}
	
	public Eleve [] getListeEleve () {
		
		return listeEleve;
	}
	
	public int getNombreEleves() {
		return nombreEleves;
	}
	
	public int getNombreSeances() {
		return nombreSeances;
	}
	
	
	/** LES METHODES **/
	
	public void ajouterEleve(Eleve eleve) {
		
		if (nombreEleves <20) {
			
			listeEleve [nombreEleves] = eleve;
			nombreEleves ++;
			
		}
		else {
			System.out.println("Nombre Max d'éléves par Classe atteint.");
		}
			
	}
	
	public void supprimerEleve (Eleve eleve) {
		
		boolean found = false;
		for (int i =0; i<nombreEleves; i++) {
			
			if (listeEleve[i].getMatricule() == eleve.getMatricule()) {
				found = true;
				for ( int j=i; j<(nombreEleves-1); j++) {
					listeEleve[i]=listeEleve[++j];
					
				}
				listeEleve[nombreEleves-1]=null;
				nombreEleves --;
				break;
			}
		}
		
		if (found == false) {
			System.out.println("Eleve non inscrit dans cette classe.");
		}
	}
	
	public void ajouterSeance (Seance seance) {
		
		if (nombreSeances <20) {
			listeSeance[nombreSeances] = seance;
			nombreSeances ++;
			
		}
		else {
			System.out.println("Nombre Max de Seances par Classe atteint.");
		}
	}
	
	public void supprimerSeance (Seance seance) {
		
		boolean found = false;
		for (int i=0; i<nombreSeances; i++) {
			if (listeSeance[i].getCode() == seance.getCode()) {
				found = true;
				for (int j=i; j<(nombreSeances-1); j++) {
					listeSeance[j]= listeSeance[++j];
					
				}
				listeSeance[nombreSeances-1]=null;
				nombreSeances --;
				break;
			}
		}
		
		if (found == false) {
			System.out.println("Séance Non Définie dans cette classe");
		}
	}
	
	public void afficherDetails() {
		
		Affichage a = new Affichage ();
		a.setColumnWidth(24);
		a.setColumnNumber(4);
		String [] titles = {"Code","Nom","Nombre d'Eleves","Nombre de Seances"};
		a.setTitle("Classe");
		a.setColumnTitles(titles);
		a.addColumn(code);
		a.addColumn(nom);
		a.addColumn(""+nombreEleves);
		a.addLastColumn(""+nombreSeances);
		a.endLine();
		
	}
	
	public void afficherListeEleves() {
		
		Affichage a = new Affichage();
		
		a.setColumnWidth(25);
		a.setColumnNumber(4);
		String [] titles = {"Matricule","Nom","Prenom","Niveau Scolaire"};
		a.setTitle("Liste Des Eleves");
		a.setColumnTitles(titles);
		
		int i =0;
		for (i =0; i<nombreEleves; i++) {
			a.addColumn(listeEleve[i].getMatricule());
			a.addColumn(listeEleve[i].getNom());
			a.addColumn(listeEleve[i].getPrenom());
			a.addLastColumn(listeEleve[i].getNiveauScolaire().toUpperCase());
			a.endLine();
		}
		
		if (i == 0) {
			System.out.println("Aucun Elève Dans Cette Classe.");
		}
	}
	
	public void afficherListeSeances () {
		
		Affichage a = new Affichage();
		a.setColumnWidth(25);
		a.setColumnNumber(5);
		String [] titles = {"Code","Type","Designation","Animateur","Matricule Animateur"};
		a.setTitle("Liste des Seances");
		a.setColumnTitles(titles);
		
		int i=0;
		for (i =0; i<nombreSeances; i++) {
			a.addColumn(listeSeance[i].getCode());
			a.addColumn(listeSeance[i].getType());
			a.addColumn(listeSeance[i].getDesignation());
			a.addColumn(listeSeance[i].getPersonnel().getNom()+" "+
						listeSeance[i].getPersonnel().getPrenom());
			a.addLastColumn(listeSeance[i].getPersonnel().getMatriculePersonnel());
			a.endLine();
		}
		if (i == 0) {
			System.out.println("Aucune Séance Dans Cette Classe.");
		}
	}
	
	
	
}
