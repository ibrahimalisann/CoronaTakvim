package com.corona;

import java.io.FileWriter;

public abstract class Test extends  CurrentDataDisplay {

	public static void main(String[] args)  {	
		CurrentDataDisplay dis1 = new CurrentDataDisplay();
		
		
		dis1.display();
		
		
		try{    
	           FileWriter fw=new FileWriter("F:\\masaüstü\\Ceng\\3.Sınıf\\2.Dönem\\Tasarım desenleri-JAVA\\Yeni klasör\\veriler.txt");    
	           fw.write("");    
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");    
	     }    
	   
	
		
	}


