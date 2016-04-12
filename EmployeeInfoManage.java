package hr_Management;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeInfoManage {
	public static ArrayList<Employee> ems = new ArrayList();

	public void addEmployee(String ID, String name, boolean director_ind) {

		Employee newOne = new Employee(ID, name, director_ind);
		ems.add(newOne);

	}

	public String queryEmployee() {
		String queryResult = "";
		for (int i = 0; i < ems.size(); i++) {
			queryResult = ems.get(i).display() + queryResult;
			System.out.println();
		}
		return queryResult;
	}
	
	public ArrayList<Employee> getEmployeeList(){
		return ems;
	}

	public boolean deleteEmployee(String ID) {
		boolean delete_ind = false;
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				ems.remove(ems.get(i));
				delete_ind = true;
			}
		}
		return delete_ind;
	}
	
	public boolean isEmployeeExist(String ID){
		boolean employee_ind = false;
		for (int i = 0; i < ems.size(); i++){
			if (ID.equals(ems.get(i).getID())){
				employee_ind = true;
			}
		}
		return employee_ind;
	}

	public String getSupervisior(String ID) {
		String supervisior = "";
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				supervisior = ems.get(i).getSupervisior();
			}
		}
		return supervisior;

	}

	public boolean setSupervisior(String ID, String supervisior_ID) {
		boolean setSup_ind = false;
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				ems.get(i).setSupervisior(supervisior_ID);
				setSup_ind = true;
			}
		}

		return setSup_ind;
	}

	public String getHoliday(String ID) {
		String holiday = "";
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				holiday = ems.get(i).getHoliday();
			}
		}
		return holiday;

	}

	public void setHoliday(String startD, String endD, String ID) {
		//String startD = startDate.toString();
		//String endD = endDate.toString();
		String holiday = "";
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				holiday = startD + " ~ " + endD + " ; ";
				// holiday = holiday + ems.get(i).getHoliday();
				ems.get(i).setHoliday(holiday);

			}
		}

	}

	public void setHandler(String ID, HolidayRequest holidayReq) {
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				ems.get(i).addHolidayRequest(holidayReq);
			}
		}

	}
	
	public void finishRequest(String ID, String requester){
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				ems.get(i).removeHolidayRequest(ems.get(i).getIndexOfHolidayRequest(requester));
			}
		}
		
	}
	
	public void giveFeedback(String ID, RequestResult requestResult) {
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				ems.get(i).addRequestResult(requestResult);
			}
		}

	}
	
	

	public ArrayList<HolidayRequest> getHolidayRequest(String ID) {
		ArrayList<HolidayRequest> holidayReq = new ArrayList();
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				holidayReq = ems.get(i).getHolidayReq();
			}
		}

		return holidayReq;
	}
	
	public ArrayList<RequestResult> getRequestResult(String ID) {
		ArrayList<RequestResult> requestResult = new ArrayList();
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				requestResult = ems.get(i).getRequestResult();
			}
		}

		return requestResult;
	}
	
	
	
	public HolidayRequest getHolidayRequestSingle(String ID, String requester){
		HolidayRequest holidayRequest = new HolidayRequest("","");
		for (int i = 0; i < ems.size(); i++) {
			if (ID.equals(ems.get(i).getID())) {
				holidayRequest = ems.get(i).getHolidayReqSingle(ems.get(i).getIndexOfHolidayRequest(requester));
			}
		}
		return holidayRequest;
		
		
	}
	
	

}
