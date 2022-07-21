package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Benutzer;

public class RegistriereBenutzer {

	private static Connection con = null;

	public static Benutzer registriereBenutzer(Benutzer benutzer) {

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO benutzer (vorname, nachname, email, passwort, strasse, hausnummer, plz, ort, admin) VALUES (?,?,?,?,?,?,?,?,false)");
			pstmt.setString(1, benutzer.getVorname());
			pstmt.setString(2, benutzer.getNachname());
			pstmt.setString(3, benutzer.getEmail());
			pstmt.setString(4, benutzer.getPasswort());
			pstmt.setString(5, benutzer.getStrasse());
			pstmt.setString(6, benutzer.getHausnummer());
			pstmt.setInt(7, benutzer.getPostleitzahl());
			pstmt.setString(8, benutzer.getOrt());
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                benutzer.setId(generatedKeys.getInt(1));
	    			System.out.println("[INFO] BenutzerId: " + generatedKeys.getInt(1));
	            } else {
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
		return benutzer;
	}

}
