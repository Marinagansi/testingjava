import java.sql.*;
public class insertdata {
	public static void main(String[]args) {
		String url="jdbc:mysql://127.0.0.1:3306/demo";
		String user="root";
		String password="Gansi@974111";
		try {
			//1.get a connection to database
			Connection myConn=DriverManager.getConnection(url,user,password);
			
			//2.create a statement
			Statement myStmt=myConn.createStatement();
			//.Execute sql query
			String sql="insert into employee"
				+"(fname,lname,email)"
				+"values('brown','David','david.brown@gmail.com')";
			
			myStmt.executeUpdate(sql);
			System.out.println("insert completed");
			
			String l="insert into employee"
					+"(id,fname,lname,email)"
					+"values(5,'neema','kc','dn.sn@gmail.com')";
			myStmt.executeUpdate(l);
			System.out.println("insert completed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
