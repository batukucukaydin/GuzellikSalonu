/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class HastaKapasitesi {

	public JFrame frame;
	String doktoradi,bolum,tarih;
	private JTable tableRandevu;
	private JLabel lbl1;
	private JLabel lbl2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HastaKapasitesi window = new HastaKapasitesi("","","");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HastaKapasitesi(String doktoradi,String bolum,String tarih) {
		this.doktoradi=doktoradi;
		this.bolum=bolum;
		this.tarih=tarih;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Doktor: "+doktoradi);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 122);
		frame.getContentPane().add(scrollPane);
		
		tableRandevu = new JTable();
		scrollPane.setViewportView(tableRandevu);
		Veritabani.TabloGoster(tableRandevu, "SELECT randevu_tarih,randevu_saati,ad_soyad FROM Hasta WHERE "
				+ "ad_soyad='"+doktoradi+"' AND randevu_bolum='"+bolum+"' AND randevu_tarih='"+tarih+"'", new String[] {"Tarih","Saat","Hasta"});
		
		lbl1 = new JLabel("New label");
		lbl1.setBounds(100, 144, 414, 14);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("New label");
		lbl2.setBounds(100, 166, 414, 14);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Hasta Sayisi:");
		lbl3.setBounds(10, 144, 414, 14);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("Max Kapasite:");
		lbl4.setBounds(10, 166, 414, 14);
		frame.getContentPane().add(lbl4);
		
		try {
			/*lbl1.setText(Veritabani.TekVeriGetir("SELECT COUNT(*) FROM Hasta WHERE "
					+ "ad_soyad='"+doktoradi+"' AND randevu_bolum='"+bolum+"' AND randevu_tarih='"+tarih+"'"));*/
			lbl1.setText(Veritabani.TekVeriGetir(" SELECT kapasite FROM doktor WHERE ad_soyad='"+doktoradi+"'"));
			lbl2.setText(Veritabani.TekVeriGetir(" SELECT max_kapasite FROM doktor WHERE ad_soyad='"+doktoradi+"'"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
