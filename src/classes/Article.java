package classes;

public class Article {

	private int ArticleId;
	private String Libelle;
	private String Marque;
	private double prix;
	private Categorie categorie;
	
	public int getArticleId() {
		return ArticleId;
	}
	public void setArticleId(int articleId) {
		ArticleId = articleId;
	}
	
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	
	public String getMarque() {
		return Marque;
	}
	private void setMarque(String marque) {
		Marque = marque;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	
	
	
}
