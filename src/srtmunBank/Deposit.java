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
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField availabalBalanceField;
	private JTextField depositedAmountField;
	private JTextField customerNameField;
	private JTextField accountNumberField;
	private JLabel depositedAmountLabel;
	private String account,name,today;
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
					Deposit frame = new Deposit();
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
	public Deposit() {
		this.resource="self";
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
		customerNameLabel.setBounds(76, 187, 102, 37);
		contentPane.add(customerNameLabel);
		
		JLabel availabalBalanceLabel = new JLabel("Avl. Balance :-");
		availabalBalanceLabel.setEnabled(false);
		availabalBalanceLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		availabalBalanceLabel.setBounds(76, 364, 134, 37);
		contentPane.add(availabalBalanceLabel);
		
		depositedAmountLabel = new JLabel("Deposited Amount:-");
		depositedAmountLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		depositedAmountLabel.setBounds(51, 249, 168, 37);
		contentPane.add(depositedAmountLabel);
		
		JLabel accountNumberlabel = new JLabel("Account Number :-");
		accountNumberlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		accountNumberlabel.setBounds(76, 127, 148, 37);
		contentPane.add(accountNumberlabel);
		
		customerNameField = new JTextField();
		customerNameField.setBounds(234, 195, 215, 25);
		contentPane.add(customerNameField);
		customerNameField.setColumns(10);
		
		depositedAmountField = new JTextField();
		depositedAmountField.setBounds(234, 257, 215, 25);
		contentPane.add(depositedAmountField);
		depositedAmountField.setColumns(10);
		
		availabalBalanceField = new JTextField();
		availabalBalanceField.setBackground(new Color(253, 245, 230));
		availabalBalanceField.setEditable(false);
		availabalBalanceField.setBounds(234, 372, 215, 25);
		contentPane.add(availabalBalanceField);
		availabalBalanceField.setColumns(10);
		
		accountNumberField = new JTextField();
		accountNumberField.setBounds(234, 135, 215, 25);
		contentPane.add(accountNumberField);
		accountNumberField.setColumns(10);
		
		JButton checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				availabalBalanceField.setText(BankFunctions.getAvailableBalance(account));
			}
		});
		checkBalanceButton.setBackground(new Color(253, 245, 230));
		checkBalanceButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		checkBalanceButton.setBounds(438, 443, 134, 25);
		contentPane.add(checkBalanceButton);
		
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account=accountNumberField.getText();
				name=customerNameField.getText();
				try {
					amount=Double.parseDouble(depositedAmountField.getText());
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				if(amount<=0) {
					JOptionPane.showMessageDialog(null,"Enter a Valid Amount to deposit");
				}else {
					boolean status=BankFunctions.deposit(account,name,amount,today,resource);
					if(status) {
						JOptionPane.showMessageDialog(null, "Money deposited to "+account+" of "+name);
					}else {
						JOptionPane.showMessageDialog(null, "Money not deposited to "+account+" of "+name);
					}
				}
			}
		});
		depositButton.setBackground(new Color(253, 245, 230));
		depositButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		depositButton.setBounds(438, 303, 134, 37);
		contentPane.add(depositButton);
		
		
	}

}
