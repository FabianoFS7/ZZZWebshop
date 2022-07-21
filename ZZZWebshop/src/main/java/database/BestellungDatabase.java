package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Bestellung;
import data.Warenkorb;

public class BestellungDatabase {
	
	private static Connection con = null;

	public static boolean fuegeBestellung(Warenkorb warenkorb, String zahlungsmethode, int bestellid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO bestellungen VALUES(?,?,?,?,?)");
			pstmt.setInt(1, bestellid);
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
	
	public static ArrayList<Bestellung> getBestellungen(int benutzerId, int bestellId) {
		ArrayList<Bestellung> bestellungen = new ArrayList<Bestellung>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT bestellungen.id, bestellungen.menge, bestellungen.bestellt_am, artikel.name, artikel.preis "
							+ "FROM bestellungen JOIN artikel on artikelid = artikel.id  "
							+ "WHERE benutzerid = ? AND bestellungen.id = ?");
			pstmt.setInt(1, benutzerId);
			pstmt.setInt(2, bestellId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Bestellung posten = new Bestellung();
				posten.setBestellId(rs.getInt("id"));
				posten.setMenge(rs.getInt("menge"));
				posten.setBestelltAm(rs.getString("bestellt_am"));
				posten.setName(rs.getString("name"));				
				posten.setPreis(rs.getDouble("preis"));
				bestellungen.add(posten);
				
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] getBestellungen auf Datenbankebene fehlgeschlagen.");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei getBestellungen() - Verbindung geschlossen?");
			}
		}
		return bestellungen;
	}
	
	public static ArrayList<Integer> getBestellnummern(int benutzerId) {
		ArrayList<Integer> bestellnummern = new ArrayList<Integer>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT DISTINCT id from bestellungen WHERE benutzerid = ? order by id DESC");
			pstmt.setInt(1, benutzerId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bsNummer = rs.getInt("id");
				bestellnummern.add(bsNummer);
				
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] getBestellnummern auf Datenbankebene fehlgeschlagen.");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei getBestellnummern() - Verbindung geschlossen?");
			}
		}
		return bestellnummern;
	}

}
