import java.sql.*;
import java.io.*;

public class MyRetrieveImage {
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sql12345");
			
			PreparedStatement stmt = conn.prepareStatement("select * from imgtbl");

			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Blob blob = rs.getBlob(2);
				byte imgByt[] = blob.getBytes(1, (int) blob.length()); //long pos, int length
				
				//name it as retrievedImage
				FileOutputStream stream = new FileOutputStream("C:\\Users\\Joliver-PC\\Desktop\\Output\\retrievedImage.png");
				stream.write(imgByt);
				System.out.println("Image was retrieved!");
			}
			
			conn.close();
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
