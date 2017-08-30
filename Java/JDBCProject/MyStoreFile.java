import java.sql.*;
import java.io.*;

public class MyStoreFile {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			File f = new File("C:\\Users\\Joliver-PC\\Desktop\\adrian.xlsx");
			FileReader fr = new FileReader(f);
			
			PreparedStatement stmt = conn.prepareStatement("insert into FILETABLE values(?,?)");
			stmt.setInt(1, 103);
			stmt.setCharacterStream(2, fr, (int) f.length());

			int i = stmt.executeUpdate();
			System.out.println(i + " file uploaded");			
			
			conn.close();
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
