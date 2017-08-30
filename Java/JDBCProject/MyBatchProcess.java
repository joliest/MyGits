import java.sql.*;

public class MyBatchProcess {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();			
			stmt.addBatch("insert into emp values(15, 'Marty', 24)");
			stmt.addBatch("insert into emp values(12, 'Artha', 89)");
			
			stmt.executeBatch();
			System.out.println("batch process success");
			
			conn.commit();
			conn.close();			
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
