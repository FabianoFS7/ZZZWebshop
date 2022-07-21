package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Warenkorb;

public class BestellungDatabase {
	
	private static Connection con = null;

	public static boolean fuegeBestellung(Warenkorb warenkorb, String zahlungsmethode, int bestellid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO bestellungen VALUES(?,?,?,?,?)");
			pstmt.setInt(1, bestellid);//Z�hler einrichten
			pstmt.setInt(2, warenkorb.getWarenkorbId());
			pstmt.setInt(3, warenkorb.getId());
			pstmt.setInt(4, warenkorb.getMenge());
			pstmt.setString(5, zahlungsmethode);			
 
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
			}					
			
		} catch (SQLException e) {
			System.err.println("[SQL] Fehler bei fuegeBestellung()" + e.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei fuegeBestellung() - Verbindung geschlossen?");
			}
		}
		return erfolg;
	}
	
	public static int hoechsteBestellid(int benutzerid) {
		int id = 1;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT id FROM bestellungen WHERE benutzerid = ? ORDER BY id DESC LIMIT(1)");
			pstmt.setInt(1, benutzerid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] hoechsteBestellid");
		}

		return id;
	}

}
