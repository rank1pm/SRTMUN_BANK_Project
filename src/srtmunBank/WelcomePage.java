package srtmunBank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class WelcomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bankLabel = new JLabel("SRTMUN_BANK");
		bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankLabel.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 40));
		
		JLabel welcomeLabel = new JLabel("Welcomes You");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Sitka Text", Font.ITALIC, 30));
		
		JButton loginButton = new JButton("Click Here to Login");
		loginButton.setForeground(new Color(240, 248, 255));
		loginButton.addActionListener(new ActionListener() {
			/**
			 *
			 */
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				lp.setVisible(true);
			}
		});
		loginButton.setBackground(new Color(165, 42, 42));
		loginButton.setFont(new Font("Square721 BT", Font.BOLD | Font.ITALIC, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(185)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
					.addGap(177))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addGap(167))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(203)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
					.addGap(198))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(bankLabel, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(236)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(134))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
