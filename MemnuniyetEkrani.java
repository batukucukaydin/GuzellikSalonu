 /* BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * Memnuniyet Ölçme Ekraný
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemnuniyetEkrani {

	public JFrame frmmem;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	JComboBox comboPuan;
	String[ ] puan = {"5","4","3","2","1"};
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemnuniyetEkrani window = new MemnuniyetEkrani();
					window.frmmem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemnuniyetEkrani() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmmem = new JFrame();
		frmmem.setTitle("Memnuniyet Formu");
		frmmem.setBounds(100, 100, 359, 212);
		frmmem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmmem.getContentPane().setLayout(null);
		
		
		JLabel lblBolumu = new JLabel("Hasta Ismi");
		lblBolumu.setBounds(10, 11, 108, 14);
		frmmem.getContentPane().add(lblBolumu);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 8, 86, 20);
		frmmem.getContentPane().add(tf2);
		
		JLabel lblMaxKapasite = new JLabel("Hasta Soyismi");
		lblMaxKapasite.setBounds(10, 39, 108, 14);
		frmmem.getContentPane().add(lblMaxKapasite);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 36, 86, 20);
		frmmem.getContentPane().add(tf3);
		
		JLabel lblMaxKapasites = new JLabel("Hastanemizden memnun kaldýnýz mý? Lütfen Puanlayiniz");
		lblMaxKapasites.setBounds(10, 67, 408, 14);
		frmmem.getContentPane().add(lblMaxKapasites);
		
		
		
		comboPuan = new JComboBox(puan);
		comboPuan.setBounds(128, 87, 86, 20);
		frmmem.getContentPane().add(comboPuan);
		
		
		
		
		JButton btnNewButton = new JButton("Gönder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf2.getText().isEmpty()||tf3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tum alanlar doldurulmalidir.");
				}
				else {
					/*if(Veritabani.SayiVarmi(tf1.getText())) {
						JOptionPane.showMessageDialog(null, "Ad-Soyad kismina sayi girilemez");
					}*/
					
					if(Veritabani.SayiVarmi(tf2.getText())) {
						JOptionPane.showMessageDialog(null, "Isim alanina sayi girilemez!");
					}
					else if(Veritabani.SayiVarmi(tf3.getText())) {
						JOptionPane.showMessageDialog(null, "Soyisim  bolumune sayi girilemez!");
					}
					
					else {
						
						if(comboPuan.getSelectedIndex()<=1) {
							JOptionPane.showMessageDialog(null, "Teþekkür Ederiz!Yine Bekleriz ");
							
						}
						
					
						else {
							
								try {
									Mem2 window = new Mem2();
									window.frmmem2.setVisible(true);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							
						}
					}
					
				}
			}
		});
		btnNewButton.setBounds(125, 124, 89, 23);
		frmmem.getContentPane().add(btnNewButton);
	}
}
