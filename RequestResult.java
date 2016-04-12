package hr_Management;

public class RequestResult {
	
	String holiday;
	String lastProcessedby;
	String requestResult;
	
	public RequestResult(String holiday, String lastProcessedby, String requestResult){
		super();
		this.holiday = holiday;
		this.lastProcessedby = lastProcessedby;
		this.requestResult = requestResult;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getLastProcessedby() {
		return lastProcessedby;
	}

	public void setLastProcessedby(String lastProcessedby) {
		this.lastProcessedby = lastProcessedby;
	}

	public String getRequestResult() {
		return requestResult;
	}

	public void setRequestResult(String requestResult) {
		this.requestResult = requestResult;
	}

}
