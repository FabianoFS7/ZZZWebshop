package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Bestellung;
import data.Warenkorb;
/**
 * In dieser Klasse holen wir uns Daten ueber die Bestellung aus der Datenbank.
 * @author Fabian Segieth
 *
 */
public class BestellungDatabase {
	
	private static Connection con = null;

	/**
	 * Schreibt eine Bestellung in die Datenbank.
	 * @param warenkorb Warenkorbobjekt.
	 * @param zahlungsmethode Zahlungsmethode der Bestellung.
	 * @param bestellid eindeutige Id der Bestellung.
	 * @return True, falls Eintrag in die Datenbank erfolgreich war, false sont.
	 */
	public static boolean fuegeBestellung(Warenkorb warenkorb, String zahlungsmethode, int bestellid) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO bestellungen (nummer, benutzerid, artikelid, menge, zahlungsmethode) VALUES(?,?,?,?,?)");
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
	
	/**
	 * Ermittelt die hoechste Bestell-Id in der Datenbank.
	 * @param Zuordnung zum Benutzer
	 * @return Hoechste Benutzer-Id.
	 */
	public static int hoechsteBestellid(int benutzerId) {
		int id = 1;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT id FROM bestellungen WHERE benutzerid = ? ORDER BY id DESC LIMIT(1)");
			pstmt.setInt(1, benutzerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] hoechsteBestellid");
		}

		return id;
	}
	
	/**
	 * Diese Methode gibt alle Bestellungen innerhalb einer grossen Bestellung mit der selben Bestellid
	 *  eines genauen Benutzers als Liste zurueck.
	 * @param benutzerId Identifikation Benutezr.
	 * @param bestellId Bestellungen mit der selben Id bilden eine gesamte Bestellung.
	 * @return ArrayList vom Typ Bestellung mit allen Bestellungen.
	 */
	public static ArrayList<Bestellung> getBestellungen(int benutzerId, int bestellId) {
		ArrayList<Bestellung> bestellungen = new ArrayList<Bestellung>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT bestellungen.id, bestellungen.menge, bestellungen.bestellt_am, artikel.name, artikel.preis "
							+ "FROM bestellungen JOIN artikel on artikelid = artikel.id  "
							+ "WHERE benutzerid = ? AND bestellungen.nummer = ?");
			pstmt.setInt(1, benutzerId);
			pstmt.setInt(2, bestellId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Bestellung posten = new Bestellung();
				posten.setBestellId(rs.getInt("id"));
				posten.setMenge(rs.getInt("menge"));
				posten.setBestellDatum(rs.getString("bestellt_am"));
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
	
	/**
	 * Gibt bestellids aller Bestellungen eines Benutzers zurueck, um alle Bestellungen zu ermitteln. 
	 * @param benutzerId Zugehoerigkeit von Bestellung zu Benutzer.
	 * @return Alle Bestellnummern von kompletten Bestellugnen eines Benutzers.
	 */
	public static List<Integer> getBestellnummern(int benutzerId) {
		List<Integer> bestellnummern = new ArrayList<Integer>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT DISTINCT nummer from bestellungen WHERE benutzerid = ? order by nummer DESC");
			pstmt.setInt(1, benutzerId);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bestellnummern.add(rs.getInt("nummer"));
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
