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
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OtherBank extends JFrame {

	private JPanel contentPane;
	private JTextField ifscCodeField;
	private JTextField senderAccountNumberField;
	private JTextField transferAmountField;
	private JTextField recieverNameField;
	private JTextField recieverAccountNumberField;
	private static String resource;
	private String senderAccount,recieverAccount,ifscCode,recieverName,today;
	private double transferAmount;
	private Date date;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtherBank frame = new OtherBank(resource);
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
	public OtherBank(String resource) {
		this.resource=resource;
		date=new Date();
		today=formatter.format(date);
		setBounds(100, 100, 1031, 769);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setBounds(405, 22, 232, 37);
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(bankLabel);
		
		JLabel senderAccountNumberLabel = new JLabel("Sender Account Number:-");
		senderAccountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		senderAccountNumberLabel.setBounds(32, 119, 232, 48);
		contentPane.add(senderAccountNumberLabel);
		
		JLabel recieverNameLabel = new JLabel("Reciever Name:-");
		recieverNameLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		recieverNameLabel.setBounds(540, 226, 168, 48);
		contentPane.add(recieverNameLabel);
		
		JLabel transferAmountlabel = new JLabel("Amount Transfered:-");
		transferAmountlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		transferAmountlabel.setBounds(229, 323, 185, 48);
		contentPane.add(transferAmountlabel);
		
		ifscCodeField = new JTextField();
		ifscCodeField.setBounds(306, 235, 213, 37);
		contentPane.add(ifscCodeField);
		ifscCodeField.setColumns(10);
		
		recieverNameField = new JTextField();
		recieverNameField.setColumns(10);
		recieverNameField.setBounds(779, 235, 213, 37);
		contentPane.add(recieverNameField);
		
		transferAmountField = new JTextField();
		transferAmountField.setColumns(10);
		transferAmountField.setBounds(450, 331, 213, 37);
		contentPane.add(transferAmountField);
		
		
		JLabel ifscCodeLabel = new JLabel("IFSC Code:-");
		ifscCodeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		ifscCodeLabel.setBounds(34, 227, 168, 48);
		contentPane.add(ifscCodeLabel);
		
		senderAccountNumberField = new JTextField();
		senderAccountNumberField.setBounds(306, 127, 213, 37);
		contentPane.add(senderAccountNumberField);
		senderAccountNumberField.setColumns(10);
		
		JLabel recieverAccountNumberLabel = new JLabel("Reciever Account Number:-");
		recieverAccountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		recieverAccountNumberLabel.setBounds(537, 119, 232, 48);
		contentPane.add(recieverAccountNumberLabel);
		
		recieverAccountNumberField = new JTextField();
		recieverAccountNumberField.setColumns(10);
		recieverAccountNumberField.setBounds(779, 127, 213, 37);
		contentPane.add(recieverAccountNumberField);
		
		
		
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderAccountNumberField.setText("");
				recieverAccountNumberField.setText("");
				transferAmountField.setText("");
				recieverNameField.setText("");
				ifscCodeField.setText("");
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		cancelButton.setBackground(new Color(253, 245, 230));
		cancelButton.setBounds(577, 478, 192, 48);
		contentPane.add(cancelButton);
		
		JButton transferNowButton = new JButton("Transfer Now");
		transferNowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderAccount=senderAccountNumberField.getText();
				recieverAccount=recieverAccountNumberField.getText();
				try {
					transferAmount=Double.parseDouble(transferAmountField.getText());
					boolean status=BankFunctions.sendWithinBank(senderAccount, today, recieverAccount, transferAmount, resource);
					if(status) {
						JOptionPane.showMessageDialog(null, "Amount is transferd to "+recieverNameField.getText());
					}else {
						JOptionPane.showMessageDialog(null, "Amount is not transferd to "+recieverNameField.getText());
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		transferNowButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		transferNowButton.setBackground(new Color(253, 245, 230));
		transferNowButton.setBounds(275, 478, 192, 48);
		contentPane.add(transferNowButton);
	}
}
