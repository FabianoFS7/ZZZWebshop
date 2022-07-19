package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import data.Warenkorb;

public class WarenkorbDatabase {
	
	private static Connection con = null;

	public static boolean fuegeWarenkorb(int benutzerId, int artikelId, int menge) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO warenkorb VALUES(?,?,?)");
			pstmt.setInt(1, benutzerId);
			pstmt.setInt(2, artikelId);
			pstmt.setInt(3, menge);
			
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
			}					
			
		} catch (SQLException e) {
			System.err.println("[SQL] Fehler bei fuegeWarenkorb()" + e.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei fuegeWarenkorb() - Verbindung geschlossen?");
			}
		}
		return erfolg;
	}
	
	public static ArrayList<Warenkorb> getWarenkorb(int benutzerId) {
		ArrayList<Warenkorb> warenkorb = new ArrayList<Warenkorb>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM warenkorb JOIN artikel on artikelid = artikel.id WHERE warenkorb.id = ?");
			pstmt.setInt(1, benutzerId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Warenkorb posten = new Warenkorb();
				posten.setWarenkorbId(benutzerId);
				posten.setId(rs.getInt("artikelId"));
				posten.setMenge(rs.getInt("menge"));
				posten.setName(rs.getString("name"));
				posten.setKategorie(rs.getString("kategorie"));
				posten.setPreis(rs.getDouble("preis"));
				warenkorb.add(posten);
				
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
				System.err.println("[SQL] Fehler bei registriereBenutzer() - Verbindung geschlossen?");
			}
		}
		return warenkorb;
	}
	
	public static boolean deletePosten(int warenkorbid, int artikelid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("DELETE FROM warenkorb WHERE id = ? AND artikelid = ?");
			pstmt.setInt(1, warenkorbid);
			pstmt.setInt(2, artikelid);
			
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
			}	
		} catch (SQLException e) {
			System.err.println("[SQL] Fehler bei deletePosten()" + e.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei deletePosten() - Verbindung geschlossen?");
			}
		}
		return erfolg;
	}
	
	public static boolean updateMenge(int menge, int warenkorbid, int artikelid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("UPDATE warenkorb SET menge = ? WHERE id = ? AND artikelid = ?");
			pstmt.setInt(1, menge);
			pstmt.setInt(2, warenkorbid);
			pstmt.setInt(3, artikelid);
			
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
			}	
		} catch (SQLException e) {
			System.err.println("[SQL] Fehler bei updateMenge()" + e.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei updateMenge() - Verbindung geschlossen?");
			}
		}
		return erfolg;
	}
	

}