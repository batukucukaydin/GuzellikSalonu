 /* BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * Görüþ Alma Ekraný
 * 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mem2 {

	public JFrame frmmem2;
	
	private JTextArea tf4;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mem2 window = new Mem2();
					window.frmmem2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mem2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmmem2 = new JFrame();
		frmmem2.setTitle("Memnuniyet Formu");
		frmmem2.setBounds(100, 100, 359, 312);
		frmmem2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmmem2.getContentPane().setLayout(null);
		
		
		JLabel lblBolumu = new JLabel("Eksik bulduðunuz ve düzeltmemizi istediðiniz ");
		lblBolumu.setBounds(40, 11, 308, 14);
		frmmem2.getContentPane().add(lblBolumu);
		
		JLabel lblBolumu2 = new JLabel("þeyleri yazabilir misiniz?");
		lblBolumu2.setBounds(90, 31, 308, 14);
		frmmem2.getContentPane().add(lblBolumu2);
		
		tf4 = new JTextArea();
		tf4.setColumns(100);
		tf4.setBounds(40, 52, 260,90);
		frmmem2.getContentPane().add(tf4);
		
	
		
        JButton btnNewButton = new JButton("Gönder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tum alanlar doldurulmalidir.");
				}
				else {
					String gorus = tf4.getText();
					int karakter_sayisi=0;
					 for (int i = 0 ; i < gorus.length();i++) {
				            
				            if (gorus.charAt(i) != ' '){
				                
				                karakter_sayisi++;
				            }
				        }
	                
					if(karakter_sayisi < 100) {
						
						JOptionPane.showMessageDialog(null, "Tesekkur Ederiz!Iyi Gunler");
					
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Karakter sayisi 100 u gecmemelidir.");
						
					}
					
				
					
					
				}
			}
		});
		btnNewButton.setBounds(125, 224, 89, 23);
		frmmem2.getContentPane().add(btnNewButton);
	}
}
