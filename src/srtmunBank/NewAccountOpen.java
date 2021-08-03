package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NewAccountOpen extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField accountNumberField;
	private JTextField addressField;
	private JTextField mobileField;
	private JTextField emailField;
	private String cName,cUserId,cAccount,cAddress,cMobile,cEmail,cCheck;
	private JTextField userIdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccountOpen frame = new NewAccountOpen();
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
	public NewAccountOpen() {
		setBounds(100, 100, 668, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JLabel nameLabel = new JLabel("CUSTOMER NAME:-");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel accountNumberlabel = new JLabel("ACCOUNT NUMBER:-");
		accountNumberlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel addressLabel = new JLabel("ADDRESS:-");
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel mobilelabel = new JLabel("MOBILE:-");
		mobilelabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel emailLabel = new JLabel("EMAIL:-");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JRadioButton yesButton = new JRadioButton("YES");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCheck="YES";
			}
		});
		yesButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel checkBookLabel = new JLabel("Check Book Status");
		checkBookLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		nameField = new JTextField();
		nameField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		nameField.setColumns(10);
		
		accountNumberField = new JTextField();
		accountNumberField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		accountNumberField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		addressField.setColumns(10);
		
		mobileField = new JTextField();
		mobileField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		mobileField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		emailField.setColumns(10);
		

		JLabel userIdLabel = new JLabel("User ID:-");
		userIdLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		userIdField = new JTextField();
		userIdField.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		userIdField.setColumns(10);
		
		JRadioButton noButton = new JRadioButton("NO");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCheck="NO";
			}
		});
		noButton.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonGroup bg=new ButtonGroup();
		bg.add(noButton);bg.add(yesButton);
		JButton openAccountButton = new JButton("Open Account");
		openAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cName=nameField.getText();
				cAccount=accountNumberField.getText();
				cUserId=userIdField.getText();
				cAddress=addressField.getText();
				cMobile=mobileField.getText();
				cEmail=emailField.getText();
				boolean status=BankFunctions.openNewAccount(cName,cUserId,cAccount,cAddress,cMobile,cEmail,0.0,cCheck,"NO","ACTIVE");
				if(status) {
					JOptionPane.showMessageDialog(null, "Customer Added in Database");
					dispose();
					SelfBankingPrompt sbp=new SelfBankingPrompt(cAccount,cUserId,cName);
					sbp.setVisible(true);
				}
					else
					JOptionPane.showMessageDialog(null, "Customer Not Added in Database");
			}
			
		});
		openAccountButton.setForeground(new Color(240, 248, 255));
		openAccountButton.setBackground(new Color(210, 105, 30));
		openAccountButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				accountNumberField.setText("");
				addressField.setText("");
				mobileField.setText("");
				emailField.setText("");
				userIdField.setText("");
				bg.clearSelection();
				
			}
		});
		resetButton.setBackground(new Color(210, 105, 30));
		resetButton.setForeground(new Color(240, 248, 255));
		resetButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(222)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(189))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(accountNumberlabel, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(addressLabel, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(118)
					.addComponent(addressField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(mobilelabel, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(118)
					.addComponent(mobileField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addComponent(openAccountButton, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addGap(74)
					.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addGap(100))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(userIdLabel, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(118)
							.addComponent(userIdField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkBookLabel, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yesButton, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(noButton, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(118)
							.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
					.addGap(136))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(accountNumberlabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(accountNumberField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(addressLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(mobilelabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(mobileField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userIdLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(userIdField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(checkBookLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(52))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(yesButton)
								.addComponent(noButton))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(openAccountButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(154))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
