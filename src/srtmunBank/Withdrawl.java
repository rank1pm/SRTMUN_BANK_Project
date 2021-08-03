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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Withdrawl extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawlAmountField;
	private JTextField currentBalanceField;
	private JTextField customerNameField;
	private JTextField accountNumberField;
	private String balance,name,today;
	private double amount;
	private static String resource;
	private Date date;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawl frame = new Withdrawl();
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
	public Withdrawl() {
		this.resource="Self";
		date=new Date();
		today=formatter.format(date);
		setBounds(100, 100, 640, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setBounds(217, 31, 232, 37);
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(bankLabel);
		
		JLabel customerNameLabel = new JLabel("Name :-");
		customerNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		customerNameLabel.setBounds(76, 214, 102, 37);
		contentPane.add(customerNameLabel);
		
		JLabel currentBalancelabel = new JLabel("Avl. Balance :-");
		currentBalancelabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		currentBalancelabel.setBounds(76, 249, 134, 37);
		contentPane.add(currentBalancelabel);
		
		JLabel withdrawlAmountLabel = new JLabel("Withdrawl Amount:-");
		withdrawlAmountLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		withdrawlAmountLabel.setBounds(56, 364, 168, 37);
		contentPane.add(withdrawlAmountLabel);
		
		JLabel accountNumberLabel = new JLabel("Account Number :-");
		accountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		accountNumberLabel.setBounds(76, 127, 148, 37);
		contentPane.add(accountNumberLabel);
		
		customerNameField = new JTextField();
		customerNameField.setBackground(new Color(253, 245, 230));
		customerNameField.setEditable(false);
		customerNameField.setBounds(234, 222, 215, 25);
		contentPane.add(customerNameField);
		customerNameField.setColumns(10);
		
		currentBalanceField = new JTextField();
		currentBalanceField.setEditable(false);
		currentBalanceField.setBackground(new Color(253, 245, 230));
		currentBalanceField.setBounds(234, 257, 215, 25);
		contentPane.add(currentBalanceField);
		currentBalanceField.setColumns(10);
		
		withdrawlAmountField = new JTextField();
		withdrawlAmountField.setBounds(234, 372, 215, 25);
		contentPane.add(withdrawlAmountField);
		withdrawlAmountField.setColumns(10);
		
		accountNumberField = new JTextField();
		accountNumberField.setBounds(234, 135, 215, 25);
		contentPane.add(accountNumberField);
		accountNumberField.setColumns(10);
		
		
		
		JButton checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=BankFunctions.getName(accountNumberField.getText());
				balance=BankFunctions.getAvailableBalance(accountNumberField.getText());
				customerNameField.setText(name);
				currentBalanceField.setText(balance);
			}
		});
		checkBalanceButton.setBackground(new Color(253, 245, 230));
		checkBalanceButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		checkBalanceButton.setBounds(452, 173, 134, 25);
		contentPane.add(checkBalanceButton);
		
		JButton withdrawlButton = new JButton("Withdrawl");
		withdrawlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					amount=Double.parseDouble(withdrawlAmountField.getText());
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				if(amount<=0) {
					JOptionPane.showMessageDialog(null,"Enter a Valid Amount to deposit");
				}else {
					boolean status=BankFunctions.withdraw(accountNumberField.getText(),name,amount,today,resource);
					if(status) {
						JOptionPane.showMessageDialog(null, "Money Withdrawl from "+accountNumberField.getText()+" of "+name);
					}else {
						JOptionPane.showMessageDialog(null, "Money not Withdrawl from "+accountNumberField.getText()+" of "+name);
					}
				}
			}
		});
		withdrawlButton.setBackground(new Color(253, 245, 230));
		withdrawlButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		withdrawlButton.setBounds(452, 450, 134, 37);
		contentPane.add(withdrawlButton);
	}

}
