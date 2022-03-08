package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Panier {
	
	private int id;
	private int REF_Session;
	private int REF_Article;
	private int Quantite;
	
	
	public Panier(int id, int ref_s, int ref_a, int qte) {
		this.setId(id);
		this.setREF_Session(ref_s);
		this.setREF_Article(ref_a);
		this.setQuantite(qte);
	}


	public Panier() {	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getREF_Session() {
		return REF_Session;
	}


	public void setREF_Session(int rEF_Session) {
		REF_Session = rEF_Session;
	}


	public int getREF_Article() {
		return REF_Article;
	}


	public void setREF_Article(int rEF_Article) {
		REF_Article = rEF_Article;
	}


	public int getQuantite() {
		return Quantite;
	}


	private void setQuantite(int quantite) {
		Quantite = quantite;
	}
	
	public Map toMap() {
		Map<String,String> map = new HashMap<String,String>();
		String id= String.valueOf(this.id);
		String REF_Session = String.valueOf(this.REF_Session);
		String REF_Article = String.valueOf(this.REF_Article);
		String Quantite = String.valueOf(this.Quantite);

		map.put("id_panier", id);
		map.put("REF_Session", REF_Session);
		map.put("REF_Article", REF_Article);
		map.put("Quantite", Quantite);

		return map;
	}
	
}
