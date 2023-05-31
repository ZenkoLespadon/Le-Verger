package leverger.modele;

public class Tour {
	public Integer compteur;
	
	public Tour() {
		this.compteur = 1;
	}
	
	public void incrementer() {
		this.compteur = compteur + 1;
	}

	public String getCompteurstr() {
		return this.compteur.toString();
	}
	
	public Integer getCompteurint(){
		return this.compteur;
	}
};
