package hr_Management;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class RequestResultModel implements TableModel{
	
	private ArrayList<RequestResult> requestResult = new ArrayList();
	
	
	public RequestResultModel(ArrayList<RequestResult> result) {
		this.requestResult = result;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return requestResult.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {

		if (columnIndex == 0) {

			return "Holiday";

		} else if (columnIndex == 1) {

			return "Last Processed";

		} else if (columnIndex == 2){

			return "Request Result";

		} else{
			return "Error";
		}
		// TODO Auto-generated method stub
		// return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

		RequestResult result = requestResult.get(rowIndex);

		if (columnIndex == 0) {

			return result.getHoliday();

		} else if (columnIndex == 1) {

			return result.getLastProcessedby();

		} else if (columnIndex == 2) {
			return result.getRequestResult();
			
		} else {

			return "Error";

		}

	
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
