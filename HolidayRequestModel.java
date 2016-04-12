package hr_Management;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class HolidayRequestModel implements TableModel {

	private ArrayList<HolidayRequest> holidayReq = new ArrayList();

	public HolidayRequestModel(ArrayList<HolidayRequest> holidayReq) {
		this.holidayReq = holidayReq;
	}

	public int getRowCount() {

		return holidayReq.size();

	}

	public int getColumnCount() {

		return 2;

	}

	public Class<?> getColumnClass(int columnIndex) {

		return String.class;

	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		HolidayRequest request = holidayReq.get(rowIndex);

		if (columnIndex == 0) {

			return "" + request.getHoliday_requester();

		} else if (columnIndex == 1) {

			return request.getHoliday();

		} else {

			return "Error!";

		}

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {

			return "Requester";

		} else if (columnIndex == 1) {

			return "Holiday";

		} else {

			return "Error!";

		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		

		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}
