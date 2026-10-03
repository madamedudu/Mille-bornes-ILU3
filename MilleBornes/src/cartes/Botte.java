package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return getType().getNomBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Botte bottes) {
			return this.getType().getNomBotte().equals(bottes.getType().getNomBotte());
		}
		return false;
	}

}
