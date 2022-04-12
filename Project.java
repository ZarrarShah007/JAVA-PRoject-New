package itcarlow.ie;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;



public class Project extends JFrame  {

	private JFrame frame;
	private JTextField txtcustomer_name;
	private JTextField txtcustomer_phone;
	private JTextField txtcustomer_email;
	private JTextField txtcustomer_country;
	private JTable table;
	private JTextField txt_idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Project() {
		initialize();
		Connect();
		table_load();
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
		{}
		catch (SQLException ex)
		{}
}
	
	public void table_load()
	{try
		{
			pst= con.prepareStatement("select * from customer");
			rs = pst.executeQuery ();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(905, 489);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 911, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          Customers");
		lblNewLabel.setBounds(93, 0, 333, 54);
		lblNewLabel.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\User-Group-icon.png"));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 21));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 58, 404, 223);
		panel.setBorder(new TitledBorder(null, "Registration Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 42, 108, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Phone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 96, 108, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer Email");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(10, 141, 108, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Customer Country");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(10, 183, 129, 14);
		panel.add(lblNewLabel_3_1_1);
		
		txtcustomer_name = new JTextField();
		txtcustomer_name.setColumns(10);
		txtcustomer_name.setBounds(182, 40, 162, 20);
		panel.add(txtcustomer_name);
		
		txtcustomer_phone = new JTextField();
		txtcustomer_phone.setColumns(10);
		txtcustomer_phone.setBounds(182, 94, 162, 20);
		panel.add(txtcustomer_phone);
		
		txtcustomer_email = new JTextField();
		txtcustomer_email.setColumns(10);
		txtcustomer_email.setBounds(182, 139, 162, 20);
		panel.add(txtcustomer_email);
		
		txtcustomer_country = new JTextField();
		txtcustomer_country.setColumns(10);
		txtcustomer_country.setBounds(182, 181, 162, 20);
		panel.add(txtcustomer_country);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(10, 284, 108, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String customer_name, customer_phone, customer_email, customer_country;
				
				customer_name = txtcustomer_name.getText();
				customer_email = txtcustomer_email.getText();
				customer_phone =txtcustomer_phone.getText();
				customer_country = txtcustomer_country.getText();
				
			try {
				pst = con.prepareStatement("insert into customer(customer_name,customer_email,customer_phone,customer_country) values(?,?,?,?)");
				
				pst.setString(1,customer_name);
				pst.setString(2,customer_email);
				pst.setString(3,customer_phone);
				pst.setString(4,customer_country);
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Record Added");
				table_load();
				
				txtcustomer_name.setText("");
				txtcustomer_email.setText("");
				txtcustomer_phone.setText("");
				txtcustomer_country.setText("");
				
				txtcustomer_name.requestFocus();
			}	
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			}
			
			
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Clear");
		btnSave.setBounds(128, 284, 108, 46);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				txtcustomer_name.setText("");
				txtcustomer_email.setText("");
				txtcustomer_phone.setText("");
				txtcustomer_country.setText("");
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(246, 284, 103, 46);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			HHome h = new HHome();
			frame.dispose();
			h.setTitle("");
			h.setVisible(true);
			
			
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnExit);
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(424, 57, 461, 265);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(10, 332, 366, 54);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID");
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\ser.png"));
		lblNewLabel_1_1.setBounds(27, 17, 137, 28);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblNewLabel_1_1);
		
		txt_idd = new JTextField();
		txt_idd.setBounds(203, 22, 114, 20);
		txt_idd.addKeyListener(new KeyAdapter()
		
		{ 
			public void keyReleased(KeyEvent e)
 
			{
			
				try 
				{
					String customer_id= txt_idd.getText();
					
					pst =con.prepareStatement("select customer_name,customer_email,customer_phone,customer_country from customer where customer_id=?");
					pst.setString(1, customer_id);
					ResultSet rs =pst.executeQuery();
					  
			if(rs.next () == true)
			{
				String customer_name = rs.getString(1);
				String customer_email = rs.getString(2);
				String customer_phone = rs.getString(3);
				String customer_country =rs.getString(4);
				
				
				txtcustomer_name.setText(customer_name);
				txtcustomer_email.setText(customer_email);
				txtcustomer_phone.setText(customer_phone);
				txtcustomer_country.setText(customer_country);
				
				
			}
			else
			{
				txtcustomer_name.setText("");
				txtcustomer_email.setText("");
				txtcustomer_phone.setText("");
				txtcustomer_country.setText("");
			}
				}
				
				catch(SQLException ex) {
					}
				
				
			} 
			
		}
		);
		
		txt_idd.setColumns(10);
		panel_1.add(txt_idd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(579, 329, 89, 46);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String customer_name,customer_email,customer_phone,customer_country,customer_id;
				
				
				customer_name = txtcustomer_name.getText();
				customer_email = txtcustomer_email.getText();
				customer_phone = txtcustomer_phone.getText();
				customer_country = txtcustomer_country.getText();
				customer_id = txt_idd.getText();
				
			
				try {
				pst = con.prepareStatement("update customer set customer_name=? , customer_email=? ,customer_phone=? ,customer_country=? where customer_id=?");
				pst.setString(1, customer_name);
				pst.setString(2, customer_email);
				pst.setString(3, customer_phone);
				pst.setString(4, customer_country);
				pst.setString(5, customer_id);
				
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Updated");
				table_load();
				
				
				txtcustomer_name.setText("");
				txtcustomer_email.setText("");
				txtcustomer_phone.setText("");
				txtcustomer_country.setText("");
				txt_idd.setText("");
				
				txtcustomer_name.requestFocus();
				
				}
		catch(SQLException e1)
				{
			e1.printStackTrace();
			}
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setBounds(707, 329, 89, 46);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String customer_id ;
				
				
				customer_id = txt_idd.getText();
				
				try {
					pst = con.prepareStatement(" delete from customer where customer_id=? ");
					
					pst.setString(1, customer_id);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted");
					
					table_load();
					
					txtcustomer_name.setText("");
					txtcustomer_email.setText("");
					txtcustomer_phone.setText("");	
				txtcustomer_country.setText("");
					txt_idd.requestFocus();
					
				}
				
				catch(SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				}
			
			
			
			
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton_1_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
}
