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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Verilergui'yi çalıştırdan sonra verileri gören gui
 */

public class ClientGui extends Client {

	protected static final String ActionEvent = null;
	private JFrame frame;
	private static JLabel toplamVakaInput;
	private static JLabel toplamTestInput;
	private static JLabel toplamVefatInput;
	private static JLabel toplamYogunBakimHastaInput;
	private static JLabel toplamEntubeHastaInput;
	private static JLabel toplamIyilesenHastaInput;
	private static JLabel gunlukInput;
	private static JLabel gunlukVakaInput;
	private static JLabel gunlukVefatInput;
	private static JLabel gunlukIyilesenInput;
	private static Client client;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		ClientGui window = new ClientGui();

		client = client.getInstance();
		client.setUserName("VerilerClient");

		client.execute(window);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private ClientGui() {
		super("127.0.0.1", 3333);
		initialize();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(null);

		JPanel panelbaslik = (JPanel) frame.getContentPane();
		JLabel labelbaslik = new JLabel("Türkiye Günlük Koronovirüs tablosu");
		panelbaslik.add(labelbaslik);
		Dimension sizebaslik = labelbaslik.getPreferredSize();
		labelbaslik.setBounds(21, 0, 230, 14);

		JLabel label0 = new JLabel("ToplamTestSayisi");
		panel.add(label0);
		Dimension size = label0.getPreferredSize();
		label0.setBounds(0, 20, 102, 15);

		toplamTestInput = new JLabel();
		toplamTestInput.setBounds(152, 17, 67, 20);
		frame.getContentPane().add(toplamTestInput);

		JPanel panel1 = (JPanel) frame.getContentPane();

		JLabel label1 = new JLabel("ToplamVakaSayisi");
		panel1.add(label1);
		Dimension size1 = label1.getPreferredSize();
		label1.setBounds(0, 45, 120, 15);

		toplamVakaInput = new JLabel();
		toplamVakaInput.setBounds(152, 42, 67, 20);
		frame.getContentPane().add(toplamVakaInput);

		JLabel label2 = new JLabel("ToplamVefatSayisi");
		panel1.add(label2);
		Dimension size2 = label2.getPreferredSize();
		label2.setBounds(0, 71, 120, 15);

		toplamVefatInput = new JLabel();
		toplamVefatInput.setBounds(152, 68, 67, 20);
		frame.getContentPane().add(toplamVefatInput);

		JLabel label3 = new JLabel("ToplamYogunBakim\r\nHastaSayisi");
		panel1.add(label3);
		Dimension size3 = label3.getPreferredSize();
		label3.setBounds(0, 97, 156, 14);

		toplamYogunBakimHastaInput = new JLabel();
		toplamYogunBakimHastaInput.setBounds(152, 94, 67, 20);
		frame.getContentPane().add(toplamYogunBakimHastaInput);

		JLabel label4 = new JLabel("ToplamEntubeHastaSayisi");
		panel1.add(label4);
		Dimension size4 = label4.getPreferredSize();
		label4.setBounds(0, 122, 144, 15);

		toplamEntubeHastaInput = new JLabel();
		toplamEntubeHastaInput.setBounds(152, 119, 67, 20);
		frame.getContentPane().add(toplamEntubeHastaInput);

		JLabel label5 = new JLabel("ToplamIyılesenHastaSayisi");
		panel1.add(label5);
		Dimension size5 = label4.getPreferredSize();
		label5.setBounds(0, 148, 160, 15);

		toplamIyilesenHastaInput = new JLabel();
		toplamIyilesenHastaInput.setBounds(152, 148, 67, 20);
		frame.getContentPane().add(toplamIyilesenHastaInput);

		JPanel panelGunluk = (JPanel) frame.getContentPane();
		JLabel label6 = new JLabel("BugünküTestSayisi");
		panelGunluk.add(label6);
		label6.setBounds(249, 20, 120, 15);
		frame.getContentPane().add(label6);

		gunlukInput = new JLabel();
		gunlukInput.setBounds(388, 17, 86, 20);
		frame.getContentPane().add(gunlukInput);

		JLabel label7 = new JLabel("BugünküVakaSayisi");
		panelGunluk.add(label7);
		label7.setBounds(249, 45, 120, 14);
		Dimension size7 = label7.getPreferredSize();

		gunlukVakaInput = new JLabel();
		gunlukVakaInput.setBounds(388, 42, 86, 20);
		frame.getContentPane().add(gunlukVakaInput);

		JLabel label8 = new JLabel("BugünküVefatSayisi");
		panelGunluk.add(label8);
		Dimension size8 = label8.getPreferredSize();
		label8.setBounds(249, 71, 120, 14);

		gunlukVefatInput = new JLabel();
		gunlukVefatInput.setBounds(388, 68, 86, 20);
		frame.getContentPane().add(gunlukVefatInput);

		JLabel label9 = new JLabel("BugünküIyilesenSayisi");
		panelGunluk.add(label9);
		Dimension size9 = label9.getPreferredSize();
		label9.setBounds(249, 97, 150, 14);

		gunlukIyilesenInput = new JLabel();
		gunlukIyilesenInput.setBounds(388, 94, 86, 20);
		frame.getContentPane().add(gunlukIyilesenInput);

		// Verilerin girildigi günün tarihi

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();

		JLabel tarihlable = new JLabel(dateFormat.format(cal.getTime()));
		tarihlable.setBackground(Color.BLACK);
		tarihlable.setBounds(109, 174, 196, 54);

		panelGunluk.add(tarihlable);

	}

	// Degerleri setleme
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

	public void setGunlukTest(String text) {
		gunlukInput.setText(text);
	}

	public void setGunlukVakaInput(String text) {
		gunlukVakaInput.setText(text);
	}

	public void setGunlukVefatInput(String text) {
		gunlukVefatInput.setText(text);
	}

	public void setGunlukIyilesenInput(String text) {
		gunlukIyilesenInput.setText(text);
	}

	public void setFields(String messageFromServer) {
		if (messageFromServer != null) {
			String[] messageArr = messageFromServer.split(",");
			if (messageArr != null && messageArr.length == 10) {
				setGunlukTest(messageArr[0]);
				setGunlukVakaInput(messageArr[1]);
				setGunlukVefatInput(messageArr[2]);
				setGunlukIyilesenInput(messageArr[3]);
				setToplamTestInput(messageArr[4]);
				setToplamVakaInput(messageArr[5]);
				setToplamVefatInput(messageArr[6]);
				setToplamYogunBakimHastaInput(messageArr[7]);
				setToplamEntubeHastaInput(messageArr[8]);
				setToplamIyilesenHastaInput(messageArr[9]);
			}
		}
	}
}
