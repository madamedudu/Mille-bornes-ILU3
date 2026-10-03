package cartes;

public class FinLimite extends Limite {
	@Override
	public String toString() {
		return "Fin limite";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FinLimite finlim) {
			return true;
		}
		return false;
	}
}
