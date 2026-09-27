package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type); // on renvoie le parent
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return getType().getNomParade();
	}

}
