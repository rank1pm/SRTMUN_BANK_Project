package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CheckBookStatusReport extends JFrame {

	private JPanel contentPane;
	private JTable checkBookStatusTable;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBookStatusReport frame = new CheckBookStatusReport();
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
	public CheckBookStatusReport() {
		setBounds(100, 100, 668, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JButton rejectButton = new JButton("REJECT REQUEST");
		rejectButton.setForeground(new Color(240, 248, 255));
		rejectButton.setBackground(new Color(210, 105, 30));
		rejectButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JButton approveButton = new JButton("APPROVE REQUEST");
		approveButton.setForeground(new Color(240, 248, 255));
		approveButton.setBackground(new Color(210, 105, 30));
		approveButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		model=new DefaultTableModel();
		Object[] column=BankFunctions.getAllCheckBookColumnName();
		Object[][] row=BankFunctions.getCheckBookStatusReport("CUSTOMER");
		model.setColumnIdentifiers(column);
		for(int j=0;j<row.length;j++)
			model.addRow(row[j]);
		checkBookStatusTable = new JTable();
		checkBookStatusTable.setFillsViewportHeight(true);
		checkBookStatusTable.setModel(model);
		checkBookStatusTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		checkBookStatusTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setViewportView(checkBookStatusTable);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(229)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addGap(212))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(rejectButton, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(146)
							.addComponent(approveButton, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
					.addGap(26))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(approveButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addComponent(rejectButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
					.addGap(78)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
}
