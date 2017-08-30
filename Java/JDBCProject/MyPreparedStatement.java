
import java.sql.*;

public class MyPreparedStatement {
	
	public static void main(String[] args) {
		new MyPreparedStatement().go();
	}
	public void go() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("insert into EMP values(?,?,?)");
			stmt.setInt(1, 5);
			stmt.setString(2, "Ricca");
			stmt.setInt(3, 12);
			
			int i = stmt.executeUpdate();
			System.out.println(i + " row executed");
			
			conn.close();
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
