import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class AddContact extends searchtable implements ActionListener  {
    JPanel panel;
	JRadioButton r1,r2;
	DefaultTableModel model;
	JScrollPane scroll;
	
	
	String name1,loc,phn,phn1,phn2;
	
	public AddContact() {
		frame=new JFrame();
		frame.getContentPane().setBackground(Color.orange);
		fn=new Font("serif",Font.BOLD,22);
		
		
		
				
		//adding label
		code=new JLabel("code");
		code.setBounds(20,70,150,30);
		code.setFont(fn);
		frame.add(code);
		
		name=new JLabel("Hospital Name");
		name.setBounds(20,110,150,40);
		name.setFont(fn);
		frame.add(name);
		
		location=new JLabel("Location");
		location.setBounds(20,150,150,40);
		location.setFont(fn);
		frame.add(location);
		
		phone1=new JLabel("contact");
		phone1.setBounds(20,190,150,40);
		phone1.setFont(fn);
		frame.add(phone1);
		
		phone=new JLabel("ambulance");
		phone.setBounds(20,230,150,40);
		phone.setFont(fn);
		frame.add(phone);
		
		phone2=new JLabel("emergency call");
		phone2.setBounds(20,260,150,40);
		phone2.setFont(fn);
		frame.add(phone2);
		
		
		
		//adding textfield
		txt_code=new JTextField();
		txt_code.setBounds(170,70,150,30);
		txt_code.setFont(fn);
		frame.add(txt_code);
		
		txt_name=new JTextField();
		txt_name.setBounds(170,110,150,30);
		txt_name.setFont(fn);
		frame.add(txt_name);
		
		txt_location=new JTextField();
		txt_location.setBounds(170,150,150,30);
		txt_location.setFont(fn);
		frame.add(txt_location);
		
		txt_phone1=new JTextField();
		txt_phone1.setBounds(170,190,150,30);
		txt_phone1.setFont(fn);
		frame.add(txt_phone1);
		
		txt_phone=new JTextField();
		txt_phone.setBounds(170,230,150,30);
		txt_phone.setFont(fn);
		frame.add(txt_phone);
		
		txt_phone2=new JTextField();
		txt_phone2.setBounds(170,270,150,30);
		txt_phone2.setFont(fn);
		frame.add(txt_phone2);
		
		
		//adding radio button
		r1=new JRadioButton("private");    
		r1.setBounds(20,300,100,30); 
		r1.setFont(fn);
		
		r2=new JRadioButton("public");    
		r2.setBounds(130,300,100,30);  
		r2.setFont(fn);
		;
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);  
		frame.add(r1);frame.add(r2);
		
		//adding button
		button=new JButton("submit");
		button.setBounds(300,370,170,30);
		button.setFont(fn);
		frame.add(button);
		button.addActionListener(this);
		
		button1=new JButton("update");
		button1.setBounds(80,370,170,30);
		button1.setFont(fn);
		frame.add(button1);
		button1.addActionListener(this);
		
		button2=new JButton("delete");
		button2.setBounds(80,410,170,30);
		button2.setFont(fn);
		frame.add(button2);
		button2.addActionListener(this);
		
		//adding panel for data
				panel=new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
				panel.setBounds(10,400,400,300);
				
				//adding table
			    model=new DefaultTableModel();
				model.setColumnIdentifiers(column);
				table =new JTable();
				table.setModel(model);
				model.setRowCount(0);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
				JScrollPane scroll=new JScrollPane(table);
				scroll.setHorizontalScrollBarPolicy(
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
			
				
				String code="";
				String place="";
				String name1="";
				String phon1="";
				String phon2="";
				String phon3="";
				try
				{
					String query2="select *  from addcontact";
					Data table1=new Data();
					ResultSet rs2=table1.select(query2);
					
					
					int i=0;
					
					while(rs2.next()) {
						code=rs2.getString("code");
						place=rs2.getString("location");
						name1=rs2.getString("Name");
						phon1=rs2.getString("phone1");
						phon2=rs2.getString("phone2");
						phon3=rs2.getString("phone3");
						model.addRow(new Object[] {place,name1,phon1,phon2,phon3});
						i++;
						
						
						
					}
					

				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			
				
				
				table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						int j =table.getSelectedRow();
						TableModel model=table.getModel();
//						txt_code.setText(model.getValueAt(j,0).toString());
						txt_name.setText(model.getValueAt(j,0).toString());
						txt_location.setText(model.getValueAt(j,1).toString());
						txt_phone.setText(model.getValueAt(j,3).toString());
						txt_phone2.setText(model.getValueAt(j,4).toString());
						txt_phone1.setText(model.getValueAt(j,2).toString());
						
						
					}
					
				});
				
			  
		panel.add(scroll);
		
		frame.add(panel);
		frame.setSize(900,500);
//		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void clear() {
		//clear textfield
		txt_name.setText("");
		txt_location.setText("");
		txt_code.setText("");
		txt_phone1.setText("");
		txt_phone.setText("");
		txt_phone2.setText("");
	}
	
	public static void main(String[]args) {
		new AddContact();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//to insert data
		if(e.getSource()==button) {
		String name=txt_name.getText();
		String loc=txt_location.getText();
		String code=txt_code.getText();
		String phn=txt_phone1.getText();
		String phn1=txt_phone.getText();
		String phn2=txt_phone2.getText();
		String gen="";
		if(r1.isSelected()){    
			 gen="private";    
			}    
			if(r2.isSelected()){    
			 gen="public";    
			}
		Data db=new Data();
		String query="insert into addcontact(code,location,Name,phone1,phone2,phone3)values('"+code+"','"+loc+"','"+name+"','"+phn+"','"+phn1+"','"+phn2+"')";
		int ans=db.insert(query);
		
		if (ans>0) {
			JOptionPane.showMessageDialog(frame," successfully");
			clear()
			;
			
		
			
			
			
//			frame.dispose();
//			new HomePage();
		}
	}
		//to delete
		
		
		
	

}
}
