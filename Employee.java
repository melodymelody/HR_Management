package hr_Management;

import java.util.ArrayList;

public class Employee {
	private String ID;
	private String name;
	private String supervisior = "";
	private boolean director_ind = false;
	private String holiday = "";
	private ArrayList<HolidayRequest> holidayReq = new ArrayList();
	private ArrayList<RequestResult> requestResult = new ArrayList();
	
	public ArrayList<RequestResult> getRequestResult() {
		return requestResult;
	}

	public void setRequestResult(ArrayList<RequestResult> requestResult) {
		this.requestResult = requestResult;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public Employee(String ID, String name, boolean director_ind){
		super();
		this.ID=ID;
		this.name=name;
		this.director_ind=director_ind;
	}

	public String getID() {
		return ID;
	}
	
	public void addRequestResult(RequestResult requestResult) {
		this.requestResult.clear();
		this.requestResult.add(requestResult);
	}
	
	public void removeRequestResult(int index) {
		this.requestResult.remove(index);
		
	}
	
	public void addHolidayRequest(HolidayRequest holidayReq) {
		this.holidayReq.add(holidayReq);
		
	}
	
	public void removeHolidayRequest(int index) {
		this.holidayReq.remove(index);
		
	}
	
	public int getIndexOfHolidayRequest(String requester){
		int index = -1;
		for(int i=0;i<holidayReq.size();i++){
			if(requester.equals(holidayReq.get(i).getHoliday_requester())){
				index = i;
			}
		}
		
		return index;
		
	}

	public ArrayList<HolidayRequest> getHolidayReq() {
		return holidayReq;
	}
	
	public HolidayRequest getHolidayReqSingle(int index) {
		return holidayReq.get(index);
	}

	public void setHolidayReq(ArrayList<HolidayRequest> holidayReq) {
		this.holidayReq = holidayReq;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSupervisior() {
		return supervisior;
	}

	public void setSupervisior(String supervisior) {
		this.supervisior = supervisior;
	}

	public boolean isDirector_ind() {
		return director_ind;
	}

	public void setDirector_ind(boolean director_ind) {
		this.director_ind = director_ind;
	}

	public String display(){
		String result = this.ID + this.name + this.supervisior + this.holiday + "      ";
		System.out.println(this.ID + this.name);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
