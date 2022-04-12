package itcarlow.ie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtcontactNo;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setSize(560, 400);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Registration() {
		
		Connect();
		
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	
	public void Connect ()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/customerdatabase", "root", "");		
		}
		catch (ClassNotFoundException ex)
		{
			
		}
		catch (SQLException ex)
		{
			
		}
		
	}
	
	
	
	/**
	 * Create the frame.
	 */
	 {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 484);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.gray);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register as Admin");
		lblNewLabel.setBounds(10, 11, 536, 60);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 55));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(30, 82, 90, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No");
		lblNewLabel_2.setBounds(30, 115, 108, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(30, 154, 75, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(30, 198, 75, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("User Name");
		lblNewLabel_5.setBounds(30, 239, 90, 18);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(30, 282, 101, 18);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6);
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Name");
		txtName.setBounds(163, 82, 258, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtcontactNo = new JTextField();
		txtcontactNo.setToolTipText("Enter Contact Number");
		txtcontactNo.setBounds(163, 113, 258, 20);
		contentPane.add(txtcontactNo);
		txtcontactNo.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setToolTipText("Enter Email");
		txtemail.setBounds(163, 153, 258, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setToolTipText("Enter Address");
		txtaddress.setBounds(163, 196, 258, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Enter User Name");
		txtUsername.setBounds(163, 239, 258, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton BTLoginButton = new JButton("Back To Login");
		BTLoginButton.setBounds(108, 329, 146, 23);
		BTLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Loginn l=new Loginn();
				l.setTitle("");
				l.setVisible(true);
				
			}
		});
		BTLoginButton.setForeground(Color.RED);
		BTLoginButton.setBackground(Color.LIGHT_GRAY);
		BTLoginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(BTLoginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(332, 329, 101, 23);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=txtName.getText();
				String fcontactNo=txtcontactNo.getText();
				String femail=txtemail.getText();
				String faddress=txtaddress.getText();
				String fusername=txtUsername.getText();
				String fpassword= new String(passwordField.getPassword());
				
				if(fname.isEmpty() || fcontactNo.isEmpty() || femail.isEmpty() || faddress.isEmpty() || fusername.isEmpty() || fpassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill up the form Properly", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					CustomerRegister(fname,fcontactNo,femail,faddress,fusername,fpassword);
				}
				
			}

			private void CustomerRegister(String fname, String fcontactNo, String femail, String faddress,String fusername, String fpassword) {
				// TODO Auto-generated method stub
				 {
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/customerdatabase", "root","");
						PreparedStatement st = (PreparedStatement)con.prepareStatement("INSERT INTO adminstrator(name,contactNo,email,address,username,password) VALUES(?,?,?,?,?,?)");
						st.setString(1, fname);
						st.setString(2, fcontactNo);
						st.setString(3, femail);
						st.setString(4, faddress);
						st.setString(5, fusername);
						st.setString(6, fpassword);
						
						int res = st.executeUpdate();
						JOptionPane.showMessageDialog(null, "User data inserted. ","Success", JOptionPane.INFORMATION_MESSAGE);	
					}
					catch(Exception e) {
						Logger.getLogger(Loginn.class.getName()).log(Level.SEVERE, null, e);
					}
				}
					
				}
			
		});
		registerButton.setBackground(Color.LIGHT_GRAY);
		registerButton.setForeground(Color.RED);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(registerButton);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password");
		passwordField.setBounds(163, 282, 258, 20);
		contentPane.add(passwordField);
	}
}


