package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UpdatePhone extends JFrame {

	private JPanel contentPane;
	private JTextField newPhoneNumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePhone frame = new UpdatePhone();
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
	public UpdatePhone() {
		setBounds(100, 100, 514, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setBounds(104, 22, 232, 37);
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(bankLabel);
		
		JLabel newPhoneNumberLabel = new JLabel("Enter New Phone Number:-");
		newPhoneNumberLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		newPhoneNumberLabel.setBounds(41, 109, 207, 30);
		contentPane.add(newPhoneNumberLabel);
		
		newPhoneNumberField = new JTextField();
		newPhoneNumberField.setBounds(258, 109, 232, 30);
		contentPane.add(newPhoneNumberField);
		newPhoneNumberField.setColumns(10);
		
		JButton updatePhoneNumberButton = new JButton("Update Phone");
		updatePhoneNumberButton.setBackground(new Color(165, 42, 42));
		updatePhoneNumberButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		updatePhoneNumberButton.setBounds(182, 178, 154, 37);
		contentPane.add(updatePhoneNumberButton);
		
	}

}
