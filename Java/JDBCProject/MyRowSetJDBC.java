import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;

public class MyRowSetJDBC {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//creating JdbcRowSet object and establish connection using setters
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rowSet.setUsername("system");
		rowSet.setPassword("Sql12345");
		
		//write the query
		rowSet.setCommand("select * from emp");
		rowSet.execute();
		
		while(rowSet.next()) {
			System.out.print(" ID: " + rowSet.getString(1));
			System.out.print(" Name: " + rowSet.getString(2));
			System.out.println(" Age: " + rowSet.getString(3));
		}
		
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
}
