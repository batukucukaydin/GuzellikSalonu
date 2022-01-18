/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Veritabani {
	  public static Connection baglan() {
	    	Connection c = null;
	        try {
	            Class.forName("org.sqlite.JDBC");
	           c = DriverManager.getConnection("jdbc:sqlite:veritabani.db");  
	        } catch ( Exception e ) {
	           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	           System.exit(0);
	        }
			return c;
	    }
	  public static void KomutCalistir(String komut) {
		  try (Connection conn = Veritabani.baglan();
		            PreparedStatement prepstate = conn.prepareStatement(komut)) 
		        {
		            prepstate.executeUpdate();
		        } catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
	  }
	  public static ArrayList<String> VeriGetir(String sql) {
		  ArrayList<String> veriler = new ArrayList<String>();
		  try {
				Connection con = Veritabani.baglan();
				Statement st=con.createStatement();	
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					veriler.add(rs.getString(1));
				}
				con.close();
				return veriler;
			} catch (SQLException ex) {
				System.out.print(ex.getMessage());
				return null;
			}
	  }
	  public static String TekVeriGetir(String sql) throws SQLException {
			Connection con = Veritabani.baglan();
			String veri="";
		  try {
				Statement st=con.createStatement();	
				ResultSet rs = st.executeQuery(sql);
				if(rs.next())
				{
					veri = rs.getString(1);
				}
				con.close();
			} catch (SQLException ex) {
				con.close();
			}
			return veri;
		  
	  }
	  
	  public static void TabloGoster(JTable table,String sql,String[] sutunlar) {
			DefaultTableModel model = new DefaultTableModel(sutunlar, 0);
			table.setModel(model);
			try {
				Connection conn = Veritabani.baglan();
				Statement stmt=conn.createStatement();	
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					ArrayList<String> row = new ArrayList<String>();
				    for(int i=1;i<=sutunlar.length;i++) {
				    	row.add(rs.getString(i));
				    }
				    model.addRow(row.toArray());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  }
	  public static boolean SayiVarmi(String metin) {
		  boolean sonuc=false;
		  for(char harf:metin.toCharArray()) {
			  if(Character.isDigit(harf)) {
				  sonuc=true;
			  }
		  }
		  return sonuc;
	  }
	  public static boolean HarfVarmi(String metin) {
		  boolean sonuc=false;
		  for(char harf:metin.toCharArray()) {
			  if(Character.isAlphabetic(harf)) {
				  System.out.println(harf);
				  sonuc=true;
			  }
		  }
		  return sonuc;
	  }
}
