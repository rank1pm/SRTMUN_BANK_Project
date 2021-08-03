package srtmunBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Last10Transactions extends JFrame {

	private JPanel contentPane;
	private static String account;
	private String name,balance;
	private JTable transactionTabel;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Last10Transactions frame = new Last10Transactions(account);
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
	public Last10Transactions(String account) {
		this.account=account;
		name=BankFunctions.getName(account);
		balance=BankFunctions.getAvailableBalance(account);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		bankLabel.setBackground(new Color(253, 245, 230));
		
		JLabel nameLabel = new JLabel("Name:-");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		nameLabel.setBackground(new Color(253, 245, 230));
		
		JLabel accountNumberLabel = new JLabel("Account_Number:-");
		accountNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		accountNumberLabel.setBackground(new Color(253, 245, 230));
		
		JLabel availableBalanceLabel = new JLabel("Available_Balance:-");
		availableBalanceLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		availableBalanceLabel.setBackground(new Color(253, 245, 230));
		
		JLabel nameField = new JLabel(name);
		nameField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		nameField.setBackground(new Color(253, 245, 230));
		
		JLabel accountNumberField = new JLabel(account);
		accountNumberField.setHorizontalAlignment(SwingConstants.CENTER);
		accountNumberField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		accountNumberField.setBackground(new Color(253, 245, 230));
		
		JLabel availableBalanceField = new JLabel(balance);
		availableBalanceField.setHorizontalAlignment(SwingConstants.CENTER);
		availableBalanceField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		availableBalanceField.setBackground(new Color(253, 245, 230));
		
		JLabel generalInfoLabel = new JLabel("Last 10 Transcation of  account are :-");
		generalInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfoLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		generalInfoLabel.setBackground(new Color(253, 245, 230));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		model=new DefaultTableModel();
		Object[] column=BankFunctions.getTransactionColumn("TRANSACTIONS");
		Object[][] row=BankFunctions.getAllTransactionData("TRANSACTIONS",account);
		model.setColumnIdentifiers(column);
		for(int j=0;j<row.length;j++)
			model.addRow(row[j]);
		transactionTabel = new JTable();
		transactionTabel.setBackground(new Color(253, 245, 230));
		transactionTabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		transactionTabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		transactionTabel.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		transactionTabel.setModel(model);
		scrollPane.setViewportView(transactionTabel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(420)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(365))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(183)
							.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(accountNumberLabel, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
							.addGap(238))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(227)
					.addComponent(availableBalanceLabel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(availableBalanceField, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
					.addGap(296))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(generalInfoLabel, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
					.addGap(534))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(accountNumberField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(accountNumberLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(availableBalanceLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(availableBalanceField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(23)
					.addComponent(generalInfoLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
