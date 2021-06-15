package gestionGarderie.Ressources;

import java.util.Scanner;

import gestionGarderie.Gestion.GestionClasse;
import gestionGarderie.Gestion.GestionEleve;

public class Inscription {
		
		private static int inscriptionId = 0;
		private double frais_Niveau_A = 0.00,
					   frais_Niveau_B = 0.00,
					   frais_Niveau_C = 0.00;
		Scanner sc;
		
		/** LES CONSTRUCTEURS **/
		
		public Inscription () {
			
			inscriptionId ++;
			
		}
		
		public Inscription (double frais_Niveau_A, double frais_Niveau_B, double frais_Niveau_C) {
			
			inscriptionId ++;
			this.frais_Niveau_A = frais_Niveau_A;
			this.frais_Niveau_B = frais_Niveau_B;
			this.frais_Niveau_C = frais_Niveau_C;
			
		}
		
		/** SIMPLES SETTERS **/
		
		public void setFraisNiveau_A (double frais_Niveau_A) {
			
			this.frais_Niveau_A = frais_Niveau_A;
			
		}
		
		public void setFraisNiveau_B (double frais_Niveau_B) {
			
			this.frais_Niveau_B = frais_Niveau_B;
			
		}
		
		public void setFraisNiveau_C (double frais_Niveau_C) {
			
			this.frais_Niveau_C = frais_Niveau_C;
			
		}
		
		
		/** Simples Getters **/
		
		public double getFraisNiveau_A () {
			
			return frais_Niveau_A;
			
		}
		
		public double getFraisNiveau_B () {
			
			return frais_Niveau_B;
			
		}
		
		public double getFraisNiveau_C () {
			
			return frais_Niveau_C;
			
		}
		
		/** LES METHODES **/
		
		public double fraisTotalEtudiant(GestionEleve gestionE, GestionClasse gestionC) {
			
			sc = new Scanner (System.in);
			
			System.out.println("Donner Matricule Eleve :");
			System.out.print(">");
			Eleve eleve = gestionE.getEleveParMatricule(sc.nextLine());
			String niveau = eleve.getNiveauScolaire();
			
			double frais = 0.00, somme = 0.00;
			
			if (niveau.equalsIgnoreCase("a")) {
				frais = frais_Niveau_A;
			}
			else if (niveau.equalsIgnoreCase("b")) {
				frais = frais_Niveau_B;
			}
			else if (niveau.equalsIgnoreCase("c")){
				frais = frais_Niveau_C;
			}
			
			Classe [] classes = gestionC.getListeClasses();
			int nombreClasses = gestionC.getNombreClasses();
			for (int i=0; i<nombreClasses; i++) {
				
				Eleve [] eleves = classes[i].getListeEleve();
				int nombreEleves = classes[i].getNombreEleves();
				for (int j=0; j<nombreEleves; j++) {
					if (eleves[i].getMatricule().equals(eleve.getMatricule())) {
	
						int nombreSeances = classes[i].getNombreSeances();
						
						for (int k=0; k<nombreSeances; k++) {
							somme += frais;
						}
					}
				}
			}
			
		
			
			return somme;
					
		}
		
		public void confirmerPayement (GestionEleve gestionE) {
			System.out.println("Donner Matricule Eleve :");
			System.out.print(">");
			Eleve eleve = gestionE.getEleveParMatricule(sc.nextLine());
			String matricule = eleve.getMatricule();
			System.out.println("Voulez Vous Confirmez Le Paiement de L'eleve Avec La mtricule : "+matricule);
			while(true) {
				String choix = "";
				System.out.println("[oui].Confirmer");
				System.out.println("[non].Annuler");
				System.out.print(">");
				choix = sc.nextLine();
				if (choix.equalsIgnoreCase("oui")) {
					eleve.setPayer(true);
					break;
				}
				else if (choix.equalsIgnoreCase("non")) {
					break;
				}
				else {
					System.out.println("Commande Non Reconnue");
				}
			}
			
		}
		
		
		
		
		
		
		
}
