package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginCredintials extends JFrame {

	private JPanel contentPane;
	private JTextField accountField;
	private JTextField userIdField;
	private JTextField nameField;
	private static String cName,cAccount,cUserId,designation;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCredintials frame = new LoginCredintials(cAccount,cUserId,cName);
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
	public LoginCredintials(String cAccount, String cUserId, String cName) {
		
		this.cName=cName;
		this.cAccount=cAccount;
		this.cUserId=cUserId;
		
		
		setBounds(100, 100, 668, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel accountLabel = new JLabel("Account Number:-");
		accountLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		accountLabel.setBounds(29, 149, 180, 43);
		contentPane.add(accountLabel);
		
		JLabel userIdLabel = new JLabel("User ID:-");
		userIdLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		userIdLabel.setBounds(29, 238, 180, 43);
		contentPane.add(userIdLabel);
		
		JLabel nameLabel = new JLabel("Customer Name:-");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		nameLabel.setBounds(29, 335, 180, 43);
		contentPane.add(nameLabel);
		
		JLabel bankLabel = new JLabel("SRTMUN BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		bankLabel.setBounds(214, 44, 218, 48);
		contentPane.add(bankLabel);
		
		accountField = new JTextField();
		accountField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		accountField.setBounds(275, 149, 254, 43);
		contentPane.add(accountField);
		accountField.setColumns(10);
		accountField.setText(cAccount);
		
		userIdField = new JTextField();
		userIdField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		userIdField.setColumns(10);
		userIdField.setBounds(275, 238, 254, 43);
		contentPane.add(userIdField);
		userIdField.setText(cUserId);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		nameField.setColumns(10);
		nameField.setBounds(275, 335, 254, 43);
		contentPane.add(nameField);
		nameField.setText(cName);
		
		JRadioButton customerRadioButton = new JRadioButton("CUSTOMER");
		customerRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designation="C";
			}
		});
		customerRadioButton.setBackground(new Color(253, 245, 230));
		customerRadioButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		customerRadioButton.setBounds(275, 429, 103, 21);
		contentPane.add(customerRadioButton);
		
		JRadioButton staffRadioButton = new JRadioButton("STAFF");
		staffRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designation="S";
			}
		});
		staffRadioButton.setBackground(new Color(253, 245, 230));
		staffRadioButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		staffRadioButton.setBounds(275, 469, 103, 21);
		contentPane.add(staffRadioButton);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(customerRadioButton);bg.add(staffRadioButton);
		
		JLabel lblDesignation = new JLabel("Designation:-");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblDesignation.setBounds(29, 421, 180, 43);
		contentPane.add(lblDesignation);
		
		JButton confirmSelfBankingBtn = new JButton("Self Banking");
		confirmSelfBankingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status=BankFunctions.selfBankingCredentialAdd(cAccount, cUserId, cName, designation);
				if(status) {
					JOptionPane.showMessageDialog(null, "SelfBanking Started for Customer "+cName);
				}else
					JOptionPane.showMessageDialog(null, "SelfBanking Not Started for Customer "+cName+"\n Try after Some Time");
			}
		});
		confirmSelfBankingBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		confirmSelfBankingBtn.setBackground(new Color(253, 245, 230));
		confirmSelfBankingBtn.setBounds(141, 606, 138, 43);
		contentPane.add(confirmSelfBankingBtn);
		
		JButton cancelSelfBankingBtn = new JButton("Cancel");
		cancelSelfBankingBtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 18));
		cancelSelfBankingBtn.setBackground(new Color(253, 245, 230));
		cancelSelfBankingBtn.setBounds(372, 606, 138, 43);
		contentPane.add(cancelSelfBankingBtn);
		
		
	}

	
}
