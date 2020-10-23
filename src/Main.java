import java.util.Scanner;

/**
 * Main class performs a command interface for the system user
 * @author alireza karimi
 * @version 1.0.0
 */
public class Main {
	
	private static Hotel hotelManagementSystem = new Hotel();
	
	/**
	 * to add a guest - this is not about reservation!
	 */
	public static void checkIn(){
		Guest guest = new Guest();
		Scanner scanner = new Scanner(System.in);
		
		//setting guest name
		System.out.println("Enter guest name:");
		String input = scanner.nextLine();
		guest.setName(input);
		
		
		//setting guest id
		System.out.println("Enter guest id:");
		input = scanner.nextLine();
		guest.setId(input);
		
		hotelManagementSystem.checkIn(guest);
		System.out.println("Guest successfully added!");
	}
	
	/**
	 * to remove a guest and print its reservation cost
	 */
	public static void checkOut(){
		Guest guest = new Guest();
		Scanner scanner = new Scanner(System.in);
		
		//setting guest id
		System.out.println("Enter guest id:");
		String input = scanner.nextLine();
		guest.setId(input);
		
		//setting guest name
		System.out.println("Enter guest name:");
		input = scanner.nextLine();
		guest.setName(input);
		
		float cost = hotelManagementSystem.checkOut(guest);
		if(cost > 0){
			System.out.println("Cost for this guest is: " + cost);
			System.out.println("Check out completed!");
		}
		else{
			System.out.println("Cost for this guest is zero");
			System.out.println("Check out completed!");
		}
		
	}
	
	/**
	 * to add a new room
	 */
	public static void addRoom(){
		Room room = new Room();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		//setting room number
		System.out.println("What is room number?");
		int number = scanner.nextInt();
		room.setNumber(number);
		
		//setting room view
		boolean flag = false;
		while(!flag){
			System.out.println("What is room view? (SEA / FOREST / BUILDING)");
			scanner.nextLine();
			String view = scanner.nextLine();
			flag = room.setView(view);
		}
		
		//setting room type
		flag = false;
		while(!flag){
			System.out.println("What is room type? (SINGLE / DOUBLE / TRIPLE / QUAD / QUEEN / KING)");
			input = scanner.nextLine();
			flag = room.setType(input);
		}
		
		//setting room price
		System.out.println("What is room price for one day?");
		float price = scanner.nextFloat();
		room.setPrice(price);
		
		hotelManagementSystem.addRoom(room);
		System.out.println("Room successfully added!");
	}
	
	/**
	 * to show all available rooms and their reservation information
	 */
	public static void showRooms(){
		hotelManagementSystem.roomList();
	}
	
	/**
	 * to show all guests
	 */
	public static void showGuests(){
		hotelManagementSystem.guestList();
	}
	
	/**
	 * to reserve a specific room for a particular guest - check in is necessary beforehand!
	 */
	public static void reserveRoom(){
		int roomNumber = 0;
		String guestId;
		Date date = new Date();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter room number:");
		roomNumber = scanner.nextInt();
		
		System.out.println("Enter guest id:");
		scanner.nextLine();
		guestId = scanner.nextLine();
		
		System.out.println("Enter start date:");
		String start = scanner.nextLine();
		date.setStartDay(start);
		
		System.out.println("Enter finish date:");
		String finish = scanner.nextLine();
		date.setFinishDay(finish);
		
		System.out.println("Enter number of days to stay:");
		int daysToStay = scanner.nextInt();
		date.setDaysToStay(daysToStay);
		
		boolean flag = hotelManagementSystem.reserve(roomNumber, guestId, date);
		if(flag){
			System.out.println("Room successfully reserved!");
		}
		else{
			System.out.println("Reservation failed!");
		}
		
	}
	
	public static void main(String[] args){
		//printing the help
		System.out.println("COMMAND HELP:");
		System.out.println("check in");
		System.out.println("check out");
		System.out.println("add room");
		System.out.println("show rooms");
		System.out.println("show guests");
		System.out.println("reserve room");
		System.out.println("exit");
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		while(!input.equals("exit")){
			
			if(input.contains("check in")){
				checkIn();
			}
			else if(input.contains("check out")){
				checkOut();
			}
			else if(input.contains("add room")){
				addRoom();
			}
			else if(input.contains("show rooms")){
				showRooms();
			}
			else if(input.contains("show guests")){
				showGuests();
			}
			else if(input.contains("reserve room")){
				reserveRoom();
			}
			
			System.out.println("Please type a command to continue:");		
			input = scanner.nextLine();
			
		}
							
	}
}
