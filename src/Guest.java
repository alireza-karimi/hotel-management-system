/**
 * Guest class which represents a guest in the hotel
 * @author alireza karimi
 * @version 1.0.0
 */
public class Guest {
	private String name;
	private String id;
	
	/**
	 * setting name of guest
	 * @param name name of guest
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * getting name of guest
	 * @return name of guest
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * setting id of guest
	 * @param id id of guest
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * getting id of guest
	 * @return id of guest
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * printing all information about this guest
	 */
	public void printInfo(){
		System.out.println("Guest name:");
		System.out.println(name);
		System.out.println("Guest id:");
		System.out.println(id);
	}
	
}
