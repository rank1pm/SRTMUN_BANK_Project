package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerHome extends JFrame {

	private JPanel contentPane;
	private JTextField customerNameField;
	private JTextField accountNumberField;
	private JTextField accountStatusField;
	private JTextField userIdField;
	private JTextField currentBalanceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerHome frame = new CustomerHome();
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
	public CustomerHome() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
		String userId=LoginPage.userIdText;
		String account=BankFunctions.getAccountNumber(userId);
		setBounds(100, 100, 889, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JLabel customerNameLabel = new JLabel("Customer Name:-");
		customerNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		
		JLabel accountNumberLabel = new JLabel("Account Number:-");
		accountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel accountStatuslabel = new JLabel("Account Status:-");
		accountStatuslabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel userIdLabel = new JLabel("User Id:-");
		userIdLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel currentBalanceLabel = new JLabel("Ava. Balance:-");
		currentBalanceLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp=new ChangePassword(userId);
				cp.setVisible(true);
			}
		});
		changePasswordButton.setForeground(new Color(0, 0, 0));
		changePasswordButton.setBackground(new Color(253, 245, 230));
		changePasswordButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JButton sendMoneyButton = new JButton("Send Money");
		sendMoneyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMoney sm=new SendMoney("SelfBanking");
				sm.setVisible(true);
			}
		});
		sendMoneyButton.setForeground(new Color(0, 0, 0));
		sendMoneyButton.setBackground(new Color(253, 245, 230));
		sendMoneyButton.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JButton last10TransactionButton = new JButton("Last 10 Transactions");
		last10TransactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Last10Transactions l10t=new Last10Transactions(account);
				l10t.setVisible(true);
			}
		});
		last10TransactionButton.setForeground(new Color(0, 0, 0));
		last10TransactionButton.setBackground(new Color(253, 245, 230));
		last10TransactionButton.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JButton updateEmailButton = new JButton("Update Email");
		updateEmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmail updateEmail=new UpdateEmail();
				updateEmail.setVisible(true);
			}
		});
		updateEmailButton.setForeground(new Color(0, 0, 0));
		updateEmailButton.setBackground(new Color(253, 245, 230));
		updateEmailButton.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JButton updatePhoneButton = new JButton("Update Phone");
		updatePhoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePhone updatePhone=new UpdatePhone();
				updatePhone.setVisible(true);
			}
		});
		updatePhoneButton.setForeground(new Color(0, 0, 0));
		updatePhoneButton.setBackground(new Color(253, 245, 230));
		updatePhoneButton.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		
		JButton checkBookRequestButton = new JButton("Check Book Request");
		checkBookRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckbookRequest checkbookRequest=new CheckbookRequest();
				checkbookRequest.setVisible(true);
			}
		});
		checkBookRequestButton.setForeground(new Color(0, 0, 0));
		checkBookRequestButton.setBackground(new Color(253, 245, 230));
		checkBookRequestButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JButton emiStatusbutton = new JButton("EMI Status");
		emiStatusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmiStatus emiStatus=new EmiStatus();
				emiStatus.setVisible(true);
			}
		});
		emiStatusbutton.setBackground(new Color(253, 245, 230));
		emiStatusbutton.setForeground(new Color(0, 0, 0));
		emiStatusbutton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		customerNameField = new JTextField();
		customerNameField.setBorder(null);
		customerNameField.setText(BankFunctions.getName(account));
		customerNameField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		customerNameField.setBackground(new Color(253, 245, 230));
		customerNameField.setEditable(false);
		customerNameField.setColumns(10);
		
		accountNumberField = new JTextField();
		accountNumberField.setBorder(null);
		accountNumberField.setText(BankFunctions.getAccountNumber(userId));
		accountNumberField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		accountNumberField.setBackground(new Color(253, 245, 230));
		accountNumberField.setEditable(false);
		accountNumberField.setColumns(10);
		
		accountStatusField = new JTextField();
		accountStatusField.setBorder(null);
		accountStatusField.setText(BankFunctions.getAccountStatus(userId));
		accountStatusField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		accountStatusField.setBackground(new Color(253, 245, 230));
		accountStatusField.setEditable(false);
		accountStatusField.setColumns(10);
		
		userIdField = new JTextField();
		userIdField.setBorder(null);
		userIdField.setText(userId);
		userIdField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		userIdField.setBackground(new Color(253, 245, 230));
		userIdField.setEditable(false);
		userIdField.setColumns(10);
		
		currentBalanceField = new JTextField();
		currentBalanceField.setText(BankFunctions.getAvailableBalance(account));
		currentBalanceField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		currentBalanceField.setBackground(new Color(253, 245, 230));
		currentBalanceField.setEditable(false);
		currentBalanceField.setColumns(10);
		currentBalanceField.setBorder(null);
		
		JButton logoutButton = new JButton("Loging Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage wp=new WelcomePage();
				wp.setVisible(true);
			}
		});
		logoutButton.setForeground(Color.BLACK);
		logoutButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		logoutButton.setBackground(new Color(253, 245, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(316)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(customerNameLabel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(userIdLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(userIdField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addComponent(accountNumberField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addComponent(accountNumberLabel, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
					.addComponent(currentBalanceLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(currentBalanceField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(accountStatuslabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(accountStatusField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(474, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(sendMoneyButton, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(312)
					.addComponent(last10TransactionButton, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(97))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(updateEmailButton, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(312)
					.addComponent(updatePhoneButton, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(97))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(checkBookRequestButton, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addGap(320)
					.addComponent(emiStatusbutton, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addGap(97))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(customerNameField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
								.addComponent(customerNameLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(userIdLabel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userIdField, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addGap(7)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(accountNumberLabel, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(currentBalanceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(currentBalanceField, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(accountStatuslabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(accountStatusField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(96)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sendMoneyButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(last10TransactionButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(updateEmailButton, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(updatePhoneButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBookRequestButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(emiStatusbutton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addGap(1)))
					.addGap(178))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
