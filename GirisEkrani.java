/*
 * 
 * BATUHAN KERÝM KÜÇÜKAYDIN-GÜZELLÝK SALONU RANDEVU OTOMASYON SÝSTEMÝ.
 * 
 * 
 * 
 */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GirisEkrani {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani window = new GirisEkrani();
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
	public GirisEkrani() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Doktor Tanimlama");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DoktorTanimlama window = new DoktorTanimlama();
					window.frmDoktorEkle.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 11, 150, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRandevularim = new JButton("Randevularim");
		btnRandevularim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Randevularim window = new Randevularim();
					window.frmRandevularim.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnRandevularim.setBounds(192, 11, 147, 23);
		frame.getContentPane().add(btnRandevularim);
		
		JButton btnDoktorArama = new JButton("Doktor Arama");
		btnDoktorArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DoktorAra window = new DoktorAra();
					window.frmDoktorlarimiz.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDoktorArama.setBounds(402, 11, 120, 23);
		frame.getContentPane().add(btnDoktorArama);
		
		JLabel lblNewLabel = new JLabel("Guzellik Salonu\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 27));
		lblNewLabel.setBounds(140, 45, 250, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRandevuOtomasyonu = new JLabel("Randevu Sistemi");
		lblRandevuOtomasyonu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandevuOtomasyonu.setFont(new Font("Stencil", Font.BOLD, 18));
		lblRandevuOtomasyonu.setBounds(140, 115, 250, 59);
		frame.getContentPane().add(lblRandevuOtomasyonu);
		
		JButton btnRandevuAl = new JButton("Randevu Al");
		btnRandevuAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RandevuAlma window = new RandevuAlma();
					window.frmRandevuAl.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnRandevuAl.setBounds(204, 185, 120, 23);
		frame.getContentPane().add(btnRandevuAl);
	
	
	   //new buttons
		JButton btnNewButtonvke = new JButton("BMI Hesaplama");
		btnNewButtonvke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vke window = new vke();
					window.frmvke.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButtonvke.setBounds(10, 230, 150, 23);
		frame.getContentPane().add(btnNewButtonvke);
		
		
		
		JButton btnNewButtonmem = new JButton("Memnuniyet Anketi");
		btnNewButtonmem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MemnuniyetEkrani window = new MemnuniyetEkrani();
					window.frmmem.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButtonmem.setBounds(365, 230, 150, 23);
		frame.getContentPane().add(btnNewButtonmem);
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
