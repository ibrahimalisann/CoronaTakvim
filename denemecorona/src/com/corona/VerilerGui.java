package com.corona;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

/*
 * İlk olarak bu classı calıştırıyoruz 
 */

public class VerilerGui {

    private JFrame frame;
    private static JTextField toplamVakaInput;
    private static JTextField toplamTestInput;
    private static JTextField toplamVefatInput;
    private static JTextField toplamYogunBakimHastaInput;
    private static JTextField toplamEntubeHastaInput;
    private static JTextField toplamIyilesenHastaInput;
    private static JTextField gunlukInput;
    private static JTextField gunlukVakaInput;
    private static JTextField gunlukVefatInput;
    private static JTextField gunlukIyilesenInput;
    private static Server server;


    /**
     * Launch the application.
     *
     * @throws ParseException
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame();
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


        toplamTestInput = new JTextField();
        toplamTestInput.setBounds(152, 17, 67, 20);
        frame.getContentPane().add(toplamTestInput);
        toplamTestInput.setColumns(10);


        JPanel panel1 = (JPanel) frame.getContentPane();

        JLabel label1 = new JLabel("ToplamVakaSayisi");
        panel1.add(label1);
        Dimension size1 = label1.getPreferredSize();
        label1.setBounds(0, 45, 120, 15);

        toplamVakaInput = new JTextField();
        toplamVakaInput.setBounds(152, 42, 67, 20);
        frame.getContentPane().add(toplamVakaInput);
        toplamVakaInput.setColumns(10);


        JLabel label2 = new JLabel("ToplamVefatSayisi");
        panel1.add(label2);
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(0, 71, 120, 15);


        toplamVefatInput = new JTextField();
        toplamVefatInput.setBounds(152, 68, 67, 20);
        frame.getContentPane().add(toplamVefatInput);
        toplamVefatInput.setColumns(10);


        JLabel label3 = new JLabel("ToplamYogunBakim\r\nHastaSayisi");
        panel1.add(label3);
        Dimension size3 = label3.getPreferredSize();
        label3.setBounds(0, 97, 150, 14);

        toplamYogunBakimHastaInput = new JTextField();
        toplamYogunBakimHastaInput.setBounds(152, 94, 67, 20);
        frame.getContentPane().add(toplamYogunBakimHastaInput);
        toplamYogunBakimHastaInput.setColumns(10);

        JLabel label4 = new JLabel("ToplamEntubeHastaSayisi");
        panel1.add(label4);
        Dimension size4 = label4.getPreferredSize();
        label4.setBounds(0, 122, 150, 15);


        toplamEntubeHastaInput = new JTextField();
        toplamEntubeHastaInput.setBounds(152, 119, 67, 20);
        frame.getContentPane().add(toplamEntubeHastaInput);
        toplamEntubeHastaInput.setColumns(10);


        JLabel label5 = new JLabel("ToplamIyılesenHastaSayisi");
        panel1.add(label5);
        Dimension size5 = label4.getPreferredSize();
        label5.setBounds(0, 148, 160, 15);


        toplamIyilesenHastaInput = new JTextField();
        toplamIyilesenHastaInput.setBounds(152, 148, 67, 20);
        frame.getContentPane().add(toplamIyilesenHastaInput);
        toplamIyilesenHastaInput.setColumns(10);
        
        
    	


        JButton buton1 = new JButton("verileriAktar");
        
        buton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//verilerin girilen degerleri
            	
                String gunlukTest = gunlukInput.getText();
                String gunlukVaka = gunlukVakaInput.getText();
                String gunlukVefat = gunlukVefatInput.getText();
                String gunlukIyilesen = gunlukIyilesenInput.getText();
                
                
                String toplamTest=toplamTestInput.getText();
                String toplamVaka=toplamVakaInput.getText();
                String toplamVefat=toplamVefatInput.getText();
                String toplamYogunBakimHasta=toplamYogunBakimHastaInput.getText();
                String toplamEntübe=toplamEntubeHastaInput.getText();
                String toplamIyilesenHasta=toplamIyilesenHastaInput.getText();
                
                
                //clientgui'de göster 
                
                server.broadcast((gunlukTest.isEmpty() ? "0" : gunlukTest) + "," 
                		+ (gunlukVaka.isEmpty() ? "0" : gunlukVaka)
                        + "," + (gunlukVefat.isEmpty() ? "0" : gunlukVefat) + ","
                		+ (gunlukIyilesen.isEmpty() ? "0" : gunlukIyilesen)
                        + ","+(toplamTest.isEmpty()?"0":toplamTest) 
                        + ","+(toplamVaka.isEmpty()?"0":toplamVaka)
                        + ","+(toplamVefat.isEmpty()?"0":toplamVefat)
                        +","+(toplamYogunBakimHasta.isEmpty()?"723":toplamYogunBakimHasta)
                        +","+(toplamEntübe.isEmpty()?"331":toplamEntübe)
                        +","+(toplamIyilesenHasta.isEmpty()?"122.793":toplamIyilesenHasta) ,null);
                
               //Dosyaya yazma 
            	try {  
	    	    	
			          
			           FileWriter fw=new FileWriter("F:\\masaüstü\\Ceng\\3.Sınıf\\2.Dönem\\Tasarım desenleri-JAVA\\Yeni klasör\\veriler.txt");    
			           fw.write("Günlük Test Sayisi "+gunlukTest+"\n"
			        		   +"Günlük Vaka Sayisi"+ gunlukVaka +"\n"
			        		   +"Günlük Vefat Sayisi "+gunlukVefat+"\n"
			        		   + "Günlük İyilesen Sayisi "+gunlukIyilesen+"\n"
			        		   +"Toplam Test Sayisi"+toplamTest+"\n"
			        		   +"Toplam Vaka Sayisi"+toplamVaka+"\n"
			        		   +"Toplam Vefat Sayisi"+toplamVefat+"\n"
			        		   +"Toplam Yogun Bakim Hasta Sayisi"+toplamYogunBakimHasta+"723"+"\n"
			        		   +"Toplam Entübe Hasta Sayisi"+toplamEntübe+"331"+"\n"
			        		   +"Topla Iyilesen Hasta Sayisi"+toplamIyilesenHasta+"122.793"+"\n"
			    				);    
			         
			           fw.close();    
			          }catch(Exception ex){System.out.println(ex);}    
			          System.out.println(" txt Dosyasina yazıldı");    

			          
            }
        });
        buton1.setBounds(13, 245, 102, 23);
        frame.getContentPane().add(buton1);


        JPanel panelDaily = (JPanel) frame.getContentPane();


        JLabel label6 = new JLabel("BugünküTestSayisi");
        panelDaily.add(label6);
        label6.setBounds(249, 20, 120, 15);
        frame.getContentPane().add(label6);


        gunlukInput = new JTextField();
        gunlukInput.setBounds(388, 17, 86, 20);
        frame.getContentPane().add(gunlukInput);
        gunlukInput.setColumns(10);

        JLabel label7 = new JLabel("BugünküVakaSayisi");
        panelDaily.add(label7);
        label7.setBounds(249, 45, 120, 14);
        Dimension size7 = label7.getPreferredSize();


        gunlukVakaInput = new JTextField();
        gunlukVakaInput.setBounds(388, 42, 86, 20);
        frame.getContentPane().add(gunlukVakaInput);
        gunlukVakaInput.setColumns(10);


        JLabel label8 = new JLabel("BugünküVefatSayisi");
        panelDaily.add(label8);
        Dimension size8 = label8.getPreferredSize();
        label8.setBounds(249, 71, 120, 14);


        gunlukVefatInput = new JTextField();
        gunlukVefatInput.setBounds(388, 68, 86, 20);
        frame.getContentPane().add(gunlukVefatInput);
        gunlukVefatInput.setColumns(10);


        JLabel label9 = new JLabel("BugünküIyilesenSayisi");
        panelDaily.add(label9);
        Dimension size9 = label9.getPreferredSize();
        label9.setBounds(249, 97, 150, 14);

        gunlukIyilesenInput = new JTextField();
        gunlukIyilesenInput.setBounds(388, 94, 86, 20);
        frame.getContentPane().add(gunlukIyilesenInput);
        gunlukIyilesenInput.setColumns(10);


      
        
     // Verilerin girildigi günün tarihi

     		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     		Calendar cal = Calendar.getInstance();

     		JLabel tarihlable = new JLabel(dateFormat.format(cal.getTime()));
     		tarihlable.setBackground(Color.BLACK);
     		tarihlable.setBounds(109, 174, 196, 54);

     		panelDaily.add(tarihlable);


        frame.setSize(500, 500);
        frame.setVisible(true);


        EventQueue.invokeLater(new Runnable() {


            public void run() {
                try {
                    VerilerGui window = new VerilerGui();
                    Thread thread = new Thread(){
                        public void run(){
                            server = new Server(3333);
                            server.execute();
                        }
                    };

                    thread.start();


                    //window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public VerilerGui() {

    }


}
