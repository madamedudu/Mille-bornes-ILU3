package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	//methode tostring
	@Override
	public String toString() {
		return getType().getNomAttaque();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Attaque attaques) {
			return this.getType().getNomAttaque().equals(attaques.getType().getNomAttaque());
		}
		return false;
	}
	

}
