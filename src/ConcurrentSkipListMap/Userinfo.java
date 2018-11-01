package ConcurrentSkipListMap;

public class Userinfo implements Comparable<Userinfo> {
	private int id;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username;
	
	public Userinfo(){super();}
	
	public Userinfo(int id, String username){
		super();
		this.id = id;
		this.username = username;
	}
	
	public int getId(){
		return id;
		
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	@Override
	public int compareTo(Userinfo u){
		if(this.getId() < u.getId()){
			return -1;
		}
		if (this.getId() > u.getId())
		{
			return 1;
		}
		return 0;
		
	}
	
	
	
}
