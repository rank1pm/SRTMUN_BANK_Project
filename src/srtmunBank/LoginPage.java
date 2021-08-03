package srtmunBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userId;
	private JPasswordField userPassword;
	public static String userIdText;
	public String designation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	
	Connection databaseConnection=null;
	BankFunctions fun;
	public LoginPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		databaseConnection= DBHelper.dbConnect();
		
		setBounds(100, 100, 640, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userIdLabel = new JLabel("User_id :-");
		userIdLabel.setBounds(96, 178, 90, 64);
		userIdLabel.setFont(new Font("STkaiti",Font.BOLD|Font.ITALIC,20));
		contentPane.add(userIdLabel);
		
		JLabel passwordLabel = new JLabel("Password :-");
		passwordLabel.setBounds(84, 252, 145, 69);
		passwordLabel.setFont(new Font("STkaiti",Font.BOLD|Font.ITALIC,20));
		contentPane.add(passwordLabel);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		bankLabel.setBounds(217, 31, 232, 37);
		contentPane.add(bankLabel);
		
		userId = new JTextField();
		userId.setBounds(196, 189, 253, 37);
		contentPane.add(userId);
		userId.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(196, 267, 253, 37);
		contentPane.add(userPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					userIdText=userId.getText();
					@SuppressWarnings("deprecation")
					String userPasswordText=userPassword.getText();
					String designation=BankFunctions.login(userIdText, userPasswordText);
					if(designation.equals("M")) {
						JOptionPane.showMessageDialog(null, designation);
						ManagerHome mh=new ManagerHome();
						dispose();
						mh.setVisible(true);
					}else if(designation.equals("C")){
						CustomerHome ch=new CustomerHome();
						dispose();
						ch.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect USER_ID or PASSWORD");
					}
					
				}catch(Exception loginException) {
					JOptionPane.showMessageDialog(null, loginException);
				}
			}
		});
		loginButton.setBackground(new Color(253, 245, 230));
		loginButton.setFont(new Font("Square721 BT", Font.BOLD | Font.ITALIC, 24));
		loginButton.setBounds(184, 396, 282, 40);
		contentPane.add(loginButton);
	}
}
