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

public class WithinBank extends JFrame {

	private JPanel contentPane;
	private JTextField accountNumberField;
	private JTextField recieverNameField;
	private JTextField TransferAmountField;
	private JTextField senderAccountField;
	private String accountSender,accountReciever,nameReciever,today;
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
					WithinBank frame = new WithinBank(resource);
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
	public WithinBank(String resource) {
		this.resource=resource;
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
		
		JLabel accountNumberLabel = new JLabel("Reciever Account Number:-");
		accountNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		accountNumberLabel.setBounds(38, 179, 251, 48);
		contentPane.add(accountNumberLabel);
		
		JLabel recieverNameLabel = new JLabel("Reciever Name:-");
		recieverNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		recieverNameLabel.setBounds(121, 246, 168, 48);
		contentPane.add(recieverNameLabel);
		
		JLabel transferAmountLabel = new JLabel("Amount Transfered:-");
		transferAmountLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		transferAmountLabel.setBounds(121, 324, 185, 48);
		contentPane.add(transferAmountLabel);
		
		senderAccountField = new JTextField();
		senderAccountField.setColumns(10);
		senderAccountField.setBounds(328, 121, 213, 37);
		contentPane.add(senderAccountField);
		
		JLabel senderAccountLabel = new JLabel("Sender Account Number:-");
		senderAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderAccountLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		senderAccountLabel.setBounds(38, 110, 251, 48);
		contentPane.add(senderAccountLabel);
		
		accountNumberField = new JTextField();
		accountNumberField.setBounds(328, 187, 213, 37);
		contentPane.add(accountNumberField);
		accountNumberField.setColumns(10);
		
		recieverNameField = new JTextField();
		recieverNameField.setColumns(10);
		recieverNameField.setBounds(328, 255, 213, 37);
		contentPane.add(recieverNameField);
		
		TransferAmountField = new JTextField();
		TransferAmountField.setColumns(10);
		TransferAmountField.setBounds(328, 324, 213, 37);
		contentPane.add(TransferAmountField);
		
		JButton transferNowButton = new JButton("Transfer Now");
		transferNowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountSender=senderAccountField.getText();
				accountReciever=accountNumberField.getText();
				nameReciever=recieverNameField.getText();
				try {
					amount=Double.parseDouble(TransferAmountField.getText());
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				boolean status=BankFunctions.sendWithinBank(accountSender,today,accountReciever,amount,resource);
				if(status) {
					JOptionPane.showMessageDialog(null, "Amount of Rs."+amount+" is transferred to "+nameReciever);
				}else {
					JOptionPane.showMessageDialog(null,"Amount is Not transffered...\n\n Try again ...\n\n");
				}
			}
		});
		transferNowButton.setBackground(new Color(253, 245, 230));
		transferNowButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		transferNowButton.setBounds(257, 478, 192, 48);
		contentPane.add(transferNowButton);
		
		
	}
}
