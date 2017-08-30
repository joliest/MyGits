import java.sql.*;

public class MyResultSetMetaData {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("select * from emp");
			
			ResultSet rs = stmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			System.out.println("Column Count : " + metaData.getColumnCount() );
			System.out.println("Name of the second column is : " + metaData.getColumnName(2));
			System.out.println("Type of the second column is : " + metaData.getColumnTypeName(2));
			
			conn.close();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
