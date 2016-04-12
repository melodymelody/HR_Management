package hr_Management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RunSystem extends JFrame {

	public static EmployeeInfoManage em = new EmployeeInfoManage();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunSystem frame = new RunSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RunSystem() {
		// JCalendarChooser calendar = new JCalendarChooser(frame);
		// Date date = new Date();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1442, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// DatePicker datepick = new DatePicker(contentPane);
		// datepick.set

		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewEmployee frame = new NewEmployee();
				frame.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("Human Resource System");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 32));

		JButton btnDisplay = new JButton("Display Employee");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Employee> employeeList = new ArrayList();
				employeeList = em.getEmployeeList();
				EmployeeModel employeeModel = new EmployeeModel(employeeList);

				// Vector rowData = new Vector();
				// for (int i = 0; i < employeeList.size(); i++) {
				// Vector colData = new
				// Vector(Arrays.asList(employeeList.get(i)));
				// rowData.add(colData);
				// }
				//
				// String[] columnNames = { "ID", "Name", "Supervisior",
				// "Director" };
				// Vector columnNamesV = new Vector(Arrays.asList(columnNames));

				JTable table = new JTable();
				table.setModel(employeeModel);
				JFrame f = new JFrame();
				f.setSize(1000, 500);
				f.getContentPane().add(new JScrollPane(table));
				f.setVisible(true);

				// String queryResult = em.queryEmployee();
				// JOptionPane.showMessageDialog(null, em.queryEmployee(),
				// "message",JOptionPane.WARNING_MESSAGE);

			}
		});

		JButton btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteEmployee frame = new DeleteEmployee();
				frame.setVisible(true);
			}
		});

		JButton btnAssignSupervisior = new JButton("Assign Supervisor");
		btnAssignSupervisior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagementEmployee frame = new ManagementEmployee();
				frame.setVisible(true);

			}
		});

		JButton btnTestdate = new JButton("Apply For Leave");
		btnTestdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyForLeave frame = new ApplyForLeave();
				frame.setVisible(true);
			}
		});

		JButton btnProcessRequest = new JButton("Process Request");
		btnProcessRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProcessRequest frame = new ProcessRequest();
				frame.setVisible(true);

			}
		});

		JButton btnCheckHolidayStatus = new JButton("Check Holiday Status");
		btnCheckHolidayStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckProcessStatus frame = new CheckProcessStatus();
				frame.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(463)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(78)
									.addComponent(btnNewButton)
									.addGap(125)
									.addComponent(btnDeleteEmployee)
									.addGap(81)
									.addComponent(btnAssignSupervisior, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
									.addGap(33)))
							.addGap(51)
							.addComponent(btnDisplay, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(230)
							.addComponent(btnTestdate)
							.addGap(93)
							.addComponent(btnProcessRequest, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGap(131)
							.addComponent(btnCheckHolidayStatus)))
					.addContainerGap(469, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDisplay, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAssignSupervisior, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteEmployee, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnProcessRequest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCheckHolidayStatus, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addComponent(btnTestdate, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
					.addGap(166))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
