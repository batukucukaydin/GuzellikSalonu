/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoktorTanimlama {

	public JFrame frmDoktorEkle;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorTanimlama window = new DoktorTanimlama();
					window.frmDoktorEkle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoktorTanimlama() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoktorEkle = new JFrame();
		frmDoktorEkle.setTitle("Doktor Ekle");
		frmDoktorEkle.setBounds(100, 100, 259, 212);
		frmDoktorEkle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmDoktorEkle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adi Soyadi");
		lblNewLabel.setBounds(10, 11, 108, 14);
		frmDoktorEkle.getContentPane().add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setBounds(128, 8, 86, 20);
		frmDoktorEkle.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JLabel lblBolumu = new JLabel("Bolumu");
		lblBolumu.setBounds(10, 39, 108, 14);
		frmDoktorEkle.getContentPane().add(lblBolumu);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 36, 86, 20);
		frmDoktorEkle.getContentPane().add(tf2);
		
		JLabel lblMaxKapasite = new JLabel("Max. Kapasite");
		lblMaxKapasite.setBounds(10, 67, 108, 14);
		frmDoktorEkle.getContentPane().add(lblMaxKapasite);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 64, 86, 20);
		frmDoktorEkle.getContentPane().add(tf3);
		
		JLabel lblCepTel = new JLabel("Cep Tel.");
		lblCepTel.setBounds(10, 95, 108, 14);
		frmDoktorEkle.getContentPane().add(lblCepTel);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(128, 92, 86, 20);
		frmDoktorEkle.getContentPane().add(tf4);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tum alanlar doldurulmalidir.");
				}
				else {
					if(Veritabani.SayiVarmi(tf1.getText())) {
						JOptionPane.showMessageDialog(null, "Ad-Soyad kismina sayi girilemez");
					}
					else if(tf4.getText().length()!=10) {
						JOptionPane.showMessageDialog(null , "Cep telefonu 10 rakamdan olusmalidir");
					}
					else if(Veritabani.HarfVarmi(tf4.getText())) {
						JOptionPane.showMessageDialog(null, "Cep telefonunda harf bulunamaz!");
					}
					else if(Veritabani.SayiVarmi(tf2.getText())) {
						JOptionPane.showMessageDialog(null, "Bolum alanina sayi girilemez!");
					}
					else if(Veritabani.HarfVarmi(tf3.getText())) {
						JOptionPane.showMessageDialog(null, "Max kapasite bolumune harf girilemez!");
					}
					else if(Integer.parseInt(tf3.getText())>10) {
						JOptionPane.showMessageDialog(null, "Max kapasite degeri 10'u asamaz");
					}
					else {
						Veritabani.KomutCalistir("INSERT INTO Doktor(ad_soyad,bolum,hasta_sayisi,tarih,max_kapasite,cep_no,kapasite)"
								+ "VALUES('"+tf1.getText()+"','"+tf2.getText()+"',0,DATE('now'),"+tf3.getText()+",'"+tf4.getText()+"',0)");
						JOptionPane.showMessageDialog(null, "Doktor ekleme basarili!");
					}
					
				}
			}
		});
		btnNewButton.setBounds(125, 124, 89, 23);
		frmDoktorEkle.getContentPane().add(btnNewButton);
	}
}
