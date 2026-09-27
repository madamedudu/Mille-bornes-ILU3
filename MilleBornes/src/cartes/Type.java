package cartes;

public enum Type {
	//ici c'est les constantes construies
	FEU("Feu rouge", "Feu vert","Prioritaire"),
	ESSENCE("Panne d'essence", "Essence", "Citerne"), 
	CREVAISON("Crevaison","Roue de secours", "Increvable"), 
	ACCIDENT("Accident", "Reparation","As du volant");
	
	//stock attribut en memoire
	private String nomAttaque; // feu rouge, panne essence, crevaison, accident
	private String nomParade; // feu vert, essence, roue de secours, reparation
	private String nomBotte; // prioritaire, citerne, increvable, as du volant
	
	//faire le constructeur de Type (chaque type a 3 attributs)
	private Type(String attaque, String parade,String botte) {
		this.nomAttaque= attaque;
		this.nomParade= parade;
		this.nomBotte= botte;
	}
	public String getNomAttaque() {
		return nomAttaque;
	}
	public String getNomParade() {
		return nomParade;
	}
	public String getNomBotte() {
		return nomBotte;
	}
	
	
	

}
