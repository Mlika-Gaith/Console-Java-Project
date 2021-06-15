package gestionGarderie.Ressources;

public class Garderie {
		
		private String nom = "garderie", email ="@garderie";
		private int numero = 0;
		private Adresse adresse;
		
		public Garderie (String nom, String email, int numero, Adresse adresse) {
			this.adresse = adresse;
			this.email = email;
			this.nom = nom;
			this.numero = numero;
		}
		
		public Garderie () {
			
		}
		
		/** GETTERS **/
		
		public String getNom() {
			return nom;
		}
		
		public String getEmail() {
			return email;
		}
		public Adresse getAdresse() {
			return adresse;
		}
		public int getNumero() {
			return numero;
		}
		
		/** SETTERS **/
		
		public void setNom(String nom) {
			this.nom = nom;
		}
		public void setEmail (String email) {
			this.email = email;
		}
		public void setNumero( int numero) {
			this.numero = numero;
		}
		public void setAdresse (Adresse adresse) {
			this.adresse = adresse;
		}
}
