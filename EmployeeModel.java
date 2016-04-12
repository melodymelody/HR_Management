package hr_Management;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class EmployeeModel implements TableModel {
	
	private ArrayList<Employee> employee = new ArrayList();
	
	public EmployeeModel(ArrayList<Employee> emp) {
		this.employee = emp;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return employee.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		if (columnIndex == 0) {

			return "Employee ID";

		} else if (columnIndex == 1) {

			return "Employee Name";

		} else if (columnIndex == 2){

			return "Supervisor ID";

		} else if (columnIndex == 3){
			
			return "Director";
			
		} else {
			return "Error";
		}
		
		// TODO Auto-generated method stub
		
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
		Employee employ = employee.get(rowIndex);
		if (columnIndex == 0) {

			return employ.getID();

		} else if (columnIndex == 1) {

			return employ.getName();

		} else if (columnIndex == 2) {
			
			return employ.getSupervisior();
			
		} else if (columnIndex == 3) {

			return employ.isDirector_ind();

		} else {
			return "Error";
		}
		// TODO Auto-generated method stub
		
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
