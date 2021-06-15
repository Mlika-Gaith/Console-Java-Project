package gestionGarderie.Ressources;

public abstract class Personne {

		
	
	/** LES ATTRIBUTS **/
	
	private static int id = 0;
	private int numeroTelephone = 0;
	private String nom = "Non Défini",
				prenom = "Non Défini",
				prenomPere = "Non Défini",
				numeroCin = "0000",
				dateNaissance = "jj/mm/aaaa",
				imageProfil = "nonDéfinie.png";
	private Adresse adresse;
	
	
	/** LES CONSTRUCTEURS **/
	
	public Personne() {
		
		id++;
		adresse = new Adresse();
	}
	
	public Personne (String nom, String prenom, String numeroCin, int numeroTelephone) {
		
		id++;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroCin= numeroCin;
		this.numeroTelephone =  numeroTelephone;
		adresse = new Adresse();
		
	}
	
	public Personne (String nom, String prenom, String prenomPere, String numeroCin, int numeroTelephone, 
					 String dateNaissance, Adresse adresse, String imageProfil) {
		
		id++;
		this.nom = nom;
		this.prenom = prenom;
		this.prenomPere = prenomPere;
		this.numeroCin = numeroCin;
		this.numeroTelephone = numeroTelephone;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.imageProfil = imageProfil;
		
	}
	
	/** LES SETTERS **/
	
	public void setNom(String nom) {
		
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		
		this.prenom = prenom;
	}
	
	public void setPrenomPere(String prenomPere) {
		
		this.prenomPere = prenomPere;
		
	}
	
	public void setNumeroCin (String numeroCin) {
		
		this.numeroCin = numeroCin;
		
	}
	
	public void setNumeroTelephone (int numeroTelephone) {
		
		this.numeroTelephone = numeroTelephone;
	}
	
	public void setDateNaissance (String dateNaissance) {
		
		this.dateNaissance = dateNaissance;
	}
	
	public void setImageProfil (String imageProfil ) {
		
		this.imageProfil = imageProfil;
	}
	
	public void setAdresse (Adresse adresse) {
		
		this.adresse = adresse;
	}
	
	
	
	
	/** LES GETTERS **/
	
	public static int getId () {
		
		return id;
		
	}
	
	public String getNom() {
		
		return nom;
	}
	
	public String getPrenom() {
		
		return prenom;
	}
	
	public String getPrenomPere() {
		
		return prenomPere;
	}
	
	public String getNumeroCin () {
		
		return numeroCin;
	}
	
	public int getNumeroTelephone () {
		
		return numeroTelephone;
	}
	
	public String getDateNaissance () {
		
		return dateNaissance;
	}
	
	public String getImageProfil () {
		
		return imageProfil;
	}
	public Adresse getAdresse() {
		
		return adresse;
		
	}
	
	
	
	/** LES METHODES **/
	
	
	
	public int verifierDate (String dateNaissance) {
		
		if (dateNaissance.equals("")) {
			return -1;
		}
		else {
			if (dateNaissance.length() == 10)
			{
				if (dateNaissance.charAt(2) != '/' || dateNaissance.charAt(5) != '/') 
					return -1;
			}
			else
				return -1;
			
			String date [] = dateNaissance.split("/", 3);
			int jour = Integer.parseInt(date[0]);
			int mois = Integer.parseInt(date[1]);
			int an = Integer.parseInt(date[2]);
			
			int bissextile = 0;
			int moisMax = 12;
			int jourMax = 0;
			
			if ((an%4 == 0 && an%100 != 0) || an%400 ==0) {
				bissextile = 1;
			}
			
			if (mois<0 || mois>moisMax || an<1940 || an>2020) {
				return -1;
			}
			
			switch (mois) {
				
			case 4:
			case 6:
			case 9:
			case 11:
				jourMax = 30;
				break;
			case 2:
				if (bissextile == 1) {
					jourMax = 29;
				}
				else {
					jourMax = 28;
				}
				break;
			default: jourMax =31;
				break;
			
			}
			
			if (jour > jourMax)
				return -1;
			return 1;
		}
		
		
		
	}
	
	public int verifierNumero (int numero) {
	
	
		int longueur = (int) (Math.floor(Math.log10(numero))+1);
		
		if (longueur != 8 || numero <0 )
			return -1;
	
		return 1;
	}
}
