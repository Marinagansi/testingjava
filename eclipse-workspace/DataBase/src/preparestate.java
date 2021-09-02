import java.sql.*;
public class preparestate {
	public static void main(String[] args) throws SQLException {
	String url="jdbc:mysql://127.0.0.1:3306/demo";
	String user="root";
	String password="Gansi@974111";
	

	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;

	try {
		//1.get a connection to database
		myConn=DriverManager.getConnection(url,user,password);
		
		//2prepare a statement
		myStmt=myConn.prepareStatement("select*from employee where salary<=? and department=? ");
		
		//3.set the parameter
		myStmt.setDouble(1,5000);
		myStmt.setString(2,"legal");
		
		//.execute sQl query
		myRs=myStmt.executeQuery();
		
		//5.Display the result set
		display(myRs);
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	 finally {
		 if (myRs !=null) {
			 myRs.close();
		 }
		 if(myStmt!=null) {
			 myStmt.close();
		 }
		 if (myConn!=null) {
			 myConn.close();
		 }
	 }
	} 


private static void display(ResultSet myRs) throws SQLException{
	// TODO Auto-generated method stub
	while (myRs.next()) {
	String lastName = myRs.getString("lname");
	String firstName = myRs.getString("fname");
	double salary = myRs.getDouble("salary");
	String department = myRs.getString("department");
			System.out.printf("%s, %s,%.2f,%s\n", lastName, firstName,salary,department);
}
}
}
