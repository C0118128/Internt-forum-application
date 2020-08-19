package main;

import java.util.Date;

public class Storage {
	private static String deta = "";

	public synchronized void save(String deta){
		Date date = new Date();
		Storage.deta += date.toString() + ": " + deta + ",";
	}

	public synchronized void connection(String userThreadName) {
		Date date = new Date();
		Storage.deta += date.toString() + ": " + userThreadName + " is connecting " + ",";
	}

	public synchronized void close(String userThreadName) {
		Date date = new Date();
		Storage.deta += date.toString() + ": " + userThreadName + " closed " + ",";
	}


	public synchronized String getDeta() {
		return Storage.deta;
	}
}
