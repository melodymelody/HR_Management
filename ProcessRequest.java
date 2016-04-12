package hr_Management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ProcessRequest extends JFrame {

	RunSystem rs = new RunSystem();

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessRequest frame = new ProcessRequest();
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
	public ProcessRequest() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 926, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnGetRequestList = new JButton("Get Request List");
		btnGetRequestList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = textField.getText();
				ArrayList<HolidayRequest> holidayReq = rs.em.getHolidayRequest(ID);
				HolidayRequestModel requestModel = new HolidayRequestModel(holidayReq);
				table.setModel(requestModel);

			}
		});

		JButton btnNewButton = new JButton("Endorse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supervisior = "";
				String requester = "";
				String holiday = "";

				if (table.getSelectedRow() != -1) {
					supervisior = textField.getText();
					requester = table.getValueAt(table.getSelectedRow(), 0).toString();
					holiday = table.getValueAt(table.getSelectedRow(), 1).toString();

					String nextSupervisior = rs.em.getSupervisior(supervisior);
					if ("".equals(nextSupervisior)) {
						RequestResult requestResult = new RequestResult(holiday, supervisior, "endorse");
						rs.em.giveFeedback(requester, requestResult);
						// HolidayRequest holidayReq = new
						// HolidayRequest(requester,holiday);
						rs.em.finishRequest(supervisior, requester);
						table.updateUI();
					} else {

						HolidayRequest holidayReq = rs.em.getHolidayRequestSingle(supervisior, requester);
						rs.em.setHandler(nextSupervisior, holidayReq);
						// rs.em.setHandler(nextSupervisior, holidayReq);
						rs.em.finishRequest(supervisior, requester);
						table.updateUI();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a row to operate", "message",
							JOptionPane.WARNING_MESSAGE);
				}
				// System.out.println(requester);

			}
		});

		JButton btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String supervisior = "";
				String requester = "";
				String holiday = "";

				if (table.getSelectedRow() != -1) {
					supervisior = textField.getText();
					requester = table.getValueAt(table.getSelectedRow(), 0).toString();
					holiday = table.getValueAt(table.getSelectedRow(), 1).toString();

					RequestResult requestResult = new RequestResult(holiday, supervisior, "decline");
					rs.em.giveFeedback(requester, requestResult);
					rs.em.finishRequest(supervisior, requester);
					table.updateUI();

					// String nextSupervisior =
					// rs.em.getSupervisior(supervisior);

					/*
					 * if ("".equals(nextSupervisior)) { RequestResult
					 * requestResult = new RequestResult(holiday, supervisior,
					 * "endorse"); rs.em.giveFeedback(requester, requestResult);
					 * // HolidayRequest holidayReq = new //
					 * HolidayRequest(requester,holiday);
					 * rs.em.finishRequest(supervisior, requester);
					 * table.updateUI(); } else {
					 * 
					 * HolidayRequest holidayReq =
					 * rs.em.getHolidayRequestSingle(supervisior, requester);
					 * rs.em.setHandler(nextSupervisior, holidayReq); //
					 * rs.em.setHandler(nextSupervisior, holidayReq);
					 * rs.em.finishRequest(supervisior, requester);
					 * table.updateUI(); }
					 */
				} else {
					JOptionPane.showMessageDialog(null, "Please select a row to operate", "message",
							JOptionPane.WARNING_MESSAGE);
				}
				// System.out.println(requester);

			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		// JScrollPane scrollPane = new JScrollPane(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDecline))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblId)
							.addGap(36)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(312)
							.addComponent(btnGetRequestList)))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGetRequestList)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnDecline))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
				table = new JTable();
				scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

	}
}
