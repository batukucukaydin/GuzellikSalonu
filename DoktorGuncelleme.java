
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DoktorGuncelleme {

	public JFrame frmDoktorGuncelle;

	/**
	 * Launch the application.
	 */
	String id;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorGuncelleme window = new DoktorGuncelleme("1");
					window.frmDoktorGuncelle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoktorGuncelleme(String id) throws SQLException {
		this.id=id;
		System.out.print(id);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frmDoktorGuncelle = new JFrame();
		frmDoktorGuncelle.setTitle("Doktor Guncelle");
		frmDoktorGuncelle.setBounds(100, 100, 280, 229);
		frmDoktorGuncelle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmDoktorGuncelle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adi Soyadi");
		lblNewLabel.setBounds(10, 14, 108, 14);
		frmDoktorGuncelle.getContentPane().add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(128, 11, 86, 20);
		frmDoktorGuncelle.getContentPane().add(tf1);
		
		JLabel lblBolumu = new JLabel("Bolumu");
		lblBolumu.setBounds(10, 42, 108, 14);
		frmDoktorGuncelle.getContentPane().add(lblBolumu);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 39, 86, 20);
		frmDoktorGuncelle.getContentPane().add(tf2);
		
		JLabel lblMaxKapasite = new JLabel("Max. Kapasite");
		lblMaxKapasite.setBounds(10, 70, 108, 14);
		frmDoktorGuncelle.getContentPane().add(lblMaxKapasite);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 67, 86, 20);
		frmDoktorGuncelle.getContentPane().add(tf3);
		
		JLabel lblCepTel = new JLabel("Cep Tel.");
		lblCepTel.setBounds(10, 98, 108, 14);
		frmDoktorGuncelle.getContentPane().add(lblCepTel);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(128, 95, 86, 20);
		frmDoktorGuncelle.getContentPane().add(tf4);

		tf1.setText(Veritabani.TekVeriGetir("SELECT ad_soyad FROM Doktor WHERE id="+id));
		tf2.setText(Veritabani.TekVeriGetir("SELECT bolum FROM Doktor WHERE id="+id));
		tf3.setText(Veritabani.TekVeriGetir("SELECT max_kapasite FROM Doktor WHERE id="+id));
		tf4.setText(Veritabani.TekVeriGetir("SELECT cep_no FROM Doktor WHERE id="+id));
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.addActionListener(new ActionListener() {
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
						Veritabani.KomutCalistir("UPDATE Doktor SET ad_soyad='"+tf1.getText()+"',bolum='"+tf2.getText()+"',max_kapasite="+tf3.getText()+",cep_no='"+tf4.getText()+"'"
								+ " WHERE id="+id);
						JOptionPane.showMessageDialog(null, "Doktor guncelleme basarili!");
					}
					
				}
			}
		});
		btnGuncelle.setBounds(125, 127, 89, 23);
		frmDoktorGuncelle.getContentPane().add(btnGuncelle);

		
		
	}

}
