package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class EmiStatus extends JFrame {

	private JPanel contentPane;
	private JTable emiStatusTable;
	DefaultTableModel model;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmiStatus frame = new EmiStatus();
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
	public EmiStatus() {
		setBounds(100, 100, 668, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN BANK");
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		scrollPane = new JScrollPane();
		
		emiStatusTable = new JTable();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		model=new DefaultTableModel();
		Object[] column=BankFunctions.getAllEmiReportColumn();
		Object[][] row=BankFunctions.getAllEmiReport("CUSTOMER");
		model.setColumnIdentifiers(column);
		for(int j=0;j<row.length;j++)
			model.addRow(row[j]);
		emiStatusTable = new JTable();
		emiStatusTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		emiStatusTable.setColumnSelectionAllowed(true);
		emiStatusTable.setFillsViewportHeight(true);
		emiStatusTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		emiStatusTable.setForeground(new Color(221, 160, 221));
		emiStatusTable.setModel(model);
		emiStatusTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		scrollPane.setViewportView(emiStatusTable);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(261)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addGap(194))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addGap(71)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
					.addGap(69))
		);
		contentPane.setLayout(gl_contentPane);

		
		
	}
}
