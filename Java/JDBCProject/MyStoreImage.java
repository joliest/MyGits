import java.sql.*;
import java.io.*;

public class MyStoreImage {
	public static void main(String[] args) {
		
		try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
		
		FileInputStream stream = new FileInputStream("C:\\Users\\Joliver-PC\\Desktop\\New folder\\image01.png");
		
		PreparedStatement stmt = conn.prepareStatement("insert into IMGTBL values(?,?)");
		stmt.setString(1, "MyImage");		
		stmt.setBinaryStream(2, stream, stream.available());
		
		int i = stmt.executeUpdate();
		System.out.println(i + " image uploaded");
		
		conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
