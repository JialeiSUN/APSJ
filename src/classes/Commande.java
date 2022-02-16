package classes;

import java.util.Date;
import java.util.ArrayList;

public class Commande {
	
	private int id;
	private int REF_PANIER;
	private Date DateLivraison;
	
	public Commande() {}
	
	public Commande(int id, Panier ref)
	
	private int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	
	private int getREF_PANIER() {
		return REF_PANIER;
	}
	private void setREF_PANIER(int rEF_PANIER) {
		REF_PANIER = rEF_PANIER;
	}
	
	private Date getDateLivraison() {
		return DateLivraison;
	}
	private void setDateLivraison(Date dateLivraison) {
		DateLivraison = dateLivraison;
	}
	
	

}
