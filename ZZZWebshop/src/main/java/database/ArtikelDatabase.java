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
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM artikel");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artikelListe.add(new Artikel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),rs.getString(5), rs.getString(6)));
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
		return artikelListe;
	}
	
	public static Artikel getArtikel(int artikelId) {
		Artikel artikel = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM artikel WHERE id = ?");
			pstmt.setInt(1, artikelId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artikel = new Artikel(artikelId, rs.getString(2), rs.getInt(3), rs.getDouble(4),rs.getString(5), rs.getString(6));
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
		return artikel;
	}

}
