package jeu;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;
import java.util.*;

public class Jeu {
	private Sabot sabot;

	//creation du constructeur
	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		Carte[] tableauCartes = jeuDeCartes.donnerCartes();
		
		//part a
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, tableauCartes); //on a transf notre tab en liste de carte pr utiliser la methode melanger
		listeCartes = GestionCartes.melanger(listeCartes);
		
		//part b 
		Carte[] tableauMelange = listeCartes.toArray(new Carte[0]);
		this.sabot = new Sabot(tableauMelange);
	}
	
}
