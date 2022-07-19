package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Warenkorb;

public class BestellungDatabase {
	
	private static Connection con = null;

	public static boolean fuegeBestellung(Warenkorb warenkorb, String zahlungsmethode) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO bestellungen VALUES(?,?,?,?,?)");
			pstmt.setInt(1, 1);//Zähler einrichten
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

}
