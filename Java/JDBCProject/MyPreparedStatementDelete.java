import java.sql.*;

public class MyPreparedStatementDelete {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("delete from emp where name=?");
			stmt.setString(1, "Ri");
			
			int i = stmt.executeUpdate();
			System.out.println(i + " deleted row");
			
			conn.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
	
