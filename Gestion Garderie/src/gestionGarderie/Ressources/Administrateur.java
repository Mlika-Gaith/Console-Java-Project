package gestionGarderie.Ressources;

public class Administrateur extends Personne{
	
		private String nom_utilisateur = "administrateur";
		private String mot_de_passe = "administrateur";
	
	
	public Administrateur() {
		
	}
	
	public Administrateur(String nom, String prenom, String numeroCin, int numeroTelephone, String nom_utilisateur,
						String mot_de_passe) {
		
		super(nom,prenom,numeroCin,numeroTelephone);
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
		
	}
	
	public Administrateur(String nom, String prenom, String prenomPere, String numeroCin, int numeroTelephone, 
					 String dateNaissance, Adresse adresse, String imageProfil, String nom_utilisateur, String mot_de_passe) {
		
		super(nom,prenom,prenomPere,numeroCin,numeroTelephone,dateNaissance,adresse,imageProfil);
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
	}
	
	
	
	/** GETTERS **/
	
	public String getNomUtilisateur () {
		
		return nom_utilisateur;
		
	}
	public String getMotDePasse () {
		
		return mot_de_passe;
		
	}
	
	
	/** SETTERS **/
	
	public void setNomUtilisateur (String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}
	
	public void setMotDePasse (String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	
	
}
