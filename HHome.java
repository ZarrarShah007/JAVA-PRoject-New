package itcarlow.ie;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class HHome extends JFrame {
	
	public int z=0;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HHome frame = new HHome();
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
	public HHome() {
		initialize();
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	/**
	 * Create the application.
	 */
	
	public HHome(String title) {
		
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(706, 460);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 28));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 29));
		lblNewLabel.setBounds(214, 11, 301, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project p = new Project();
				frame.dispose();
				p.setTitle("");
				p.setVisible(true);
				
		
			}

			
			
		});
		btnNewButton.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\Users-icon.png"));
		btnNewButton.setBounds(57, 118, 122, 76);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productp s = new Productp();
				frame.dispose();
				s.setTitle("");
				s.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\add-item-icon.png"));
		btnNewButton_1.setBounds(292, 118, 122, 76);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice i = new Invoice();
				frame.dispose();
				i.setTitle("");
				i.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\invoice-icon.png"));
		btnNewButton_2.setBounds(523, 118, 122, 76);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Customers");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel_1.setBounds(67, 215, 101, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Products");
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(302, 219, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Invoices");
		lblNewLabel_1_2.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(529, 219, 101, 26);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginn l = new Loginn();
				dispose();
				l.setTitle("");
				l.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton_3.setBounds(174, 315, 129, 44);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Exit");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3_1.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnNewButton_3_1.setBounds(382, 315, 122, 44);
		frame.getContentPane().add(btnNewButton_3_1);
	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
}
