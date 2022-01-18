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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoktorAra {

	public JFrame frmDoktorlarimiz;
	private JTextField tf1;
	private JTextField tf2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoktorAra window = new DoktorAra();
					window.frmDoktorlarimiz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoktorAra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoktorlarimiz = new JFrame();
		frmDoktorlarimiz.setTitle("Doktorlarimiz");
		frmDoktorlarimiz.setBounds(100, 100, 450, 300);
		frmDoktorlarimiz.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmDoktorlarimiz.getContentPane().setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 414, 175);
		frmDoktorlarimiz.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tf1 = new JTextField();
		tf1.setBounds(74, 11, 86, 20);
		frmDoktorlarimiz.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(214, 11, 86, 20);
		frmDoktorlarimiz.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JButton btnNewButton = new JButton("Ara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf2.getText().isEmpty()) {
					Veritabani.TabloGoster(table, "SELECT id,ad_soyad,bolum FROM Doktor WHERE ad_soyad LIKE '%"+tf1.getText()+"%' ", new String[] {"#","Adi Soyadi","Bolum"});
				}
				else {
					Veritabani.TabloGoster(table, "SELECT id,ad_soyad,bolum FROM Doktor WHERE bolum LIKE '%"+tf2.getText()+"%' ", new String[] {"#","Adi Soyadi","Bolum"});
				}
			}
		});
		btnNewButton.setBounds(338, 9, 86, 23);
		frmDoktorlarimiz.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Doktor");
		lblNewLabel.setBounds(10, 14, 46, 14);
		frmDoktorlarimiz.getContentPane().add(lblNewLabel);
		
		JLabel lblBolum = new JLabel("Bolum");
		lblBolum.setBounds(170, 14, 46, 14);
		frmDoktorlarimiz.getContentPane().add(lblBolum);
		
		JButton btnNewButton_1 = new JButton("Guncelle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0) {
					String secim = table.getValueAt(table.getSelectedRow(), 0).toString();
					try {
						DoktorGuncelleme window = new DoktorGuncelleme(secim);
						window.frmDoktorGuncelle.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(10, 227, 414, 23);
		frmDoktorlarimiz.getContentPane().add(btnNewButton_1);
	}

}
