package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return km+"KM";
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj instanceof Borne bornes) {
			return this.km == bornes.km;	
		}
		return false;
	}
}


