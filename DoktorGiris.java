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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DoktorGiris {

	public JFrame frmGiris;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorGiris window = new DoktorGiris();
					window.frmGiris.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoktorGiris() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGiris = new JFrame();
		frmGiris.setTitle("Giris");
		frmGiris.setBounds(100, 100, 259, 182);
		frmGiris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGiris.getContentPane().setLayout(null);
		
		JLabel lblDoktorAdi = new JLabel("Doktor Adi");
		lblDoktorAdi.setBounds(10, 14, 108, 14);
		frmGiris.getContentPane().add(lblDoktorAdi);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(128, 11, 86, 20);
		frmGiris.getContentPane().add(tf1);
		
		JLabel lblBolum = new JLabel("Bolum");
		lblBolum.setBounds(10, 42, 108, 14);
		frmGiris.getContentPane().add(lblBolum);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 39, 86, 20);
		frmGiris.getContentPane().add(tf2);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(10, 70, 108, 14);
		frmGiris.getContentPane().add(lblTarih);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 67, 86, 20);
		frmGiris.getContentPane().add(tf3);
		
		JButton btnGiris = new JButton("Giris");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Veritabani.SayiVarmi(tf1.getText())){
					JOptionPane.showMessageDialog(null, "Doktor adinda sayi bulunamaz");
				}
				else if(Veritabani.SayiVarmi(tf2.getText())){
					JOptionPane.showMessageDialog(null, "Bolum'de sayi bulunamaz");
				}
				else {
					String veri="";
					try {
						veri = Veritabani.TekVeriGetir("SELECT ad_soyad FROM Doktor WHERE ad_soyad='"+tf1.getText()+"'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	if(veri.equals("")) {
						JOptionPane.showMessageDialog(null, "Bilgilere ait doktor bulunamadi");
					}
					else {
						try {
							HastaKapasitesi window = new HastaKapasitesi(veri,tf2.getText(),tf3.getText());
							window.frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
			
		});
		btnGiris.setBounds(125, 99, 89, 23);
		frmGiris.getContentPane().add(btnGiris);
	}

}
