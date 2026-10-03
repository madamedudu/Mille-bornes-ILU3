package utils;
import cartes.Carte;
import jdk.jfr.Frequency;

import java.util.*;

public class GestionCartes {
	
	//premier extraire qu'on fait
	public static <T> T extraire(List<T> liste) {
		Random random= new Random();
		int indiceAleatoire= random.nextInt(liste.size()); // on prend une valeur entiere qui fait max la taille de la liste
		return liste.remove(indiceAleatoire); // on sort l'element de la liste et c est ce qu'on retourne
	}
	//on travaille avec liste iterator maintenant 
	
	public static <T> T extraireIT(List<T> liste) {
		Random random= new Random();
		int indiceAleatoire= random.nextInt(liste.size());
		//on cree l'iterateur qui sera placé avant l'element qu on supp
		ListIterator<T> iterateur= liste.listIterator(indiceAleatoire);
		//on va ensuite lire l'élément qu'on souhaite tiré (l'itérateur qui etait à gauche de l'elem passe à droite)
		T elementAsuppr= iterateur.next();
		iterateur.remove();
		return elementAsuppr;
	}
	
	public static <T> List<T> melanger(List<T> liste){
		//on crée un paquet un paquet vide qu'on rempli de l'autre paquet
		List<T> listeMelange= new ArrayList<>(); 
		while(!liste.isEmpty()) {
			T carteExtrait= extraire(liste) ;
			listeMelange.add(carteExtrait);
		}
		return listeMelange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste, List<T> listeMelange) {
		//on compare la taille des 2 listes
		if (liste.size() != listeMelange.size()) {
			return false;
		}
		for (int i = 0; i < liste.size(); i++) {
			T element= liste.get(i);
			if (Collections.frequency(liste, element)!= Collections.frequency(listeMelange, element)){
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassemblement(List<T> liste){
		List<T> listeRassemble= new ArrayList<>();
		//on parcours la liste, on regarde si l'element est déjà present dans la liste
		for (int i = 0; i < liste.size(); i++) {
			T element= liste.get(i);
			if (!listeRassemble.contains(element)) {
				//s'il n'y a pas l'element on l'ajoute dans la liste rassembler
				//on copie dans la listeRassemble les elements present dans liste, on modifie pas liste en lui enlevant ses elements
				int frequenceElem= Collections.frequency(liste, element);
				for (int j = 0; j < frequenceElem; j++) {
					listeRassemble.add(element);
				}
			
				
			}
		}
		return listeRassemble;
	}
	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste.isEmpty() || liste.size() == 1) {
			return true;
		}
		ListIterator<T> iterateur1= liste.listIterator();
		T element= iterateur1.next();//on est sur la premiere valeur
		
		while (iterateur1.hasNext()) {
			T elementCourant= iterateur1.next();
			if (!elementCourant.equals(element)) { //on utilise l'egalité de cette forme comme en cours
				//on est plus sur du consécutif
				ListIterator<T> iterateur2= liste.listIterator(iterateur1.nextIndex());
				while(iterateur2.hasNext()) {
					T elementPlusLoin = iterateur2.next();
					if (elementPlusLoin.equals(element)) {
						return false; //ça veut dire que la valeur d'itérateur 1 se retrouve bcp plus loin ds la liste
					}
					
				}
			}
			element = elementCourant;			
			
		}
		return true;
	}
	
	
}
