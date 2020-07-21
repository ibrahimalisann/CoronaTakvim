package com.corona;

public class CurrentDataDisplay implements Observer ,Display {
	
	
	
	private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	private int gunluktestsayisi;
	 private int gunlukvakasayisi;
	 private int gunlukyogunbakimh;
	 private int gunlukentubeh;
	 private int gunlukolu;
	 private int iyilesenhastasayisi;
	private int tarih;

			@Override
			public void display() {
			

				//System.out.println("GünlükTestSayisi"+gunluktestsayisi+"GünlükVakaSayisi"+gunlukvakasayisi+
					//	"GünlükYogunBakimHastaSayisi"+gunlukyogunbakimh+"GünlükEntübeHastaSayisi"+gunlukentubeh+
						//"GünlükOlüSayisi"+gunlukolu+"GünlükIyilesenHastaSayisi"+iyilesenhastasayisi+"Bugün"+tarih);
			}
 


			@Override
			public void update(int gunluktestsayisi, int gunlukvakasayisi, int gunlukyogunbakimh, int gunlukentubeh,
					int gunlukolu, int iyilesenhastasayisi, int tarih) {

this.gunluktestsayisi=gunluktestsayisi;
this.gunlukvakasayisi=gunlukvakasayisi;
this.gunlukyogunbakimh=gunlukyogunbakimh;
this.gunlukentubeh=gunlukentubeh;
this.gunlukolu=gunlukolu;
this.iyilesenhastasayisi=iyilesenhastasayisi;
this.tarih=tarih;
	display();
				
			}


}

