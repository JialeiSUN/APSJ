package classes;

public class Persone {
	private String Prenom;
	private String Nom;
	public Persone() {
		
	}
	public Persone(String nom,String prenom) {
		this.Nom = nom;
		this.Prenom = prenom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
}
