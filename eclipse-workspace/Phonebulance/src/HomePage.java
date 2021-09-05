import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class HomePage extends searchtable implements ActionListener {
	JFrame frame1,frame,frame2;
	JPanel panel1,panel2;
	GridLayout layout;
	Font font1,font3;
	JButton btn_login,btn_register,btn_admin,button,btn_click;
	JTextField  txt_username;
	JPasswordField password;
	JLabel lbl_username,lbl_password,lbl,lbl1;
	JComboBox j4;
	Font font;
	
	
	public HomePage() {
		frame=new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		
		panel1= new JPanel();
		panel1.setBounds(160,385,110,70);
		panel1.setBackground(Color.ORANGE);
		layout=new GridLayout(2,1);
		
		layout.setVgap(18);
		panel1.setLayout(layout);	
		
		panel2=new JPanel();
		panel2.setBounds(350,100,5,380);
		frame.add(panel2);
		
		// font style
		font1=new Font("serif",Font.BOLD,22);
		font3=new Font("serif",Font.BOLD,36);
		lbl=new JLabel("Phonebulance");
		lbl1=new JLabel("(Ambulance contact list)");
		lbl1.setFont(font1);
		lbl1.setBounds(370,13,500,100);
		frame.add(lbl1);
		
		
		lbl.setFont(font3);
		lbl.setBounds(150,10,500,100);
		frame.add(lbl);
		//adding button
		
		
		btn_register=new JButton("Register");
		btn_register.setBackground(Color.white);
		btn_register.setForeground(Color.BLACK);
		btn_register.setFont(font1);
		btn_register.setBorder(BorderFactory.createLineBorder(Color.black,3));
		btn_register.addActionListener(this);
		
		btn_admin=new JButton("Admin");
		btn_admin.setBackground(Color.white);
		btn_admin.setForeground(Color.BLACK);
		btn_admin.setFont(font1);
		btn_admin.setBorder(BorderFactory.createLineBorder(Color.black,3));
		btn_admin.addActionListener(this);
		
		panel1.add(btn_register);
		panel1.add(btn_admin);
		
		frame.add(panel1);
		
		//login layout
		font=new Font("serif",Font.BOLD,22);
		
		//textbox for search
		textbox = new JTextField();
		textbox.setBounds(450,220,170,40); 
		frame.add(textbox);
    	
//    	//adding label
    	lbl_username=new JLabel("username");
    	lbl_username.setBounds(30,150,120,20);
    	lbl_username.setFont(font);
    	frame.add(lbl_username);
    	
    	lbl_password=new JLabel("password");
    	lbl_password.setBounds(30,200,120,30);
    	lbl_password.setFont(font);
    	frame.add(lbl_password);
    	
    	//adding textfield
    	txt_username=new JTextField();
    	txt_username.setBounds(135,150,170,40);
    	txt_username.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    	frame.add(txt_username);
    	
    	//adding passwordfield
    	password=new JPasswordField();
    	password.setBounds(135,200,170,40);
    	password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    	frame.add(password);
		
    	//adding picture
    	 ImageIcon icon = new ImageIcon("D:\\FIGMA\\phone.png");
		  JLabel label = new JLabel(icon);
		  label.setBounds(10,20,140,120);
		  frame.add(label);
    	
    	btn_login=new  JButton("Login");
    	btn_login.setBounds(170,247,120,35);
    	btn_login.setBackground(Color.GRAY);
    	btn_login.setForeground(Color.BLACK);
    	btn_login.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    	btn_login.setFont(font);
    	frame.add(btn_login);
    	btn_login.addActionListener(this);
    	
		 j4=new JComboBox<String>();
			j4.setBounds(450,140,170,40);

			try {
				String query1="select *  from hospital";
				Data cb=new Data();
				ResultSet rs1=cb.select(query1);
				while (rs1.next()) {
					
		        	
		        	String abc=rs1.getString("Name");
		        	j4.addItem(abc);
		        	
			}
				
			}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
    	
    	
    	frame.add(j4);
    	///search button
    	button = new JButton("search");
		button.setBounds(645,140,100,40);
		frame.add(button);
		button.addActionListener(this);
		
		btn_click = new JButton("search");
		btn_click.setBounds(645,220,100,40);
		frame.add(btn_click);
		btn_click.addActionListener(this);
    	
    	
		
		frame.setSize(800,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new HomePage();
	}
	public void Show1() {
		frame1=new JFrame("database result");

		
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table =new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
		String from=(String)j4.getSelectedItem();
		String name="";
		String address1="";
		String email1="";
		String age1="";
		String phone="";
		String phn="";
		try
		{
			
			Data table1=new Data();
			String query2="select *  from hospital where Name='"+from +"'";
			ResultSet rs2=table1.select(query2);
			int i=0;
			if(rs2.next()) {
				name=rs2.getString("Name");
				address1=rs2.getString("location");
				email1=rs2.getString("email");
				age1=rs2.getString("type");
				phone=rs2.getString("phone1");
				phn=rs2.getString("phone2");
				model.addRow(new Object[] {name,address1,email1,age1,phone,phn});
				i++;
			}

		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setSize(600,150);
			}
	
	 public void display() {
		 frame2=new JFrame("database result");
//			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame2.setLayout(new BorderLayout());
			DefaultTableModel model=new DefaultTableModel();
			model.setColumnIdentifiers(column);
			table =new JTable();
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);
			JScrollPane scroll=new JScrollPane(table);
			scroll.setHorizontalScrollBarPolicy(
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			String textvalue=textbox.getText();

			String code="";
			String place="";
			String name="";
			String phon1="";
			String phon2="";
			String phon3="";
			try
			{
				String query2="select *  from addcontact where code= "+textvalue;
				Data table1=new Data();
				ResultSet rs2=table1.select(query2);
				
				
				int i=0;
				
				while(rs2.next()) {
					code=rs2.getString("code");
					place=rs2.getString("location");
					name=rs2.getString("Name");
					phon1=rs2.getString("phone1");
					phon2=rs2.getString("phone2");
					phon3=rs2.getString("phone3");
					model.addRow(new Object[] {code,place,name,phon1,phon2,phon3});
					i++;
					 
				}
				if(i<1) {
					
					JOptionPane.showMessageDialog(null, "No Record Found","Error",
							JOptionPane.ERROR_MESSAGE);
//					return;
				}
				if(i ==1)
				{
				System.out.println(i+" Record Found");
				}
				else
				{
				System.out.println(i+" Records Found");
				}

			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			frame2.add(scroll);
			frame2.setVisible(true);
			frame2.setSize(800,200);
				}
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			Show1();
		}
		if (e.getSource()==btn_click) {
			display();
		}
			
		if (e.getSource()==btn_admin) {
			new Admin();
			frame.dispose();
		}if(e.getSource()==btn_register) {
			new Register();
			frame.dispose();
			
		}
		if(e.getSource()==btn_login) {
			String username1=txt_username.getText();
			String pass=password.getText();
			
			String query="select * from register where hname='"+username1+"' and password='"+pass+"'";
			Data db=new Data();
			ResultSet rs=db.select(query);
			try {
				if(rs.next()) {
					JOptionPane.showMessageDialog(frame1,"login successful");
				    
				}
				else {
					JOptionPane.showMessageDialog(frame1,"invalid username nd password");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
}
}
}
	
