import java.sql.*;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1.get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","Gansi@974111");
		  //2create a statement
			Statement myState= myConn.createStatement();
			
			//3.execute sql query
			ResultSet myRs=myState.executeQuery("select*from employee");
			//4.process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("lname")+","+myRs.getString("fname"));
			}
			}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
