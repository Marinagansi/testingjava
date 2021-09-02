import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
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
			String sql="update  employee set email='434@gmail.com' where fname='ram'";
			
			
			myStmt.executeUpdate(sql);
			System.out.println("update completed");
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
