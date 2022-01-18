/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RandevuAlma {

	public JFrame frmRandevuAl;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	JComboBox comboDoktor;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandevuAlma window = new RandevuAlma();
					window.frmRandevuAl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandevuAlma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRandevuAl = new JFrame();
		frmRandevuAl.setTitle("Randevu Al");
		frmRandevuAl.setBounds(100, 100, 283, 224);
		frmRandevuAl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandevuAl.getContentPane().setLayout(null);
		
		JLabel lblBolum = new JLabel("Bolum");
		lblBolum.setBounds(10, 14, 108, 14);
		frmRandevuAl.getContentPane().add(lblBolum);
		
		JLabel lblDoktor = new JLabel("Doktor");
		lblDoktor.setBounds(10, 42, 108, 14);
		frmRandevuAl.getContentPane().add(lblDoktor);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(10, 70, 108, 14);
		frmRandevuAl.getContentPane().add(lblTarih);
		
		JLabel lblSaat = new JLabel("Saat");
		lblSaat.setBounds(10, 98, 108, 14);
		frmRandevuAl.getContentPane().add(lblSaat);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(128, 11, 86, 20);
		frmRandevuAl.getContentPane().add(tf1);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 67, 86, 20);
		frmRandevuAl.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 95, 86, 20);
		frmRandevuAl.getContentPane().add(tf3);
		
		JButton btnRandevuAl = new JButton("Randevu Al");
		btnRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboDoktor.getSelectedIndex()>=0) {
					if(Veritabani.SayiVarmi(tf1.getText())) {
						JOptionPane.showMessageDialog(null, "Bolum alanina sayi girilemez");
					}
					else if(tf2.getText().matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}")==false) {
						JOptionPane.showMessageDialog(null, "Tarih gg.aa.yyyy olarak girilmelidir!");
					}
					else if(tf3.getText().matches("[0-9]{1,2}[:][0-9]{1,2}")==false) {
						JOptionPane.showMessageDialog(null, "Saat ss:dd 24 saat formatinda girilmelidir!");
					}
					else {
						int saat = Integer.parseInt(tf3.getText().split(":")[0]);
						if(saat<9||saat>21) {
							JOptionPane.showMessageDialog(null, "Sabah 9 ve aksam 21 arasinda randevu alabilirsiniz!");
						}
						else {
							try {
								if((Veritabani.TekVeriGetir("SELECT 'MUSAIT' FROM Doktor WHERE ad_soyad='"+comboDoktor.getSelectedItem().toString()+"' AND kapasite<max_kapasite").equals("MUSAIT"))) {
									Veritabani.KomutCalistir("INSERT INTO Hasta(ad_soyad,randevu_bolum,randevu_doktor,randevu_tarih,randevu_saati) "
											+ "VALUES('"+tf4.getText()+"','"+tf1.getText()+"','"+comboDoktor.getSelectedItem().toString()+"','"+tf2.getText()+"','"+tf3.getText()+"')");
									Veritabani.KomutCalistir("UPDATE Doktor SET kapasite=kapasite+1 WHERE ad_soyad='"+comboDoktor.getSelectedItem().toString()+"'");
									JOptionPane.showMessageDialog(null, "Randevu olusturuldu.");
								}else {
									JOptionPane.showMessageDialog(null, "Bu doktorun musaitligi bulunmuyor.");
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Doktor seciniz");
				}
			}
		});
		btnRandevuAl.setBounds(126, 151, 119, 23);
		frmRandevuAl.getContentPane().add(btnRandevuAl);
		
		comboDoktor = new JComboBox();
		comboDoktor.setBounds(125, 39, 132, 20);
		frmRandevuAl.getContentPane().add(comboDoktor);
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad");
		lblAdSoyad.setBounds(10, 126, 108, 14);
		frmRandevuAl.getContentPane().add(lblAdSoyad);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(128, 123, 86, 20);
		frmRandevuAl.getContentPane().add(tf4);
		ArrayList<String> doktorlar = Veritabani.VeriGetir("SELECT ad_soyad FROM Doktor");
		for(String doktor:doktorlar) {
			comboDoktor.addItem(doktor);
		}
	}
}
