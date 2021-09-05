import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	Connection con;
	Statement st;
	int val;
	ResultSet rows;
	public Data() {
		// register the driver class
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		// create the connection object
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/online_voting","root","Gansi@974111");
			if(con!=null) {
				System.out.println("database is conncted succesfully");
			}
			//creating statement object
			st=con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int insert(String query){
		
		//execute
		try {
			val= st.executeUpdate(query);//to insert
		} catch (SQLException throwables) {
			// TODO Auto-generated catch block
			throwables.printStackTrace();
		}
		return val;
	}
	public ResultSet select(String query) {
		try {
			 rows= st.executeQuery(query);//execute 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
 public static void main(String[] args) {
	 new Data();
 }


}

