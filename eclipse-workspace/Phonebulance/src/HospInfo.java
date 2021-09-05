import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HospInfo extends searchtable implements ActionListener{
	Font fn1;
	JRadioButton r1,r2;
	public HospInfo() {
		frame=new JFrame("hospital add ");
		fn1=new Font("serif",Font.BOLD,22);
		
		
		//adding label
		name=new JLabel("Hospital Name");
		name.setBounds(50,50,170,30);
		name.setFont(fn1);
		frame.add(name);
		
		location=new JLabel("Location");
		location.setBounds(50,90,170,30);
		location.setFont(fn1);
		frame.add(location);
		
		email=new JLabel("Email");
		email.setBounds(50,130,170,30);
		email.setFont(fn1);
		frame.add(email);
		
		phone=new JLabel("Contact No");
		phone.setBounds(50,250,170,30);
		phone.setFont(fn1);
		frame.add(phone);
		
		phone1=new JLabel("Ambulance No");
		phone1.setBounds(50,210,170,30);
		phone1.setFont(fn1);
		frame.add(phone1);
		
		//adding txt feild
		txt_name=new JTextField();
		txt_name.setBounds(210,50,150,30);
		txt_name.setFont(fn1);
		frame.add(txt_name);
		
		txt_location=new JTextField();
		txt_location.setBounds(210,90,150,30);
		txt_location.setFont(fn1);
		frame.add(txt_location);
		
		txt_email=new JTextField();
		txt_email.setBounds(210,130,150,30);
		txt_email.setFont(fn1);
		frame.add(txt_email);
		
		txt_phone=new JTextField();
		txt_phone.setBounds(210,250,150,30);
		txt_phone.setFont(fn1);
		frame.add(txt_phone);
		
		txt_phone1=new JTextField();
		txt_phone1.setBounds(210,210,150,30);
		txt_phone1.setFont(fn1);
		frame.add(txt_phone1);
		
		button=new JButton("submit");
		button.setBounds(150,300,130,30);
		frame.add(button);
		button.addActionListener(this);
		
		//adding radio button
		r1=new JRadioButton("public");    
		r1.setBounds(270,170,100,30); 
		r1.setFont(fn1);
		//r1.setBackground(Color.ORANGE);
		r2=new JRadioButton("private");    
		r2.setBounds(170,170,100,30);  
		r2.setFont(fn1);
		//r2.setBackground(Color.ORANGE);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);  
		frame.add(r1);frame.add(r2);
		
		
		
		frame.setSize(800,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
     public static void main(String[] args) {
    	 new HospInfo();
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		String fname=txt_name.getText();
		String loc=txt_location.getText();
		String eml=txt_email.getText();
		String phn=txt_phone.getText();
		String phn1=txt_phone1.getText();
		String gen="";
		if(r1.isSelected()){    
			 gen="public";    
			}    
			if(r2.isSelected()){    
			 gen="private";    
			}
		Data db=new Data();
		String query="insert into hospital(Name,location,email,type,phone1,phone2)values('"+fname+"','"+loc+"','"+eml+"','"+gen+"','"+phn+"','"+phn1+"')";
		int ans=db.insert(query);
		if (ans>0) {
			JOptionPane.showMessageDialog(frame," successfully");
			frame.dispose();
			new HomePage();
		}
		
				
		
	}
	
}
