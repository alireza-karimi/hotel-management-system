import java.util.HashMap;

/**
 * Room class which represents a room in the hotel
 * @author alireza karimi
 * @version 1.0.0
 */
public class Room {
	//number of this room
	private int number;
	private View  view;
	private Type type;
	private HashMap<Guest, Date> reservedDates = new HashMap<>();
	private float price;
	
	/**
	 * This method prints all information about the room including all its reservations
	 */
	public void printInfo(){
		System.out.println("Room number:");
		System.out.println(number);
		System.out.println("Room veiw:");
		System.out.println(view);
		System.out.println("Room type:");
		System.out.println(type);
		System.out.println("Room price for each day:");
		System.out.println(price);
		
		System.out.println("Room reserved dates and guests:");
		int counter = 1;
		for(HashMap.Entry<Guest, Date> entry : reservedDates.entrySet()){
			System.out.println(counter + "-");
			System.out.println("Guest name: " + entry.getKey().getName());
			System.out.println("Reservation information:");
			entry.getValue().printInfo();
			counter++;
		}
	}
	
	/**
	 * reserving the room for a guest in desired date
	 * @param guest guest
	 * @param date date of reservation
	 * @return returns true if the reservation is possible
	 */
	public boolean reserve(Guest guest, Date date){
		if(reservedDates.containsKey(guest)){
			System.out.println("The room is reserved for this guest in some period. Can not reserve in another period");
			return false;
		}
		if(isReserved(date)){
			System.out.println("The room is reserved for this period.");
			return false;
		}
		else{
			reservedDates.put(guest, date);
			return true;
		}
	}
	
	/**
	 * checking whether the room is reserved in a specific time or not
	 * @param date date
	 * @return returns true if this date is reserved
	 */
	public boolean isReserved(Date date){
		for(HashMap.Entry<Guest, Date> entry : reservedDates.entrySet()){
			if(entry.getValue().getStartDate().equals(date.getStartDate()) && entry.getValue().getFinishDate().equals(date.getFinishDate()) && entry.getValue().getDaysToStay() == date.getDaysToStay()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * getting view of room
	 * @return view of room
	 */
	public View getView(){
		return view;
	}
	
	/**
	 * setting the room view
	 * @param view view of room
	 * @return returns false if argument is not acceptable
	 */
	public boolean setView(String view){
		if(view.equals("SEA")){
			this.view = View.SEA;
			return true;
		}
		else if(view.equals("FOREST")){
			this.view = View.FOREST;
			return true;
		}
		else if(view.equals("BUILDING")){
			this.view = View.BUILDING;
			return true;
		}
		
		return false;
	}
	
	/**
	 * getting type of room
	 * @return type of room
	 */
	public Type getType(){
		return type;
	}
	
	/**
	 * setting the room type
	 * @param type type of room
	 * @return returns false if argument is not acceptable
	 */
	public boolean setType(String type){
		if(type.equals("SINGLE")){
			this.type = Type.SINGLE;
			return true;
		}
		else if(type.equals("DOUBLE")){
			this.type = Type.DOUBLE;
			return true;
		}
		else if(type.equals("TRIPLE")){
			this.type = Type.TRIPLE;
			return true;
		}
		else if(type.equals("QUAD")){
			this.type = Type.QUAD;
			return true;
		}
		else if(type.equals("QUEEN")){
			this.type = Type.QUEEN;
			return true;
		}
		else if(type.equals("KING")){
			this.type = Type.KING;
			return true;
		}
		
		return false;
	}
	
	/**
	 * setting room price for each day
	 * @param price price for each day
	 */
	public void setPrice(float price){
		this.price = price;
	}
	
	/**
	 * getting the number of room
	 * @return number of room
	 */
	public int getNumber(){
		return number;
	}
	
	/**
	 * setting the number of room
	 * @param number number of room
	 */
	public void setNumber(int number){
		this.number = number;
	}
	
	/**
	 * this method calculates cost of reservation for the guest and removes its reservation records from reservedDates
	 * @param guest guest for checkout
	 * @return cost of guest reservation
	 */
	public float costCalculateAndCheckOut(Guest guest){
		float cost = 0;
		for(HashMap.Entry<Guest, Date> entry : reservedDates.entrySet()){
			if(entry.getKey().getName().equals(guest.getName()) && entry.getKey().getId().equals(guest.getId())){
				cost += entry.getValue().getDaysToStay() * price;
				reservedDates.remove(entry.getKey());
			}
		}
		return cost;
	}
	
}