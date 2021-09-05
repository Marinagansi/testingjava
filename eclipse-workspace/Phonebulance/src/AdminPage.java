import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class AdminPage  implements ActionListener{
   JFrame frame1;
   JButton add_candidate,view_result,add_election;
   JTable tbl;
   JPanel pn;
   String columnNames[]= {"code","location","name","phone1","ambulance"} ;
    public AdminPage(){
    	frame1=new JFrame();
    	
    	
    	add_candidate=new JButton("Add candidate");
    	add_candidate.setBounds(100,110,150,40);
    	frame1.add(add_candidate);
    	add_candidate.addActionListener(this);
    	
    	view_result=new JButton("View Result");
    	view_result.setBounds(100,160,150,40);
    	view_result.addActionListener(this);
    	frame1.add(view_result);
    	
    	add_election=new JButton("Add Election");
    	add_election.setBounds(100,210,150,40);
    	frame1.add(add_election);
    	
    	// creating model 
//    	DefaultTableModel mdl=new DefaultTableModel();
//    	mdl.setColumnIdentifiers(columnNames);
//    	tbl=new JTable(data,column);
//    	tbl.setModel(mdl);
//    	
//    	
//    	tbl.setBounds(200,10,450,400);
//    	tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//    	tbl.setFillsViewportHeight(true);
//    	JScrollPane scroll1=new JScrollPane(tbl);
//    	scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//    	scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//    	
    	String name="";
    	String add="";
    	String mail="";
    	
    	try {
    		Data d1=new Data();
    		String qry="select * from register";
    		ResultSet Rr=d1.select(qry);
    	   ResultSetMetaData rsmt=(ResultSetMetaData) Rr.getMetaData();
    		int c=rsmt.getColumnCount();
    		Vector column=new Vector(c);
    		for(int i=1;i<=c;i++) {
    			column.add(rsmt.getColumnName(i));	
    		}
    		Vector data=new Vector();
    		Vector row=new Vector();
    		while(Rr.next())
    		{
    			row=new Vector(c);
    			for(int i=1;i<=c;i++) {
    				row.add(Rr.getString(i));
    			}
    			data.add(row);
    		}
    		pn=new JPanel();
    		DefaultTableModel mdl=new DefaultTableModel();
//        	mdl.setColumnIdentifiers(columnNames);
        	tbl=new JTable(data,column);
        	
        	
        	
        	pn.setBounds(200,10,450,400);
        	tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        	tbl.setFillsViewportHeight(true);
        	JScrollPane scroll1=new JScrollPane(tbl);
        	scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        	scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        	pn.setLayout(new BorderLayout());
        	pn.add(scroll1,BorderLayout.CENTER);
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	
    	
    
    	frame1.setSize(800,500);
    	frame1.setLayout(null);
    	frame1.setVisible(true);
	   
   }
   public static void main(String[] args) {
	   new AdminPage();
   }
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()==add_candidate) {
		new AddContact();
	}
	if (e.getSource()==view_result) {
		String query="select * from register";
		Data db=new Data();
		ResultSet rs=db.select(query);
		}
	
	
}
}
