package cartes;

import java.util.Iterator;

public class JeuDeCartes {
	private Configuration[] typeDeCartes ; // instance de la classe interne 
	public JeuDeCartes() {
		typeDeCartes = new Configuration[19]; //tab de 19 cartes 
		//tab de cartes (km, feu v,feu r,fin lim, 50lim, bid ess, pann, roue sec, crev,acc, rep)
		int[] nbCartes= new int[] {10,10,10,12,4,14,5,6,4,6,3,6,3,6,3,1,1,1,1};//19 types cartes diff
		Carte[] cartes = new Carte[19];
		
		cartes[0]= new Borne(25);
		cartes[1]= new Borne(50);
		cartes[2]= new Borne(75);
		cartes[3]= new Borne(100);
		cartes[4]= new Borne(200);
		cartes[5]= new Parade(Type.FEU); //def comme feu vert deja
		cartes[6]= new Attaque(Type.FEU); //def comme feu rouge
		cartes[7]= new FinLimite();
		cartes[8]= new DebutLimite();
		cartes[9]= new Parade(Type.ESSENCE);
		cartes[10]= new Attaque(Type.ESSENCE);
		cartes[11]= new Parade(Type.CREVAISON);
		cartes[12]= new Attaque(Type.CREVAISON);
		cartes[13]= new Parade(Type.ACCIDENT);
		cartes[14]= new Attaque(Type.ACCIDENT);
		cartes[15]= new Botte(Type.FEU);
		cartes[16]= new Botte(Type.ESSENCE);
		cartes[17]= new Botte(Type.CREVAISON);
		cartes[18]= new Botte(Type.ACCIDENT);
		
		for (int i = 0; i < 19; i++) {
	        typeDeCartes[i] = new Configuration(cartes[i], nbCartes[i]);
	    }
		
		
	}
	
	public String affichageJeuCartes() {
		//on construit un string
		StringBuilder jeuCartes=new StringBuilder();
		
		for (int i = 0; i < typeDeCartes.length; i++) {
			Configuration config= typeDeCartes[i];
			jeuCartes.append(config.getNbExemplaires() +" " +config.getCarte()+"\n");
		}
		//on retourne le sting
		return jeuCartes.toString();
	}
	
	public Carte[] donnerCartes() {
		//tableau vide qui contient toutes les cartes soit 106
		Carte[] tableauCartes= new Carte[106];
		int ctp =0; 
		
		//on boucle sur les 19 cartes
		for (int i = 0; i < typeDeCartes.length; i++) {
			//on recup les info de la carte actuelle
			int qtt= typeDeCartes[i].getNbExemplaires();
			Carte carte= typeDeCartes[i].getCarte();
			
			//on boucle pour produire la carte actuelle
			for (int j = 0; j < qtt; j++) {
				tableauCartes[ctp]= carte; 
				ctp++; 
				
			}
		}
		return tableauCartes;
	}
	//on fait le code checkcount pour evaluer que chaque carte a son type correctemement
	public int occurenceCarte(Carte nomCarteCherche, Carte[] pioche) {
		int compteur=0;
		for (int i = 0; i < pioche.length; i++) {
			if (pioche[i].equals(nomCarteCherche)) {
				compteur++;
			}
		}
		return compteur;
	}
	public boolean checkCount() {
		Carte[] checkpacquet= donnerCartes();
		for (int i = 0; i < typeDeCartes.length; i++) {
			Configuration config= typeDeCartes[i];
			int nbCartesTrouves= occurenceCarte(config.getCarte(), checkpacquet);
			if (nbCartesTrouves!=config.getNbExemplaires()) {
				System.out.println("Erreur nb carte");
				return false;
			}
		}
		return true;
	}
	
	//classe interne configuration
	private static class Configuration{
		private Integer nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, Integer nbExemplaires) {
			this.carte= carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		//faire les getters
		public Integer getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
		
		
	}
}
