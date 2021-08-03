package srtmunBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField confirmPasswordField;
	private JTextField newPasswordField;
	private JTextField currentPasswordField;
	private static String userId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword(userId);
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
	public ChangePassword(String userId) {
		this.userId=userId;
	setBounds(100, 100, 640, 538);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(253, 245, 230));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	JLabel bankLabel = new JLabel("SRTMUN_BANK");
	bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
	bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
	
	JLabel newPassowrdLabel = new JLabel("New Password :-");
	newPassowrdLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	
	JLabel confirmPasswordLabel = new JLabel("Confirm Password :-");
	confirmPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	
	JLabel currentPasswordLabel = new JLabel("Current Password :-");
	currentPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	
	newPasswordField = new JTextField();
	newPasswordField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	newPasswordField.setColumns(10);
	
	confirmPasswordField = new JTextField();
	confirmPasswordField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	confirmPasswordField.setColumns(10);
	
	currentPasswordField = new JTextField();
	currentPasswordField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	currentPasswordField.setColumns(10);
	
	JButton changePasswordButton = new JButton("Change Password");
	changePasswordButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(newPasswordField.getText().equals(confirmPasswordField.getText())) {
				boolean status=BankFunctions.changePassword(userId,currentPasswordField.getText(),newPasswordField.getText());
				if(status)
					JOptionPane.showMessageDialog(null, "Password Updated Successfully for "+userId);
				else
					JOptionPane.showMessageDialog(null, "Password Updation Not done successfully for "+userId+"\n\n Please try again later");
			}
			else
				JOptionPane.showMessageDialog(null, "New Password and Confirm Password Did not matched...");
		}
	});
	changePasswordButton.setBackground(new Color(253, 245, 230));
	changePasswordButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
	
	JButton resetButton = new JButton("Reset");
	resetButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			newPasswordField.setText(null);
			confirmPasswordField.setText(null);
			currentPasswordField.setText(null);
		}
	});
	resetButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
	resetButton.setBackground(new Color(253, 245, 230));
	
	
	
	
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(212)
				.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
				.addGap(172))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(46)
				.addComponent(currentPasswordLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
				.addGap(10)
				.addComponent(currentPasswordField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
				.addGap(172))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(46)
				.addComponent(newPassowrdLabel, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
				.addGap(36)
				.addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
				.addGap(172))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(46)
				.addComponent(confirmPasswordLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
				.addGap(10)
				.addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
				.addGap(172))
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(229)
				.addComponent(changePasswordButton, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
				.addGap(42)
				.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
				.addGap(25))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(26)
				.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
				.addGap(59)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(currentPasswordLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(8)
						.addComponent(currentPasswordField, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addGap(4)))
				.addGap(17)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(newPassowrdLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(8)
						.addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addGap(4)))
				.addGap(31)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(confirmPasswordLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(8)
						.addComponent(confirmPasswordField, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addGap(4)))
				.addGap(79)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(changePasswordButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
				.addGap(94))
	);
	contentPane.setLayout(gl_contentPane);
	

	
	}
}
