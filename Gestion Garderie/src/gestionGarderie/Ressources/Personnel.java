package gestionGarderie.Ressources;

public class Personnel extends Personne{
	
	/** LES ATTRIBUTS **/
	
	private String type ="Employee/Animateur",
				   matriculePersonnel = type+"00"+getId();
	
	/** LES CONSTRUCTEURS **/
	
	public Personnel(){
		
		matriculePersonnel = type+"00"+getId();
	}
	
	public Personnel(String type, String nom, String prenom, String numeroCin, int numeroTelephone){
		
		super(nom,prenom,numeroCin,numeroTelephone);
		this.type=type;
		matriculePersonnel = type+"00"+getId();
		
	}
	
	public Personnel(String type, String nom, String prenom, String prenomPere, String numeroCin, int numeroTelephone,
			  String dateNaissance,Adresse adresse,String imageProfil){
			
		super(nom,prenom,prenomPere,numeroCin,numeroTelephone,dateNaissance,adresse,imageProfil);
		this.type=type;
		matriculePersonnel = type+"00"+getId();
	}
	
	/** SIMPLE SETTER **/
	
	public void setType(String type) {
		
		this.type=type;
	}
	
	public void setMatricule(String type) {
		this.matriculePersonnel=type.toLowerCase()+"00"+getId();
	}
	
	public void setMatricule(String type , String number) {
		this.matriculePersonnel=type.toLowerCase()+number;
	}
	/** SIMPLE GETTER **/
	
	public String getType() {
		
		return type;
		
	}
	
	public String getMatriculePersonnel() {
		
		return matriculePersonnel;
		
	}
	public String getMatriculeNumero() {
		
		return matriculePersonnel.substring(matriculePersonnel.indexOf('0'));
	}
	
	/** LES METHODES **/
	
	
}
