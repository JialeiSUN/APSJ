package classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Commande {
	
	private int id;
	private int REF_User;
	private float Total;
	
	public Commande() {}
	
	public Commande(int id, int ref, float total) {
		this.id=id;
		this.setREF_User(ref);
		this.setTotal(total);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getREF_User() {
		return REF_User;
	}

	public void setREF_User(int rEF_User) {
		REF_User = rEF_User;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}
	
	
	public Map toMap() {
		Map<String,String> map = new HashMap<String,String>();
		String id= String.valueOf(this.id);
		String ref = String.valueOf(this.REF_User);
		String total = String.valueOf(this.Total);
		map.put("id_commande", id);
		map.put("Ref_User", ref);
		map.put("Total", total);

		return map;
	}
	
	
	

}
