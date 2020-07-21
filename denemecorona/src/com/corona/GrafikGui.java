package com.corona;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class GrafikGui extends Client {
	
	private JTable table;
	private static JTextField toplamVakaInput;
	private static JTextField toplamTestInput;
	private static JTextField toplamVefatInput;
	private static JTextField toplamYogunBakimHastaInput;
	private static JTextField toplamEntubeHastaInput;
	private static JTextField toplamIyilesenHastaInput;
	DefaultTableModel model=new DefaultTableModel();
	Object[] kolonlar= {"Vaka Sayisi","Vefat Sayisi"};
	Object[] satirlar= {"1","2"};
	private static Client client;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		client = client.getInstance();
	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrafikGui window = new GrafikGui();
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
	public GrafikGui() {
		super("127.0.0.1", 3333);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

	    JPanel panelbaslik = (JPanel) frame.getContentPane();
	    JLabel labelbaslik = new JLabel("Türkiye Günlük Koronovirüs tablosu");
	    panelbaslik.add(labelbaslik);
	    Dimension sizebaslik = labelbaslik.getPreferredSize();
	    labelbaslik.setBounds(21, 0, 230, 14);
		
		
		

	    JPanel panel = (JPanel) frame.getContentPane();
	    panel.setLayout(null);
	    JLabel label0 = new JLabel("ToplamTestSayisi");
	    panel.add(label0);
	    Dimension size = label0.getPreferredSize();
	    label0.setBounds(0, 20, 102,15);
	    
	    
	    toplamTestInput = new JTextField();
	    toplamTestInput.setBounds(152, 17, 67, 20);
	    frame.getContentPane().add(toplamTestInput);
	    toplamTestInput.setColumns(10);
	   
	    
	    JPanel panel1 = (JPanel) frame.getContentPane();
	    
	    JLabel label1 = new JLabel("ToplamVakaSayisi");
	    panel1.add(label1);
	    Dimension size1 = label1.getPreferredSize();
	    label1.setBounds(0, 45, 120,15);
	    
	    toplamVakaInput = new JTextField();
	    toplamVakaInput.setBounds(152, 42, 67, 20);
	    frame.getContentPane().add(toplamVakaInput);
	    toplamVakaInput.setColumns(10);
	    
	    
	    
	    
	    JLabel label2 = new JLabel("ToplamVefatSayisi");
	    panel1.add(label2);
	    Dimension size2 = label2.getPreferredSize();
	    label2.setBounds(0, 71, 120,15);
	    
	    
	    toplamVefatInput = new JTextField();
	    toplamVefatInput.setBounds(152, 68, 67, 20);
	    frame.getContentPane().add(toplamVefatInput);
	    toplamVefatInput.setColumns(10);
	    
	    
	    JLabel label3 = new JLabel("ToplamYogunBakim\r\nHastaSayisi");
	    panel1.add(label3);
	    Dimension size3 = label3.getPreferredSize();
	    label3.setBounds(0, 97, 156,14);
	    
	    toplamYogunBakimHastaInput = new JTextField();
	    toplamYogunBakimHastaInput.setText("723");
	    toplamYogunBakimHastaInput.setBounds(152, 94, 67, 20);
	    frame.getContentPane().add(toplamYogunBakimHastaInput);
	    toplamYogunBakimHastaInput.setColumns(10);
	    
	    JLabel label4 = new JLabel("ToplamEntubeHastaSayisi");
	    panel1.add(label4);
	    Dimension size4 = label4.getPreferredSize();
	    label4.setBounds(0, 122, 144,15);
	    
	    
	    toplamEntubeHastaInput = new JTextField();
	    toplamEntubeHastaInput.setText("331");
	    toplamEntubeHastaInput.setBounds(152, 119, 67, 20);
	    frame.getContentPane().add(toplamEntubeHastaInput);
	    toplamEntubeHastaInput.setColumns(10);
	    
	    
	    JLabel label5 = new JLabel("ToplamIyılesenHastaSayisi");
	    panel1.add(label5);
	    Dimension size5 = label4.getPreferredSize();
	    label5.setBounds(0, 148, 160,15);
	    
	    
	    toplamIyilesenHastaInput = new JTextField();
	    toplamIyilesenHastaInput.setText("122.793");
	    toplamIyilesenHastaInput.setBounds(152, 148, 67, 20);
	    frame.getContentPane().add(toplamIyilesenHastaInput);
	    toplamIyilesenHastaInput.setColumns(10);
	    
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(229, 39, 196, 124);
			frame.getContentPane().add(scrollPane);
	      
	      table = new JTable();
	      table.setModel(model);
	      model.setColumnIdentifiers(kolonlar);
	      model.addRow(satirlar);
			table.setBounds(225, 136, 178, 70);
			scrollPane.setViewportView(table);
						
		    
		    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		      Calendar cal = Calendar.getInstance();
		     // System.out.println(dateFormat.format(cal.getTime()));
		        
		        JLabel tarihlable = new JLabel(dateFormat.format(cal.getTime()));
		       tarihlable.setBackground(Color.BLACK);
			    tarihlable.setBounds(109, 174, 196, 54);
			    JPanel paneltarih = (JPanel) frame.getContentPane();
			    paneltarih.add(tarihlable);
			    
	}
	
	/*// Degerleri setleme
		public void setToplamTestInput(String toplam) {
			toplamTestInput.setText(toplam);
		}

		public void setToplamVakaInput(String toplam) {
			toplamVakaInput.setText(toplam);
		}

		public void setToplamVefatInput(String toplam) {
			toplamVefatInput.setText(toplam);
		}

		public void setToplamYogunBakimHastaInput(String toplam) {
			toplamYogunBakimHastaInput.setText(toplam);
		}

		public void setToplamEntubeHastaInput(String toplam) {
			toplamEntubeHastaInput.setText(toplam);
		}

		public void setToplamIyilesenHastaInput(String toplam) {
			toplamIyilesenHastaInput.setText(toplam);
		}
*/
}
