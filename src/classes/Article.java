package classes;

public class Article {

	private int ArticleId;
	private String Libelle;
	private String Marque;
	private double Prix;
	private Categorie categorie;
	
	public Article(int id, String libelle, String marque, double prix, Categorie categorie) {
		this.ArticleId=id;
		this.Libelle=libelle;
		this.Marque=marque;
		this.Prix=prix;
		this.categorie=categorie;
	}
	
	public Article() {}

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
		return Prix;
	}
	public void setPrix(double prix) {
		this.Prix = prix;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public String toString() {
		String str= this.ArticleId +" "+ this.Libelle +" "+  this.Marque  +" "+  this.Prix  +" "+  this.categorie + "\n";
	
		return str;
	}
	
	
	
}
