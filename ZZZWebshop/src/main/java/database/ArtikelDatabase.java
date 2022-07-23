package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Artikel;

/**
 * In dieser Klasse holen, veraendern und loeschen wir Daten ueber den Artikel aus der Datenbank.
 * @author Eve-Marie Hellmer
 * @author Fabian Segieth
 */
public class ArtikelDatabase {

	private static Connection con = null;

	/**
	 * Hier speichern wir alle Artikel aus der Datenbank in einer Array List vom Typ Artikel.
	 * @return ArrayList vom Typ Artikel, mit allen Artikeln.
	 */
	public static ArrayList<Artikel> getAlleArtikel() {
		ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM artikel ORDER BY id");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artikelListe.add(new Artikel(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6)
						));
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] Fehler bei getAlleArtikel().");
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
		return artikelListe;
	}

	/**
	 * Gibt einen einzelnen Artikel anhand der Artikel-Id zurueck.
	 * @param artikelId Eindeutige Id zum identifizieren des Artikels.
	 * @return Artikelobjekt mit der eingebenen Id.
	 */
	public static Artikel getArtikel(int artikelId) {
		Artikel artikel = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM artikel WHERE id = ?");
			pstmt.setInt(1, artikelId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artikel = new Artikel(artikelId, rs.getString(2), rs.getDouble(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
		} catch (SQLException sqle) {
			System.err.println("[ERROR] Fehler bei getArtikel(): " + sqle.toString());
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler: " + e.toString());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler getArtikel() - Verbindung geschlossen?");
			}
		}
		return artikel;
	}

	/**
	 * Diese Methode veraendert einen Artikeldatensatz.
	 * @param artikel Artikelobjekt, das geaendert wird.
	 * @return Gibt den geaenderten Artikel zurueck.
	 */
	public static Artikel updateArtikel(Artikel artikel) {
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("UPDATE artikel SET name=?, bild=?, preis=?, beschreibung=?, kategorie=? WHERE id=?");
			pstmt.setString(1, artikel.getName());
			pstmt.setString(2, artikel.getBild());
			pstmt.setDouble(3, artikel.getPreis());
			pstmt.setString(4, artikel.getBeschreibung());
			pstmt.setString(5, artikel.getKategorie());
			pstmt.setInt(6, artikel.getId());
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("[SQL] Fehler bei updateArtikel(): " + sqle.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler: " + e.toString());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei updateArtikel() - Verbindung geschlossen?");
			}
		}
		return artikel;
	}

	/**
	 * Mit dieser Methode wird ein Artikelobjekt in die Datenbank geschrieben.
	 * @param artikel Artikel, der in die Datenbank geschrieben wird.
	 * @return artikel Artikel, mit Id welcher in der Datnbank generiert wurde.
	 */
	public static Artikel addArtikel(Artikel artikel) {
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO artikel (name, preis, beschreibung, kategorie, bild) VALUES(?,?,?,?,?)");
			pstmt.setString(1, artikel.getName());
			pstmt.setDouble(2, artikel.getPreis());
			pstmt.setString(3, artikel.getBeschreibung());
			pstmt.setString(4, artikel.getKategorie());
			pstmt.setString(5, artikel.getBild());
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                artikel.setId(generatedKeys.getInt(1));
	            } else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
		} catch (SQLException sqle) {
			System.err.println("[SQL] Fehler bei updateArtikel(): " + sqle.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler: " + e.toString());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei updateArtikel() - Verbindung geschlossen?");
			}
		}
		return artikel;
	}
	
	/**
	 * Damit wird ein Artikel aus der Datenbank geloescht.
	 * @param artikel Artikel, der geloescht wird.
	 * @return artikel Artikel, der geloescht wurde.
	 */
	public static Artikel deleteArtikel(Artikel artikel) {
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM artikel WHERE id=?");
			pstmt.setInt(1, artikel.getId());
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("[SQL] Fehler bei deleteArtikel()" + sqle.toString());
		} catch (Exception e) {
			System.out.println("[ERROR] Unerwarteter Fehler: " + e.toString());
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("[SQL] Fehler bei deleteArtikel() - Verbindung geschlossen?");
			}
		}
		return artikel;
	}

}
