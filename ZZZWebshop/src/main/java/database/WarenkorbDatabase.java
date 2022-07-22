package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import data.Warenkorb;
/**
 * In dieser Klasse wird ein Warenkorb in die Datenbank hinzugefuegt, ge�ndert oder geloescht.
 * @author Fabian Segieth.
 *
 */
public class WarenkorbDatabase {
	
	private static Connection con = null;

	/**
	 * Diese Methode schreibt den aktuellen Warenkorb eines Benutzers in die Datenbank.
	 * @param benutzerId Ermittelt den Nutzer.
	 * @param artikelId Ermittelt den Artikel, der hinzugefuegt wird.
	 * @param menge Die Menge des hinzugefuegtenArtikels.
	 * @return True, falls hinzufuegen erfolgreich war, false sonst.
	 */
	public static boolean fuegeWarenkorb(int benutzerId, int artikelId, int menge) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO warenkorb (benutzerid, artikelid, menge) VALUES(?,?,?)");
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
	
	/**
	 * Gibt den gesamten Warenkorb einen Benutzers aus der Datenbank als ArrayList vom Typ Warenkorb zurueck.
	 * @param benutzerId Warenkorb wird zum Benutzer zugeordnet.
	 * @return ArrayList vom Typ Warenkorb mir aktuellem Warenkorb des Benutezrs.
	 */
	public static ArrayList<Warenkorb> getWarenkorb(int benutzerId) {
		ArrayList<Warenkorb> warenkorb = new ArrayList<Warenkorb>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT artikelid, menge, name, kategorie, preis FROM warenkorb JOIN artikel on artikelid = artikel.id WHERE warenkorb.benutzerid = ? ORDER BY artikel.name");
			pstmt.setInt(1, benutzerId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Warenkorb posten = new Warenkorb();
				posten.setWarenkorbId(benutzerId);
				posten.setId(rs.getInt("artikelid"));
				posten.setMenge(rs.getInt("menge"));
				posten.setName(rs.getString("name"));
				posten.setKategorie(rs.getString("kategorie"));
				posten.setPreis(rs.getDouble("preis"));
				warenkorb.add(posten);
				
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] getWarenkorb() auf Datenbankebene fehlgeschlagen.");
			sqle.printStackTrace();
		} catch (Exception e) {
			
			System.out.println("[ERROR] Unerwarteter Fehler.");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei getWarenkorb() - Verbindung geschlossen?");
			}
		}
		return warenkorb;
	}
	
	/**
	 * Loescht Posten des Warenkorbs eines Nutzers aus der Datenbank.
	 * @param benutzerId Eindeutiger Benutzer zum Warenkorb
	 * @param artikelid Damit wird der Artikel ermittelt, der entfernt wird.
	 * @return True, falls loeschen des Artikels erfolgrecih war, false sonst.
	 */
	public static boolean deletePosten(int benutzerId, int artikelid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM warenkorb WHERE benutzerid = ? AND artikelid = ?");
			pstmt.setInt(1, benutzerId);
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
	
	/**
	 * Aktualisert die Menge eines Artikels im Warenkorb in der Datenbank.
	 * @param menge Neue Menge des Artikels.
	 * @param benutzerId Zugehoeriger Benutzer zum Warenkorb
	 * @param artikelid Id des Artikels, dessen Menge aktuallisiert wird.
	 * @return True wenn update erfolgreich war, false sonst.
	 */

	public static boolean updateMenge(int menge, int benutzerId, int artikelid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("UPDATE warenkorb SET menge = ? WHERE benutzerid = ? AND artikelid = ?");
			pstmt.setInt(1, menge);
			pstmt.setInt(2, benutzerId);
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
