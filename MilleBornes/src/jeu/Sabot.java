package jeu;

import cartes.Carte;

//outils java pr iterable
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
	// il faut créer la pioche qui est un tableau de cartes que le joueur possçde et
	// un compteur
	private Carte[] sabot;
	private int nbCartes;
	private int nbOperations;

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nbOperationsReference = nbOperations;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes; // ça fait + 1 jusqu'à la taille totale des cartes
		}

		@Override
		public Carte next() {
			if (nbOperationsReference != nbOperations) {
				throw new ConcurrentModificationException("Le sabot a été modifié");
			}
			if (hasNext()) {
				Carte carte = sabot[indiceIterateur];
				indiceIterateur++; // on incrémente
				nextEffectue= true;
				return carte;

			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (nbOperationsReference != nbOperations) {
				throw new ConcurrentModificationException("Le sabot a été modifié");
			}
			// il n'y a plus de cartes ça veut dire
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			// on va supprimer l'element que l'on vient de passer
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				sabot[i] = sabot[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;

			nbOperations++;
			nbOperationsReference++;
		}

	}

	public Sabot(Carte[] sabot) {
		this.sabot = sabot;
		this.nbCartes = sabot.length; // on prend la taille du tab qui stock les cartes
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte newCarte) {
		// on passe en parametre une carte qu'on ajoute dans la main

		// execption
		if (nbCartes == sabot.length) {
			throw new IllegalStateException("La capacité de la main est pleine");
		} else {
			sabot[nbCartes] = newCarte;
			nbCartes++;
			nbOperations++; // proteger iterateur et créer une fausse exception
		}

		
	}
	
	public Carte piocher() {
		Iterator<Carte> iterateur= iterator(); //recup iterateur
		Carte cartePioche= iterateur.next(); //on pioche la carte à l'ité next
		iterateur.remove(); //on suppr la carte du paquet (c'est la modif)
		return cartePioche; 
	}

}
