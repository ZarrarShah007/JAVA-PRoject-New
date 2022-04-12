package itcarlow.ie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;


public class Productp extends JFrame {

	private JFrame frame;
	private JTextField txtpname;
	private JTextField txtprice;
	private JTextField txttype;
	private JTextField txtpid;
	private JTextField txtquantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productp window = new Productp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Productp() {
		initialize();
		Connect();
		table_load();
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
	
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
	
	public void table_load()
	{
		try
		{
			pst= con.prepareStatement("select * from product");
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
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setBounds(100, 100, 905, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 452);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\shop-icon.png"));
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(211, -24, 214, 98);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBorder(new TitledBorder(null, "Product Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 47, 401, 241);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 25, 106, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Type");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 90, 106, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Product Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 142, 106, 30);
		panel_1.add(lblNewLabel_1_2);
		
		txtpname = new JTextField();
		txtpname.setBounds(192, 32, 170, 30);
		panel_1.add(txtpname);
		txtpname.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(192, 144, 170, 30);
		panel_1.add(txtprice);
		
		txttype = new JTextField();
		txttype.setColumns(10);
		txttype.setBounds(192, 92, 170, 30);
		panel_1.add(txttype);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Product Quantity");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 189, 151, 30);
		panel_1.add(lblNewLabel_1_2_1);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(192, 189, 170, 30);
		panel_1.add(txtquantity);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
			String pname,type,price,quantity ;
			
			pname = txtpname.getText();
			type = txttype.getText();
			price = txtprice.getText();
			quantity = txtquantity.getText();
			
			try {
				pst = con.prepareStatement("insert into product(name,type,price,quantity) values(?,?,?,?)");
				pst.setString(1, pname);
				pst.setString(2,type);
				pst.setString(3,price);
				pst.setString(4, quantity);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Added");
				
				table_load();
				
				txtpname.setText("");
				txttype.setText("");
				txtprice.setText("");
				txtquantity.setText("");
				txtpname.requestFocus();
				
			}
			
			catch(SQLException e1) 
			{
				
				e1.printStackTrace();
			}
			}
			

			
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(20, 286, 81, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.GRAY);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpname.setText("");
				txttype.setText("");
				txtprice.setText("");
				txtquantity.setText("");
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(147, 286, 81, 60);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HHome h = new HHome();
				frame.dispose();
				h.setTitle("");
				h.setVisible(true);
				
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(274, 286, 81, 60);
		frame.getContentPane().add(btnExit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		panel_3.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(20, 357, 391, 84);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(93, 10, 10, 10);
		panel_3.add(panel_3_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Product ID");
		lblNewLabel_1_3.setIcon(new ImageIcon("E:\\Eclip3\\OOSD\\src\\itcarlow\\ie\\search-icon.png"));
		lblNewLabel_1_3.setBounds(27, 31, 117, 25);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_1_3);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				try 
				{
					String id =txtpid.getText();
					
					pst = con.prepareStatement("select name,type,price,quantity from product where id =?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next() == true)
					
				{
				
				String name= rs.getString(1);
				String type = rs.getString(2);
				String price = rs.getString(3);
				String quantity = rs.getString(4);
				
				txtpname.setText(name);
				txttype.setText(type);
				txtprice.setText(price);
				txtquantity.setText(quantity);
				
			}
			
			
			else
			{
				txtpname.setText("");
				txttype.setText("");
				txtprice.setText("");
			}}
			
					catch(SQLException ex) {
			}
				}
					
				});
		txtpid.setBounds(180, 26, 164, 30);
		txtpid.setColumns(10);
		panel_3.add(txtpid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,type,price,pid,quantity ;
				
				pname = txtpname.getText();
				type = txttype.getText();
				price = txtprice.getText();
				pid = txtpid.getText();
				quantity = txtquantity.getText();
				
				try {
					pst = con.prepareStatement("update product set name=?, type=?, price=?, quantity=? where id=? ");
					pst.setString(1, pname);
					pst.setString(2,type);
					pst.setString(3,price);
					pst.setString(4,quantity);
					pst.setString(5, pid);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated");
					
					table_load();
					
					txtpname.setText("");
					txttype.setText("");
					txtprice.setText("");
					txtquantity.setText("");
					txtpname.requestFocus();
					
				}
				
				catch(SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				}
				
		
					
				
				
				
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(512, 357, 90, 69);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String pid ;
				
				
				pid = txtpid.getText();
				
				try {
					pst = con.prepareStatement(" delete from product where id=? ");
					
					pst.setString(1, pid);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted");
					
					table_load();
					
					txtpname.setText("");
					txttype.setText("");
					txtprice.setText("");
					txtquantity.setText("");
					txtpname.requestFocus();
					
				}
				
				catch(SQLException e1) 
				{
					
					e1.printStackTrace();
				}
				}
			
			
			
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(718, 357, 90, 69);
		frame.getContentPane().add(btnDelete);
		
		table = new JTable();
		table.setBounds(531, 47, 330, 249);
		frame.getContentPane().add(table);
	}

	
}
