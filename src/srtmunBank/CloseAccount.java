package srtmunBank;

import java.awt.BorderLayout;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CloseAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField customerNameField;
	private JTextField accountNumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloseAccount frame = new CloseAccount();
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
	public CloseAccount() {
		setBounds(100, 100, 725, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JLabel customerNameLabel = new JLabel("Name :-");
		customerNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel accountNumberLabel = new JLabel("Account Number :-");
		accountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		customerNameField = new JTextField();
		customerNameField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerNameField.setColumns(10);
		
		accountNumberField = new JTextField();
		accountNumberField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		accountNumberField.setColumns(10);
		
		JButton closeAccountButton = new JButton("Close Account");
		closeAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status=BankFunctions.closeAccount(accountNumberField.getText(),customerNameField.getText());
				if(status)
					JOptionPane.showMessageDialog(null, "Account of "+customerNameField.getText()+" is Deleted");
				else
					JOptionPane.showMessageDialog(null, "Account of "+customerNameField.getText()+" is not Deleted");
			}
		});
		closeAccountButton.setForeground(new Color(0, 0, 0));
		closeAccountButton.setBackground(new Color(253, 245, 230));
		closeAccountButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(212)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addGap(179))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(accountNumberLabel, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(179))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addComponent(customerNameLabel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(56)
					.addComponent(customerNameField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(179))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(410)
					.addComponent(closeAccountButton, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(74))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(bankLabel, GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(accountNumberLabel, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addGap(12)))
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(customerNameLabel, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addGap(51))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(customerNameField, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
							.addGap(75)))
					.addGap(36)
					.addComponent(closeAccountButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}

}
