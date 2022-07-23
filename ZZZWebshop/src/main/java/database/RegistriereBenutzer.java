package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Benutzer;

/**
 * In der Klasse wird ein sich registrierender Benutzer in die Datenbank
 * geschrieben.
 * 
 * @author Fabian Segieth
 *
 */
public class RegistriereBenutzer {

	private static Connection con = null;

	/**
	 * Schreibt einen Benutzer nach erfolgreicher Registrierung in die Datenbank und
	 * gibt ein Benutzrrobjekt zurueck.
	 * 
	 * @param benutzer Benutzerobjekt fuer Registrierung.
	 * @return Benutzerobjekt nach erfolreicher Registrierung.
	 */
	public static boolean registriereBenutzer(Benutzer benutzer) {
		boolean erfolg = false;
		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO benutzer (vorname, nachname, email, passwort, strasse, hausnummer, plz, ort, admin) VALUES (?,?,?,?,?,?,?,?,false)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, benutzer.getVorname());
			pstmt.setString(2, benutzer.getNachname());
			pstmt.setString(3, benutzer.getEmail());
			pstmt.setString(4, benutzer.getPasswort());
			pstmt.setString(5, benutzer.getStrasse());
			pstmt.setString(6, benutzer.getHausnummer());
			pstmt.setInt(7, benutzer.getPostleitzahl());
			pstmt.setString(8, benutzer.getOrt());
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					benutzer.setId(rs.getInt(1));
					erfolg = true;
				} else {
					System.out.println("[SQL] Unerwarteter Fehler.");
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			System.err.println("[SQL] Fehler bei registriereBenutzer()" + e.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei registriereBenutzer() - Verbindung geschlossen?");
			}
		}
		return erfolg;
	}

}
