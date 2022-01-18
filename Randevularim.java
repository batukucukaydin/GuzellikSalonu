/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Randevularim {

	public JFrame frmRandevularim;
	private JTable randevuTable;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Randevularim window = new Randevularim();
					window.frmRandevularim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Randevularim() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRandevularim = new JFrame();
		frmRandevularim.setTitle("Randevularim");
		frmRandevularim.setBounds(100, 100, 755, 300);
		frmRandevularim.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmRandevularim.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 719, 212);
		frmRandevularim.getContentPane().add(scrollPane);
		
		randevuTable = new JTable();
		scrollPane.setViewportView(randevuTable);
		Veritabani.TabloGoster(randevuTable, "SELECT id,ad_soyad,randevu_tarih,randevu_saati,randevu_doktor,randevu_bolum FROM Hasta", 
				new String[] {"#","Ad Soyad","Tarih","Saat","Doktor","Bolum"});
		
		btnNewButton = new JButton("Sil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(randevuTable.getSelectedRow()>=0) {
					String secim = randevuTable.getValueAt(randevuTable.getSelectedRow(), 0).toString();
					int sonuc = JOptionPane.showConfirmDialog(null, "Emin misiniz?");
					if(sonuc == JOptionPane.OK_OPTION) {
						Veritabani.KomutCalistir("UPDATE Doktor SET kapasite = kapasite-1 WHERE ad_soyad=(SELECT randevu_doktor FROM Hasta WHERE id="+secim+")");
						Veritabani.KomutCalistir("DELETE FROM Hasta WHERE id="+secim);
						JOptionPane.showMessageDialog(null,"Silme basarili");
						Veritabani.TabloGoster(randevuTable, "SELECT id,ad_soyad,randevu_tarih,randevu_saati,randevu_doktor,randevu_bolum FROM Hasta", 
								new String[] {"#","Ad Soyad","Tarih","Saat","Doktor","Bolum"});
					}
				}
			}
		});
		btnNewButton.setBounds(10, 227, 719, 23);
		frmRandevularim.getContentPane().add(btnNewButton);
	}
}
