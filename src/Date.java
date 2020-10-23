/**
 * Date class which represents a reservation period
 * @author alireza karimi
 * @version 1.0.0
 */
public class Date {
	private int daysToStay;
	private String start;
	private String finish;
	
	/**
	 * setting start of reservation period
	 * @param start start of reservation period
	 */
	public void setStartDay(String start){
		this.start = start;
	}
	
	/**
	 * getting start of reservation period
	 * @return start of reservation period
	 */
	public String getStartDate(){
		return start;
	}
	
	/**
	 * setting end of reservation period
	 * @param finish end of reservation period
	 */
	public void setFinishDay(String finish){
		this.finish = finish;
	}
	
	/**
	 * getting end of reservation period
	 * @return end of reservation period
	 */
	public String getFinishDate(){
		return finish;
	}
	
	/**
	 * setting number of days of reservation period
	 * @param daysToStay number of days of reservation period
	 */
	public void setDaysToStay(int daysToStay){
		this.daysToStay = daysToStay;
	}
	
	/**
	 * getting number of days of reservation period
	 * @return number of days of reservation period
	 */
	public int getDaysToStay(){
		return daysToStay;
	}
	
	/**
	 * printing all information about reservation period
	 */
	public void printInfo(){
		System.out.println("Start date:");
		System.out.println(start);
		System.out.println("Finish date:");
		System.out.println(finish);
		System.out.println("Days to stay:");
		System.out.println(daysToStay);
	}
}
