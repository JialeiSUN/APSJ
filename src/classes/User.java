package classes;

import java.util.HashMap;
import java.util.Map;

public class User {

	private int UserId;
	private String MotDePasse;
	private String Prenom;
	private String Nom;
	private Role role;
	private String email;
	private String adresse;
	private int telephone;
	
	public User (int id,String nom,String prenom, String email ,int telephone, String adresse,String mdp, Role role) {
		this.UserId = id;
		this.MotDePasse = mdp;
		this.Prenom = prenom;
		this.Nom = nom;
		this.role = role;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public User() {
		
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
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
	private Role getRole() {
		return role;
	}
	private void setRole(Role role) {
		this.role = role;
	}
	private String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private int getTelephone() {
		return this.telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	private String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Map tomap() {
		Map<String,String> map = new HashMap<String,String>();
		String userid = String.valueOf(this.UserId);
		String usertelephone = String.valueOf(this.telephone);
		map.put("id", userid);
		map.put("nom", this.Nom);
		map.put("prenom", this.Prenom);
		map.put("email", this.email);
		map.put("telephone",usertelephone);
		map.put("adresse", this.adresse);
		map.put("passwd", this.MotDePasse);
		map.put("role", this.role.toString());
		return map;
	}

	
	
	
}
