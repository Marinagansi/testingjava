import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class searchtable  {
	

	JFrame frame1,frame;
	JTextField textbox,txt_name,txt_location,txt_email,txt_phone,txt_phone1,txt_code,txt_type,txt_phone2;
	JLabel label,name,location,email,type,phone,phone1,code,phone2;
	Font fn;
	JButton button,button2,button1,button3;
	
	JPanel panel;
	
	JComboBox<String> j4;
	static JTable table;
	
	String[] columnNames = {"name", "Location", "email", "type","phone","anbulane No"};
	String[] column= {"place","name","Ambulance no1","Ambulance no2","emergency call"};
}

