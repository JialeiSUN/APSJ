package classes;

import java.util.HashMap;
import java.util.Map;

public class Article {

	private int ArticleId;
	private String Libelle;
	private String Marque;
	private double Prix;
	private Categorie categorie;
	
	public Article(Integer id, String libelle, String marque, double prix, Categorie categorie) {
		this.ArticleId=id;
		this.Libelle=libelle;
		this.Marque=marque;
		this.Prix=prix;
		this.categorie=categorie;
	}
	
	public Article() {}

	public Integer getArticleId() {
		return ArticleId;
	}
	public void setArticleId(Integer articleId) {
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
	
	public Map toMap() {
		Map<String,String> map = new HashMap<String,String>();
		String id= String.valueOf(this.ArticleId);
		String prix = String.valueOf(this.Prix);
		String categorie = String.valueOf(this.categorie);
		map.put("id_a", id);
		map.put("libelle", this.getLibelle());
		map.put("marque", this.getMarque());
		map.put("prix", prix);
		map.put("categorie", categorie);

		return map;
	}
	
	
	
}
