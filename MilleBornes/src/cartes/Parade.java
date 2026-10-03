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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Parade parades) {
			return this.getType().getNomParade().equals(parades.getType().getNomParade());
		}
		return false;
	}

}
