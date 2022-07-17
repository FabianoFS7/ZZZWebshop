package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Benutzer;

public class RegistriereBenutzer {

	private static Connection con = null;

	public static boolean registriereBenutzer(Benutzer benutzer) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO benutzer VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, 122);//Zähler einrichten
			pstmt.setString(2, benutzer.getVorname());
			pstmt.setString(3, benutzer.getNachname());
			pstmt.setString(4, benutzer.getEmail());
			pstmt.setString(5, benutzer.getPasswort());
			pstmt.setString(6, benutzer.getStrasse());
			pstmt.setString(7, benutzer.getHausnummer());
			pstmt.setInt(8, benutzer.getPostleitzahl());
			pstmt.setString(9, benutzer.getOrt());
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
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
