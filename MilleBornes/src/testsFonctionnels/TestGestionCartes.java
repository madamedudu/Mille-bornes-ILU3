package testsFonctionnels;

import java.util.*;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
	
	public static <T> void testerRassemblement(List<T> liste) {
		System.out.print("Test sur la liste " + liste + " : ");
		boolean estValide = GestionCartes.verifierRassemblement(liste);
		System.out.println(estValide);
	}

	
	public static void main() {
		//test perso
		testerRassemblement(new ArrayList<>()); // Liste vide []  true attendu
		testerRassemblement(Arrays.asList(1, 1, 2, 1, 3)); // Le 1 revient après le 2  false attendu
		testerRassemblement(Arrays.asList(1, 4, 3, 2)); //  true attendu
		testerRassemblement(Arrays.asList(1, 1, 2, 3, 1)); //le 1 revient, false attendu
		
		//les tests de la prof
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
		listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassemblement(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
		+ GestionCartes.verifierRassemblement(listeCartes));

	}
}
