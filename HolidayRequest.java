package hr_Management;

public class HolidayRequest {
	
	String holiday_requester;
	String holiday;
	
	public HolidayRequest(String holiday_requester, String holiday){
		super();
		this.holiday_requester = holiday_requester;
		this.holiday = holiday;
		
	}

	public String getHoliday_requester() {
		return holiday_requester;
	}

	public void setHoliday_requester(String holiday_requester) {
		this.holiday_requester = holiday_requester;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

}
