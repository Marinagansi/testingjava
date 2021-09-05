import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Register implements ActionListener {
	JFrame frame2;
	static JTextField fname;
	JTextField lname;
	JTextField username;
	JTextField gender;
	JTextField address;
	JTextField phone;
	JTextField email;
	JLabel lbl_fname,lbl_lname,lbl_username,lbl_gender,lbl_cpassword,lbl_password,lbl_email;
	JPasswordField password,c_password;
	JRadioButton rb1,rb2;
	Font fn,fn1;
	JButton btn_submit;
	
	
	public Register() {
		frame2=new JFrame("register page") ;
		frame2.getContentPane().setBackground(Color.GRAY);
		fn=new Font("serif",Font.BOLD,22);
		fn1=new Font("serif",Font.BOLD,19);
		//ading label
		lbl_fname=new JLabel(" Name");
		lbl_fname.setBounds(100,60,170,50);
		lbl_fname.setForeground(Color.black);
		lbl_fname.setFont(fn);
		
//		lbl_lname=new JLabel("Location");
//		lbl_lname.setBounds(400,60,170,50);
//		lbl_lname.setForeground(Color.black);
//		lbl_lname.setFont(fn);
		
		lbl_username=new JLabel("gender");
		lbl_username.setBounds(100,140,170,50);
		lbl_username.setForeground(Color.black);
		lbl_username.setFont(fn);
		
		lbl_email=new JLabel("Email");
		lbl_email.setBounds(100,105,170,50);
		lbl_email.setForeground(Color.black);
		lbl_email.setFont(fn);
		
		lbl_password=new JLabel("Password");
		lbl_password.setBounds(100,200,170,50);
		lbl_password.setForeground(Color.black);
		lbl_password.setFont(fn);
		
		lbl_cpassword=new JLabel("cpassword");
		lbl_cpassword.setBounds(100,250,170,50);
		lbl_cpassword.setForeground(Color.black);
		lbl_cpassword.setFont(fn);
		
		frame2.add(lbl_cpassword);
		frame2.add(lbl_password);
		frame2.add(lbl_email);
	frame2.add(lbl_username);
//		frame2.add(lbl_lname);
		frame2.add(lbl_fname);
		
		//adding textfield
		fname=new JTextField();
		fname.setBounds(263,65,190,40);
		fname.setFont(fn);
		frame2.add(fname);
		
//		lname=new JTextField();
//		lname.setBounds(400,100,190,40);
//		lname.setFont(fn);
//		frame2.add(lname);
//		
//		username=new JTextField("Type");
//		username.setBounds(100,150,190,40);
//		username.setFont(fn);
//		frame2.add(username);
		
		email=new JTextField();
		email.setBounds(263,110,190,40);
		email.setFont(fn);
		frame2.add(email);
		
		password=new JPasswordField();
		password.setBounds(263,200,190,40);
		password.setFont(fn);
		frame2.add(password);
		
		c_password=new JPasswordField();
		c_password.setBounds(263,250,190,40);
		c_password.setFont(fn);
		frame2.add(c_password);
		//radiobutton
		rb1=new JRadioButton("male");    
		rb1.setBounds(263,150,100,30); 
		rb1.setFont(fn);
		rb1.setForeground(Color.black);
		rb1.setBackground(Color.GRAY);
		rb2=new JRadioButton("female"); 
		rb2.setForeground(Color.black);
		rb2.setBounds(360,150,100,30);  
		rb2.setFont(fn);
		rb2.setBackground(Color.GRAY);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2);    
		    
		    
		frame2.add(rb1);frame2.add(rb2);
		
		// adding button
		btn_submit=new JButton("SUBMIT");
		btn_submit.setBounds(260,370,190,40);
		btn_submit.setFont(fn);
		
		frame2.add(btn_submit);
		btn_submit.addActionListener(this);
		
	   frame2.setSize(800,500);
	   frame2.setLayout(null);
	   frame2.setVisible(true);
	}
	public static void main(String[] args) {
		
		new Register();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String Fname=fname.getText();
//		String Lname=lname.getText();
//		String uname=username.getText();
		String email1=email.getText();
		
		String password1=password.getText();
		String Cpass=c_password.getText();
		String g="";
		if(rb1.isSelected()){    
			 g="male";    
			}    
			if(rb2.isSelected()){    
			 g="female";    
			}
			
		
		if (e.getSource()==btn_submit) {
			Data db=new Data();
			String query="insert into register(hname,email,type,password,cpassword)values('"+Fname+"','"+email1+"','"+g+"','"+password1+"','"+Cpass+"')";
			int ans=db.insert(query);
			if (ans>0) {
				JOptionPane.showMessageDialog(frame2,"user created successfully");
				frame2.dispose();
				new HomePage();
			}

	}
		
	}
}
