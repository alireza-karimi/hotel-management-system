import java.util.ArrayList;

/**
 * Hotel class which represents an entire hotel
 * @author alireza karimi
 * @version 1.0.0
 */
public class Hotel {
	
	private ArrayList<Room> rooms = new ArrayList<>();
	private ArrayList<Guest> guests = new ArrayList<>();
	
	/**
	 * printing a list of all rooms and their information
	 */
	public void roomList(){
		int flag = 0;
		
		for(Room room : rooms){
			room.printInfo();
			flag++;
		}
		
		if(flag == 0){
			System.out.println("There is no room!");
		}
	}
	
	/**
	 * printing a list of all guests and their information
	 */
	public void guestList(){
		int flag = 0;
		
		for(Guest guest : guests){
			guest.printInfo();
			flag++;
		}
		
		if(flag == 0){
			System.out.println("There is no guest!");
		}
	}
	
	/**
	 * getting a list of all rooms in this hotel
	 * @return a list of all rooms in this hotel
	 */
	public ArrayList<Room> getRoomList(){
		return rooms;
	}
	
	/**
	 * getting a list of all guests in this hotel
	 * @return a list of all guests in this hotel
	 */
	public ArrayList<Guest> getGuestList(){
		return guests;
	}
	
	/**
	 * adding a room to hotel
	 * @param room room
	 */
	public void addRoom(Room room){
		rooms.add(room);
	}
	
	/**
	 * reserving a specific room for a particular guest in desired date
	 * @param roomNumber room number
	 * @param guestId guest id
	 * @param date date of reservation
	 * @return returns true if reservation is possible and has completed
	 */
	public boolean reserve(int roomNumber, String guestId, Date date){
		int flag = 0;
		int roomIndex = 0;
		int guestIndex = 0;
		
		for(int i = 0; i < rooms.size(); i++){
			if(rooms.get(i).getNumber() == roomNumber){
				flag++;
				roomIndex = i;
			}
		}
		
		if(flag == 0){
			System.out.println("There is no such room. Add room first.");
			return false;
		}
		
		flag = 0;
		for(int i = 0; i < guests.size(); i++){
			if(guests.get(i).getId().equals(guestId)){
				flag++;
				guestIndex = i;
			}
		}
		
		if(flag == 0){
			System.out.println("There is no such guest. Check In first.");
			return false;
		}
		
		if(rooms.get(roomIndex).reserve(guests.get(guestIndex), date)){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * adding a guest to hotel
	 * @param guest guest
	 */
	public void checkIn(Guest guest){
		guests.add(guest);
	}
	
	/**
	 * removing a guest from hotel guests and calculate its reservation cost
	 * @param guest guest
	 * @return cost of reservation
	 */
	public float checkOut(Guest guest){
		float cost = 0;
		for(int i = 0; i < guests.size(); i++){
			if(guests.get(i).getName().equals(guest.getName()) && guests.get(i).getId().equals(guest.getId())){
				for(Room room : rooms){
					cost += room.costCalculateAndCheckOut(guest);
				}
				guests.remove(i);
				return cost;
			}
		}
		return -1;
	}
}
