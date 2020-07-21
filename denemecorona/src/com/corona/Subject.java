package com.corona;

import java.util.Observer;

public interface Subject {
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
	//public void setData(string veri) {
//		Observer.ıpdate(veri)
	}


