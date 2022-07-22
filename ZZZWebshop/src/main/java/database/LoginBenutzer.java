package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Benutzer;
/**
 * Klasse, um den Login eines Benutzers mit der Datenbank abzugleichen.
 * @author Fabian Segieth
 *
 */
public class LoginBenutzer {
	
	private static Connection con = null;
	
	/**
	 * Prueft, ob in der Datenbank die Kombination aus eingebener Email und Passwort, vorhanden ist.
	 * Wenn dies der Fall ist, wird Login gewahrt und das Benutezrobjekt zurueck gegeben.
	 * @param email Email des Nutzers.
	 * @param passwort Passwort des Nutzers.
	 * @return Eingeloggter Benutzer.
	 */
	public static Benutzer loginBenutzer(String email, String passwort) {
		Benutzer benutzer = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM benutzer WHERE email = ? AND passwort = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, passwort);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				benutzer = new Benutzer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getInt(8), rs.getString(9), rs.getBoolean(10));
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] Login auf Datenbankebene fehlgeschlagen.");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei loginBenutzer() - Verbindung geschlossen?");
			}
		}
		return benutzer;
	}

}
