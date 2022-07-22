package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Artikel;

public class ArtikelDatabase {

	private static Connection con = null;

	public static ArrayList<Artikel> getAlleArtikel() {
		ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM artikel ORDER BY id");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artikelListe.add(new Artikel(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));
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
