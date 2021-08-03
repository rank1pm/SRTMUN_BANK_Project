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
import javax.swing.JTextField;
import javax.swing.JButton;

public class CheckbookRequest extends JFrame {

	private JPanel contentPane;
	private JTextField checkBookPageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckbookRequest frame = new CheckbookRequest();
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
	public CheckbookRequest() {
		setBounds(100, 100, 514, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel banklabel = new JLabel("SRTMUN_BANK");
		banklabel.setBounds(104, 22, 232, 37);
		banklabel.setHorizontalAlignment(SwingConstants.CENTER);
		banklabel.setFont(new Font("STKaiti", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(banklabel);
		
		JLabel checkbookPageLabel = new JLabel("How Many pages to be Print in CheckBook :-");
		checkbookPageLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		checkbookPageLabel.setBounds(50, 109, 330, 30);
		contentPane.add(checkbookPageLabel);
		
		checkBookPageField = new JTextField();
		checkBookPageField.setBounds(394, 109, 96, 30);
		contentPane.add(checkBookPageField);
		checkBookPageField.setColumns(10);
		
		JButton submitRequestButton = new JButton("Submit Request");
		submitRequestButton.setBackground(new Color(165, 42, 42));
		submitRequestButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		submitRequestButton.setBounds(182, 178, 154, 37);
		contentPane.add(submitRequestButton);
	}

}
