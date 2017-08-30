import java.sql.*;

public class Hello {
	public static void main(String[] args) {
		new Hello().go();
	}
	
	public void go() {
		try {
		//Register the driver class. 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Create a Connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Sql12345");
		
		//Create a statement
		Statement stmt = con.createStatement();
		
		//Create a ResultSet object to execute the statement
		ResultSet rs = stmt.executeQuery("select * from emp");

		//dont forget rs.next() and get the value of the column
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}

		//close the connection
		con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
}
