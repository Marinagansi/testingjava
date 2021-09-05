import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Admin implements ActionListener{
    JFrame frame;
    JTextField  txt_username;
    JPasswordField password;
    JLabel lbl_username,lbl_password;
    JButton btn_login;
    Font font;
    
    public Admin() {
    	frame=new JFrame("Login page");
    	frame.getContentPane().setBackground(Color.orange);
    	font=new Font("serif",Font.BOLD,22);
    	
    	//adding label
    	lbl_username=new JLabel("username");
    	lbl_username.setBounds(100,70,120,20);
    	lbl_username.setFont(font);
    	frame.add(lbl_username);
    	
    	lbl_password=new JLabel("password");
    	lbl_password.setBounds(100,120,120,30);
    	lbl_password.setFont(font);
    	frame.add(lbl_password);
    	
    	//adding textfield
    	txt_username=new JTextField();
    	txt_username.setBounds(200,70,170,40);
    	txt_username.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    	frame.add(txt_username);
    	
    	//adding passwordfield
    	password=new JPasswordField();
    	password.setBounds(200,120,170,40);
    	password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    	frame.add(password);
    	
    	//adding button
    	btn_login=new  JButton("ADMIN");
    	btn_login.setBounds(130,200,170,40);
    	btn_login.setBackground(Color.GRAY);
    	btn_login.setForeground(Color.BLACK);
    	btn_login.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
    	btn_login.setFont(font);
    	frame.add(btn_login);
    	btn_login.addActionListener(this);
    	
    	
    	
    	
    	frame.setSize(800,500);
    	frame.setResizable(false);
    	frame.setLayout(null);
    	frame.setVisible(true);
    }
    public static void main(String[] args) {
    	new Admin();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String username=txt_username.getText();
		String pass1=password.getText();
		if(username.equals("admin") && pass1.equals("password")) {
			
			JOptionPane.showMessageDialog(frame,"login successful");
		    new AdminPage();
		    frame.dispose();
		}
		else {
			
			JOptionPane.showMessageDialog(frame,"invalid username nd password");
		}
			
	}
}
