package gestionGarderie.Interface;

import java.util.Scanner;

import gestionGarderie.Gestion.*;
import gestionGarderie.Ressources.*;


public class Interface {
		
	public static void main (String [] args) {
		Adresse adresse_garderie = new Adresse(2563,"Avenue Liberté","Sousse",4002,"Sousse");
		Garderie garderie = new Garderie("Garderie L'Intello","intello.gard@email.com",79458632,adresse_garderie);
		Administrateur admin = new Administrateur ("Paul","Paul","0012345678",29179200,"admin","admin");
		Inscription inscri = new Inscription();
		
		GestionEleve gestionE = new GestionEleve();
		GestionPersonnel gestionP = new GestionPersonnel();
		GestionSeance gestionS = new GestionSeance();
		GestionClasse gestionC = new GestionClasse();
		GestionAdministrateur gestionA = new GestionAdministrateur();
		GestionGarderie gestionG = new GestionGarderie();
		Interface.menu(gestionA, admin, gestionG, garderie, gestionP, gestionS, gestionC,gestionE,inscri);
	}
	
	private static void menu(GestionAdministrateur gestionA,Administrateur admin, GestionGarderie gestionG, Garderie garderie,
			GestionPersonnel gestionP, GestionSeance gestionS, GestionClasse gestionC, GestionEleve gestionE, Inscription inscri) 
	{
		
		
		int login = gestionA.login(admin);
		if (login == 1) {
			System.out.println("/////////////////////////////// Bonjour "+admin.getPrenom()+" ///////////////////////////////");
			System.out.println("\n\n");
			String choix = "";
			Scanner sc = new Scanner (System.in);
			while (!choix.equalsIgnoreCase("x")) {
				System.out.println("[1].Garderie.");
				System.out.println("[2].Administrateur.");
				System.out.println("[3].Personnels.");
				System.out.println("[4].Eleves.");
				System.out.println("[5].Seances.");
				System.out.println("[6].Classes.");
				System.out.println("[7].Inscription.");
				System.out.println("[8].Statistiques.");
				System.out.println("[X].Quitter.");
				System.out.print(">");
				
				choix = sc.nextLine();	
				
				switch (choix) {
					case "1":
						while (true)
						{
							System.out.println("[1.1].Afficher Informations Garderie.");
							System.out.println("[1.2].Modifier Informations Garderie.");
							System.out.println("[X].Quitter.");
							System.out.print(">");
							String c = sc.nextLine();
							if (c.equals("1")) 
								gestionG.afficherDetails(garderie);
							
							else if (c.equals("2")) 
								gestionG.modifierGardeire(garderie);
							
							else if (c.equalsIgnoreCase("x")) 
								break;
							
							else 
								System.out.println("Commande Non Reconnue");
							
						}
						
					break;
					
					case "2":
						while (true)
						{
							System.out.println("[2.1].Afficher Informations Personnelles.");
							System.out.println("[2.2].Modifier Informations Personnelles.");
							System.out.println("[2.3].Modifier Informations Login.");
							System.out.println("[X].Quitter.");
							System.out.print(">");
							String c = sc.nextLine();
							if (c.equals("1")) 
								gestionA.afficherInfoPersonnelles(admin);
							
							else if (c.equals("2")) 
								gestionA.modifierInfoPersonnelles(admin);
							
							else if (c.equals("3")) 
								gestionA.modifierLogin(admin);
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else
								System.out.println("Commande Non Reconnue");
							
						}
						break;
					case "3":
						while (true)
						{
							System.out.println("[3.1].Ajouter un Personnel.");
							System.out.println("[3.2].Modifier un Personnel.");
							System.out.println("[3.3].Supprimer un Personnel.");
							System.out.println("[3.4].Afficher Informations Personneles.");
							System.out.println("[3.5].Afficher Informations Personneles Avec Details.");
							System.out.println("[X].Quitter.");
							System.out.print(">");
							String c = sc.nextLine();
							
							if (c.equals("1"))
								gestionP.ajouterPersonnel();
							
							else if(c.equals("2"))
								gestionP.modifierPersonnel();
							
							else if (c.equals("3"))
								gestionP.supprimerPersonnel(gestionS, gestionC);
							
							else if (c.equals("4"))
								gestionP.afficherListePersonnel();
							
							else if (c.equals("5"))
								gestionP.afficherListePersonnelDetails();
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else
								System.out.println("Commande non Reconnue");
							
						}
						break;
						
					case "4":
						while (true) {
							System.out.println("[4.1].Ajouter un eleve.");
							System.out.println("[4.2].Modifier un eleve.");
							System.out.println("[4.3].Supprimer un eleve.");
							System.out.println("[4.4].Afficher Informations Eleves.");
							System.out.println("[4.5].Afficher Informations Eleves Avec Details.");
							System.out.println("[X].Quitter.");
							System.out.print(">");
							String c = sc.nextLine();
							
							if (c.equals("1"))
								gestionE.ajouterEleve();
							
							else if (c.equals("2"))
								gestionE.modifierEleve();
							
							else if (c.equals("3"))
								gestionE.supprimerEleve(gestionC);
							
							else if (c.equals("4"))
								gestionE.afficherListeEleves();
							
							else if (c.equals("5"))
								gestionE.afficherListeElevesDetails();
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else
								System.out.println("Commande Non Reconnue");
							
						}
						break;
						
					case "5":
						while (true)
						{
							System.out.println("[5.1].Ajouter une Seance.");
							System.out.println("[5.2].Modifier une seance.");
							System.out.println("[5.3].Supprimer une Seance.");
							System.out.println("[5.4].Afficher Les Seances.");
							System.out.println("[X].Quitter.");
							String c = sc.nextLine();
							
							if (c.equals("1"))
								gestionS.ajouterSeance(gestionP);
							
							else if (c.equals("2"))
								gestionS.modifierSeance(gestionP);
							
							else if (c.equals("3"))
								gestionS.supprimerSeance(gestionC);
							
							else if (c.equals("4"))
								gestionS.afficherSeanceDetails();
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else
								System.out.println("Commande Non Reconnue");
							
						}
						break;
						
					case "6":
						while (true)
						{
							System.out.println("[6.1].Ajouter une Classe.");
							System.out.println("[6.2].Modifier une Classe.");
							System.out.println("[6.3].Supprimer une Classe.");
							System.out.println("[6.4].Afficher Les Classes.");
							System.out.println("[X].Quitter.");
							String c = sc.nextLine();
							
							if (c.equals("1"))
								gestionC.ajouterClasse();
							
							else if (c.equals("2"))
								gestionC.modifierClasse(gestionE, gestionS);
							
							else if (c.equals("3"))
								gestionC.SupprimerClasse();
							
							else if (c.equals("4"))
								gestionC.afficherDetailsClasses();
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else 
								System.out.println("Commande Non Reconnue");
								
							
						}
						break;
						
					case "7":
						while(true)
						{
							System.out.println("[7.1].Definir frais Inscription Niveau A.");
							System.out.println("[7.2].Definir frais Inscription Niveau B.");
							System.out.println("[7.3].Definir frais Inscription Niveau C.");
							System.out.println("[7.4].Afficher les frais Inscription d'un Eleve.");
							System.out.println("[7.5].Confirmer le Payement d'un Eleve.");
							System.out.println("[X].Quitter.");
							System.out.print(">");
							String c = sc.nextLine();
							
							if (c.equals("1"))
							{
								System.out.println("Donner frais Inscription Niveau A : ");
								System.out.print(">");
								double fa = sc.nextDouble();
								sc.nextLine();
								inscri.setFraisNiveau_A(fa);
							}
							
							else if (c.equals("2"))
							{
								System.out.println("Donner frais Inscription Niveau B : ");
								System.out.print(">");
								double fb = sc.nextDouble();
								sc.nextLine();
								inscri.setFraisNiveau_B(fb);
							}
							
							else if (c.equals("3"))
							{
								System.out.println("Donner frais Inscription Niveau C : ");
								System.out.print(">");
								double fc = sc.nextDouble();
								sc.nextLine();
								inscri.setFraisNiveau_C(fc);
							}
							
							else if (c.equals("4"))
							{
								double total = inscri.fraisTotalEtudiant(gestionE, gestionC);
								System.out.println("Total : "+total+" DT.");
							}
								
							
							else if (c.equals("5"))
								inscri.confirmerPayement(gestionE);
							
							else if (c.equalsIgnoreCase("x"))
								break;
							
							else 
								System.out.println("Commande Non Reconnue");
								
						}
						break;
						
					case "8":
						System.out.println("Nombre d 'eleves Total : "+gestionE.getNombreEleves());
						System.out.println("Nombre de Personnels Total : "+gestionP.getNombrePersonnels());
						System.out.println("\t\tDont Animateurs : "+gestionP.getNombreAnimateur());
						System.out.println("\t\tDont Employees : "+gestionP.getNombreEmployees());
						System.out.println("Nombre de Seances Total : "+gestionS.getNombreSeances());
						System.out.println("\t\tDont Cours : "+gestionS.getNombreCours());
						System.out.println("\t\tDont Activites : "+gestionS.getNombreActivites());
						System.out.println("Nombre de Classes : "+gestionC.getNombreClasses());
					break;
					
					case "x":
						System.out.println("\n\n");
						System.out.println("/////////////////////////////// Au Revoir "+admin.getPrenom()+" ///////////////////////////////");
						break;
					case "X":
						System.out.println("\n\n");
						System.out.println("/////////////////////////////// Au Revoir "+admin.getPrenom()+" ///////////////////////////////");
						break;
					default :
						System.out.println("Commande Non Reconnue.");
							
				}
				
				
			}
		}
		
		else {
			System.out.println("Operation A Echoue");
		}
	}
		

}
