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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendMoney extends JFrame {

	private JPanel contentPane;
	private static String resource;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMoney frame = new SendMoney(resource);
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
	public SendMoney(String resource) {
		this.resource=resource;
		setBounds(100, 100, 492, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setBounds(120, 35, 232, 37);
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(bankLabel);
		
		JButton withinBankButton = new JButton("WithinBank");
		withinBankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithinBank wb=new WithinBank(resource);
				wb.setVisible(true);
				dispose();
			}
		});
		withinBankButton.setBackground(new Color(253, 245, 230));
		withinBankButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		withinBankButton.setBounds(161, 126, 176, 47);
		contentPane.add(withinBankButton);
		
		JButton otherBankButton = new JButton("Other Bank");
		otherBankButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtherBank ob=new OtherBank(resource);
				ob.setVisible(true);
				dispose();
			}
		});
		otherBankButton.setBackground(new Color(253, 245, 230));
		otherBankButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		otherBankButton.setBounds(161, 220, 176, 47);
		contentPane.add(otherBankButton);
	}

}
