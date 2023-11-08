package stepDefinitions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	private Connection connection;
	private final String host;
	private final String username;
	private final String password;
	
	public JdbcConnection() throws SQLException {
		this.host = "jdbc:mysql://localhost:3306/geckocc";
		this.username = "root";
		this.password = "TravisMong666";
		this.connection = DriverManager.getConnection(host, username, password);
	}
	
	public int getTableSize(String tableName) throws SQLException {
		String query = "SELECT COUNT(*) FROM " + tableName;
		ResultSet resultSet = connection.createStatement().executeQuery(query);
		resultSet.next();
    return Integer.parseInt(resultSet.getString(1));
	}
	
	public void shutDown() throws SQLException {
		connection.close();
	}

	public void emptyTable(String tableName) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("SET SQL_SAFE_UPDATES = 0;");
		
		String deleteQuery = "DELETE FROM " + tableName;
		int rowsAffected = statement.executeUpdate(deleteQuery);
		System.out.println("Deleted " + rowsAffected + " rows from the document verification table.");
		
		statement.executeUpdate("SET SQL_SAFE_UPDATES = 1;");
		statement.close();
	}
	

}
