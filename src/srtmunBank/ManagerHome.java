package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManagerHome extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField userIdField;
	private JTextField designationField;
	private String userId;
	private String designation="M";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHome frame = new ManagerHome();
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
	
	public ManagerHome() {
		userId=LoginPage.userIdText;
		String account=BankFunctions.getAccountNumber(userId);
		setTitle(BankFunctions.getName(account));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		
		
		setBounds(100, 100, 786, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JLabel nameLabel = new JLabel("Name :-");
		nameLabel.setFont(new Font("STXinwei", Font.BOLD, 16));
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp=new ChangePassword(userId);
				cp.setVisible(true);
			}
		});
		changePasswordButton.setForeground(new Color(0, 0, 0));
		
		JLabel userIdLabel = new JLabel("User_ID :-");
		userIdLabel.setFont(new Font("STXinwei", Font.BOLD, 16));
		
		JLabel designationLabel = new JLabel("Designation :-");
		designationLabel.setFont(new Font("STXinwei", Font.BOLD, 16));
		
		nameField = new JTextField();
		nameField.setBorder(null);
		nameField.setText("name");
		nameField.setText(BankFunctions.getName(account));
		nameField.setFont(new Font("NEW TIMES ROMAN",Font.BOLD|Font.ITALIC,15));
		nameField.setBackground(new Color(253, 245, 230));
		nameField.setEditable(false);
		nameField.setColumns(10);
		
		userIdField = new JTextField();
		userIdField.setBorder(null);
		userIdField.setFont(new Font("NEW TIMES ROMAN",Font.BOLD|Font.ITALIC,15));
		userIdField.setText("gogo");
		userIdField.setText(userId);
		userIdField.setBackground(new Color(253, 245, 230));
		userIdField.setEditable(false);
		userIdField.setColumns(10);
		
		designationField = new JTextField();
		designationField.setBorder(null);
		designationField.setText("manager");
		designation=BankFunctions.getDesignation(userId);
		if(designation.equals("M"))
			designationField.setText("Manager");
		designationField.setFont(new Font("NEW TIMES ROMAN",Font.BOLD|Font.ITALIC,15));
		designationField.setColumns(10);
		designationField.setBackground(new Color(253, 245, 230));
		designationField.setEditable(false);
		
		JButton viewAllCustomerButton = new JButton("View All Customers");
		viewAllCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAllCustomers vac=new ViewAllCustomers();
				vac.setVisible(true);
			}
		});
		viewAllCustomerButton.setForeground(new Color(0, 0, 0));
		viewAllCustomerButton.setBackground(new Color(253, 245, 230));
		viewAllCustomerButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JButton withdrawlButton = new JButton("Withdrawl");
		withdrawlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdrawl wdl=new Withdrawl();
				wdl.setVisible(true);
			}
		});
		withdrawlButton.setForeground(new Color(0,0,0));
		withdrawlButton.setBackground(new Color(253, 245, 230));
		withdrawlButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JButton manageCheckbookButton = new JButton("Manage CheckBook Request");
		manageCheckbookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckBookStatusReport cbsr=new CheckBookStatusReport();
				cbsr.setVisible(true);
			}
		});
		manageCheckbookButton.setForeground(new Color(0, 0, 0));
		manageCheckbookButton.setBackground(new Color(253, 245, 230));
		manageCheckbookButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		JButton closeAccountButton = new JButton("Close Accoount");
		closeAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAccount ca=new CloseAccount();
				ca.setVisible(true);
			}
		});
		closeAccountButton.setForeground(new Color(0,0,0));
		closeAccountButton.setBackground(new Color(253, 245, 230));
		closeAccountButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JButton depositButton = new JButton("Deposit");
		depositButton.setForeground(new Color(0,0,0));
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit dp=new Deposit();
				dp.setVisible(true);
			}
		});
		depositButton.setBackground(new Color(253, 245, 230));
		depositButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JButton emiStatusButton = new JButton("EMI Status");
		emiStatusButton.setForeground(new Color(0, 0, 0));
		emiStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmiStatus es=new EmiStatus();
				es.setVisible(true);
			}
		});
		emiStatusButton.setBackground(new Color(253, 245, 230));
		emiStatusButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JButton openNewAccountButton = new JButton("Open New Account");
		openNewAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAccountOpen nao=new NewAccountOpen();
				nao.setVisible(true);
			}
		});
		openNewAccountButton.setForeground(new Color(0, 0, 0));
		openNewAccountButton.setBackground(new Color(253, 245, 230));
		openNewAccountButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JButton logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage lo=new WelcomePage();
				dispose();
				lo.setVisible(true);
			}
		});
		logoutButton.setForeground(Color.BLACK);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(465, Short.MAX_VALUE)
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(264)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addGap(297))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
							.addGap(87))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
					.addGap(186)
					.addComponent(designationLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(designationField, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(114))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userIdLabel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addGap(46))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(userIdField, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
					.addGap(569))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(openNewAccountButton, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
					.addGap(172))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(viewAllCustomerButton, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(181)
					.addComponent(withdrawlButton, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(99))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(manageCheckbookButton, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(181)
					.addComponent(depositButton, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addGap(99))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(emiStatusButton, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addGap(477))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(closeAccountButton, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addGap(175))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(designationLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(designationField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(userIdLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addGap(3))
						.addComponent(userIdField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(openNewAccountButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(viewAllCustomerButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(withdrawlButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(manageCheckbookButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(depositButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
					.addGap(33)
					.addComponent(emiStatusButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(80)
					.addComponent(closeAccountButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
