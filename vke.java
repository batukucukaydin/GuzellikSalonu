 /* BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * Vücut Kitle Endeksi Hesaplayan Ekran
 * 
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

public class vke {

	public JFrame frmvke;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	
	JComboBox comboCinsiyet;
	String[ ] gender = {"Erkek","Kadýn",};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vke window = new vke();
					window.frmvke.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vke() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmvke = new JFrame();
		frmvke.setTitle("Vucut Kitle Endeksi Hesaplama");
		frmvke.setBounds(100, 100, 359, 212);
		frmvke.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmvke.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cinsiyet");
		lblNewLabel.setBounds(10, 11, 108, 14);
		frmvke.getContentPane().add(lblNewLabel);
		
		comboCinsiyet = new JComboBox(gender);
		comboCinsiyet.setBounds(128, 8, 86, 20);
		
		frmvke.getContentPane().add(comboCinsiyet);
		
	
		JLabel lblBolumu = new JLabel("Boy(m)");
		lblBolumu.setBounds(10, 39, 108, 14);
		frmvke.getContentPane().add(lblBolumu);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(128, 36, 86, 20);
		frmvke.getContentPane().add(tf2);
		
		JLabel lblMaxKapasite = new JLabel("Kilo(kg)");
		lblMaxKapasite.setBounds(10, 67, 108, 14);
		frmvke.getContentPane().add(lblMaxKapasite);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(128, 64, 86, 20);
		frmvke.getContentPane().add(tf3);
		
		
		JButton btnNewButton = new JButton("Hesapla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf2.getText().isEmpty()||tf3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tum alanlar doldurulmalidir.");
				}
				else {
					/*if(Veritabani.SayiVarmi(tf1.getText())) {
						JOptionPane.showMessageDialog(null, "Ad-Soyad kismina sayi girilemez");
					}*/
					
					if(Veritabani.HarfVarmi(tf2.getText())) {
						JOptionPane.showMessageDialog(null, "Boy alanina harf girilemez!");
					}
					else if(Veritabani.HarfVarmi(tf3.getText())) {
						JOptionPane.showMessageDialog(null, "Kilo  bolumune harf girilemez!");
					}
					
					else {
						
						String boy1= tf2.getText();
						String kilo1= tf3.getText();
						double boy =  Double.parseDouble(boy1);
						double kilo =  Double.parseDouble(kilo1);
						
						
						double vke= kilo/(boy*boy);
						
					    String durum;
						if(vke <18.5)
					    {
							durum = "ZAYIF";
					    }   
					    else if(vke >= 18.5 && vke <24.9)
					    {
					    	durum = "NORMAL KILOLU";
					    }
					    else if(vke >= 24.9 && vke <29.9)
					    {
					    	durum = "FAZLA KILOLU";        
					    }
					    else if(vke >= 29.9 && vke <39.9)
					    {
					    	durum = "OBEZ";
					    }
					    else
					    {
					        durum = "MORBID OBEZ";
					    }     
					     
						
						
						
						JOptionPane.showMessageDialog(null, "Vücut Kitle Endeksiniz: "+vke +"\n"+"Durumunuz: "+durum);
					}
					
				}
			}
		});
		btnNewButton.setBounds(125, 124, 89, 23);
		frmvke.getContentPane().add(btnNewButton);
	}
}

