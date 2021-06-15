package gestionGarderie.Ressources;

public class Adresse {

	/** LES ATTRIBUTS **/
	
	private int numeroRue_Avenue = 0000,
				codePostal = 0000;
	private String designationRue_Avenue = "Non Définie",
					ville = "Non Définie",
					gouvernorat = "Non Défini";
	
	/** LES CONSTRUCTEURS **/
	
	public Adresse() {
		
	}
	
	public Adresse(int numeroRue_Avenue, String designationRue_Avenue, String ville, int codePostal, String gouvernorat) {
		
		this.numeroRue_Avenue = numeroRue_Avenue;
		this.designationRue_Avenue= designationRue_Avenue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.gouvernorat = gouvernorat;
	}
	
	
	/** LES SETTERS **/
	
	public void setNumeroRue_Avenue (int numeroRue_Avenue) {
		
		this.numeroRue_Avenue = numeroRue_Avenue;
	}
	
	public void setDesignationRue_Avenue (String designationRue_Avenue) {
		
		this.designationRue_Avenue = designationRue_Avenue;
	}
	
	public void setVille (String ville) {
		this.ville = ville;
	}
	
	public void setCodePostal (int codePostal) {
		
		this.codePostal = codePostal;
	}
	
	public void setGouvernorat (String gouvernorat) {
		
		this.gouvernorat = gouvernorat;
	}
	
	
	
	/** LES GETTERS **/
	
	public int getNumeroRue_Avenue() {
		
		return numeroRue_Avenue;
	}
	
	public String getDesignationRue_Avenue() {
		
		return designationRue_Avenue;
	}
	
	public String getVille() {
		
		return ville;
	}
	
	public int getCodePostal() {
		
		return codePostal;
	}
	
	public String getGouvernorat () {
		
		return gouvernorat;
	}
	
	/** LES METHODES **/
	
	
}
