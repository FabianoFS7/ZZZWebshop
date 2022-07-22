package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Klasse um die Verbindung zur SQL-Datenbank zu erstellen
 * Diese Klasse wurde aus dem Learnweb uebernommen.
 * @author Jan Sarstedt
 */
public class DatabaseConnection {
	
	protected static Connection con;
	private static final String DB_SERVER = "207.154.234.136:5432";
	private static final String DB_NAME = "2022-PuppieDeluxe";
	private static final String DB_USER = "2022-PuppieDeluxe";
	private static final String DB_PASSWORD = "3c3ba10408cc06f68b76c9b001734c57";
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://" + DB_SERVER + "/" + DB_NAME;

	/** Initialisiere eine Verbindung zur Datenbank 
	 * @throws SQLException */
	private static Connection init() throws SQLException {
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			return con;
			
		} catch (ClassNotFoundException cfe) {
			System.out.println(
				"PostgresDb: Treiber konnte nicht gefunden werden. \n"
				+ "Fuegen Sie die postgresql.jar in WEB-INF/lib ein!");
			cfe.printStackTrace();
		}
		return null;
	}

	/** Rufe eine Verbindung auf, wenn eine bereits existiert. Wenn nicht, rufe init() auf 
	 * @throws SQLException */
	public static Connection getConnection() throws SQLException {
		try {
			return (con == null || con.isClosed()) ? init() : con;
		} catch (SQLException e) {
			e.printStackTrace();
			return init();
		}
	}

	/** Schliesse die Verbindung */
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}