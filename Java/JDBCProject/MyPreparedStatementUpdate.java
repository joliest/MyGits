import java.sql.*;

public class MyPreparedStatementUpdate {
	public static void main(String[] args) {
		new MyPreparedStatementUpdate().go();
	}
	public void go() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("update emp set age=? where name=?");
			stmt.setInt(1, 32);
			stmt.setString(2, "Ri");
			
			int i = stmt.executeUpdate();
			System.out.println(i + "th row updated");

			conn.close();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
