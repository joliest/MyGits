import java.sql.*;
import java.io.*;

public class MyRetriveFile {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("select * from filetable");
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();
			
			FileWriter fw = new FileWriter("C:\\Users\\Joliver-PC\\Desktop\\Store\\a.xlsx");
			
			int i;
			while((i=r.read()) != -1) {
				fw.write((char) i );
			}
			System.out.println("Successfully!");
			
			fw.close();
			conn.close();
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
