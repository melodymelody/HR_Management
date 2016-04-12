package hr_Management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApplyForLeave extends JFrame {
	
	RunSystem rs = new RunSystem();

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyForLeave frame = new ApplyForLeave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String dateToString(Date time){ 
	    SimpleDateFormat formatter; 
	    formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
	    String ctime = formatter.format(time); 

	    return ctime; 
	} 

	/**
	 * Create the frame.
	 */
	public ApplyForLeave() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 578, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		DateChooser startDate = new DateChooser("yyyy-MM-dd");
		DateChooser endDate = new DateChooser("yyyy-MM-dd");
		
		JButton btnGetDate = new JButton("Apply");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date start = startDate.getDate();
				Date end = endDate.getDate();
				String startD = dateToString(start);
				String endD = dateToString(end);
				
				String ID = textField.getText();
				if ("".equals(ID)){
					JOptionPane.showMessageDialog(null, "Please input the employee ID", "message",JOptionPane.WARNING_MESSAGE);
				} else if(start.after(end)){
					JOptionPane.showMessageDialog(null, "End date should be later than Start date", "message",JOptionPane.WARNING_MESSAGE);
				} else {
					String superVisior = rs.em.getSupervisior(ID);
					if("".equals(superVisior)){
						JOptionPane.showMessageDialog(null, "You should ask administrator to assign a supervisior for you first", "message",JOptionPane.WARNING_MESSAGE);
						//dispose();
					} else{
						rs.em.setHoliday(startD, endD, ID);
						//sethandler
						HolidayRequest holidayReq = new HolidayRequest(ID,rs.em.getHoliday(ID));
						rs.em.setHandler(superVisior, holidayReq);
						RequestResult requestResult = new RequestResult(holidayReq.getHoliday(), "", "processing");
						rs.em.giveFeedback(ID, requestResult);
						dispose();
					}
					
					
				}
				
				
				
				//JOptionPane.showMessageDialog(null, mp.getDate(), "提示消息",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		JLabel lblId = new JLabel("ID");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date");
		
		JLabel lblEndDate = new JLabel("End Date");
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnGetDate)
							.addGap(89)
							.addComponent(btnCancle)
							.addGap(680))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStartDate)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
									.addGap(49)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(endDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(startDate, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
							.addContainerGap(654, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(startDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGetDate)
						.addComponent(btnCancle))
					.addGap(354))
		);
		contentPane.setLayout(gl_contentPane);
		
		//final DateChooser mp = new DateChooser("yyyy-MM-dd");
	}
}
