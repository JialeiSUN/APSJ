package classes;

import java.util.HashMap;
import java.util.Map;

public class Session {

	private int Id;
	private int REF_User;
	private float total;
	
	public Session() {}
	
	public Session(int id, int REF_User, float total) {
		this.setId(id);
		this.setREF_User(REF_User);
		this.setTotal(total);

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getREF_User() {
		return REF_User;
	}

	public void setREF_User(int rEF_User) {
		REF_User = rEF_User;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	
	public Map toMap() {
		Map<String,String> map = new HashMap<String,String>();
		String id= String.valueOf(this.Id);
		String ref = String.valueOf(this.REF_User);
		String total = String.valueOf(this.total);
		map.put("Id_Session", id);
		map.put("Ref_User", ref);
		map.put("Total", total);

		return map;
	}
	

}
