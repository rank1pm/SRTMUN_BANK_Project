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

public class UpdateEmail extends JFrame {

	private JPanel contentPane;
	private JTextField newEmailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmail frame = new UpdateEmail();
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
	public UpdateEmail() {
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
		
		JLabel newEmailLabel = new JLabel("Enter New Email:-");
		newEmailLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		newEmailLabel.setBounds(50, 109, 137, 30);
		contentPane.add(newEmailLabel);
		
		newEmailField = new JTextField();
		newEmailField.setBounds(197, 109, 293, 30);
		contentPane.add(newEmailField);
		newEmailField.setColumns(10);
		
		JButton updateEmailButton = new JButton("Update Email");
		updateEmailButton.setBackground(new Color(165, 42, 42));
		updateEmailButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		updateEmailButton.setBounds(182, 178, 154, 37);
		contentPane.add(updateEmailButton);
	}

}
