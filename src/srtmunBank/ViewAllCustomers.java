package srtmunBank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ViewAllCustomers extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable allCustomerRecordTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllCustomers frame = new ViewAllCustomers();
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
	public ViewAllCustomers() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBounds(100, 100, 640, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		model=new DefaultTableModel();
		Object[] column=BankFunctions.getColumName("CUSTOMER");
		Object[][] row=BankFunctions.getAllData("CUSTOMER");
		model.setColumnIdentifiers(column);
		for(int j=0;j<row.length;j++)
			model.addRow(row[j]);
		allCustomerRecordTable = new JTable();
		allCustomerRecordTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		allCustomerRecordTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allCustomerRecordTable.setForeground(new Color(221, 160, 221));
		allCustomerRecordTable.setModel(model);
		allCustomerRecordTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(allCustomerRecordTable);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(212)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addGap(185))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addGap(71)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
					.addGap(5))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
		
		
		
	}
}
