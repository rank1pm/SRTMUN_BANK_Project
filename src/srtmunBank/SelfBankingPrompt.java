package srtmunBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelfBankingPrompt extends JFrame {

	private JPanel contentPane;
	
	private static String cName,cAccount,cUserId;
	
//	public SelfBankingPrompt(String cAccount, String cUserId, String cName) {
//		this.cAccount=cAccount;
//		this.cUserId=cUserId;
//		this.cName=cName;
//	}
//	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelfBankingPrompt frame = new SelfBankingPrompt(cAccount,cUserId, cName);
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
	public SelfBankingPrompt(String cAccount, String cUserId, String cName) {
		this.cName=cName;
		this.cAccount=cAccount;
		this.cUserId=cUserId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN BANK");
		bankLabel.setBackground(new Color(253, 245, 230));
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginCredintials lc=new LoginCredintials(cAccount,cUserId,cName);
				dispose();
				lc.setVisible(true);
			}
		});
		yesButton.setBackground(new Color(253, 245, 230));
		yesButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerHome mh=new ManagerHome();
				dispose();
				mh.setVisible(true);
			}
		});
		noButton.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		noButton.setBackground(new Color(253, 245, 230));
		
		JLabel lblDoCustomerWants = new JLabel("Do Customer Wants Self Banking...?");
		lblDoCustomerWants.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoCustomerWants.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		lblDoCustomerWants.setBackground(new Color(253, 245, 230));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDoCustomerWants, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addGap(98)))
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addComponent(yesButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(132)
					.addComponent(noButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(77))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblDoCustomerWants, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bankLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(noButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(127))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
}
