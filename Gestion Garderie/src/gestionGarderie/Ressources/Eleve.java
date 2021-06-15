package gestionGarderie.Ressources;

public class Eleve extends Personne {
	
	/** LES ATTRIBUTS **/
	
	private String prenomGrandPere = "Non Défini",
				   prenomMere = "Non Défini",
				   nomMere = "Non Défini",
				   niveauScolaire = "Non Défini",
				   matricule = "eleve00"+getId();
	private boolean payer = false;
	
	/**LES CONSTRUCTEURS **/
	
	public Eleve  () {
		
	}
	
	public Eleve (String nom, String prenom, String numeroCin, int numeroTelephone, String niveauScolaire) {
		
		super (nom,prenom,numeroCin,numeroTelephone);
		this.niveauScolaire = niveauScolaire;
		
	}
	
	public Eleve (String nom, String prenom, String prenomPere, String prenomGrandPere, String nomMere,
			String prenomMere, String numeroCin, int numeroTelephone, String dateNaissance, Adresse adresse,
			String imageProfil, String niveauScolaire) {
			
			super (nom,prenom,prenomPere,numeroCin,numeroTelephone,dateNaissance,adresse,imageProfil);
			
			this.prenomGrandPere = prenomGrandPere;
			this.prenomMere = prenomMere;
			this.nomMere = nomMere;
			this.niveauScolaire = niveauScolaire;
	}
	
	
	/** LES SETTERS **/
	
	public void setPrenomGrandPere (String prenomGrandPere) {
		
		this.prenomGrandPere = prenomGrandPere;
		
	}
	
	public void setPrenomMere (String prenomMere) {
		
		this.prenomMere = prenomMere;
		
	}
	
	public void setNomMere (String nomMere) {
		
		this.nomMere = nomMere;
	}
	
	public void setNiveauScolaire (String niveauScolaire) {
		
		this.niveauScolaire = niveauScolaire;
	}
	
	public void setPayer (boolean payer) {
		this.payer =  payer;
	}
	
	/** LES GETTERS **/
	
	public String getMatricule() {
		
		return matricule;
	}
	
	public String getPrenomGrandPere() {
		
		return prenomGrandPere;
		
	}
	
	public String getPrenomMere() {
		
		return prenomMere;
		
	}
	
	public String getNomMere() {
		
		return nomMere;
	}
	
	public String getNiveauScolaire() {
		
		return niveauScolaire;
	}
	
	public boolean isPayer() {
		return payer;
	}
	
	

}
