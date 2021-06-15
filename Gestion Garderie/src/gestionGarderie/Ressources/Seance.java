package gestionGarderie.Ressources;

public class Seance {
	
	
	/** LES ATTRIBUTS **/
	
	private static int id = 0;
	private String code = "00"+id,
			type = "Activité/Cours",
			designation = "Non Définie";
	private Personnel responsable;
	
	/** LES CONSTRUCTEURS **/
	
	public Seance (){
		
		id++;
		responsable = new Personnel();
		code = type.toLowerCase()+"00"+id;
		
	}
	
	public Seance (String type, String designation, Personnel responsable){
		
		id++;
		this.type = type;
		this.designation = designation;
		this.responsable = responsable;
		code = type.toLowerCase()+"00"+id;
		
	}
	
	
	/** LES SETTERS **/
	
	public void setType( String type) {
		
		this.type = type.toLowerCase();
		
	}
	
	
	public void setDesignation(String designation) {
		
		this.designation = designation;
		
	}
	
	public void setResponsable (Personnel responsable) {
		
		this.responsable = responsable;
	}
	
	public void setCode (String numero) {
		code = type.toLowerCase()+numero;
	}
	
	/** LES GETTERS **/
	
	public String getType() {
		
		return type;
	}
	
	public String getCode() {
		
		return code;
	}
	public String getCodeNumero() {
		return code.substring(code.indexOf('0'));
	}
	
	public String getDesignation() {
		
		return designation;
	}
	
	public Personnel getPersonnel() {
		
		return responsable;
	}
	
	/** LES METHODES **/
	
	
}
