package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainThread extends Thread{
	private Socket socket = null;
	private Storage storage;

	public MainThread(Socket socket, Storage storage) {
		this.socket = socket;
		this.storage = storage;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

			storage.connection(getName());

			while(true) {
				String deta = br.readLine();

				if(deta != null) {
					String[] splitDeta = deta.split(",", 0);

					if(splitDeta[0].equals("send")) {
						storage.save(getName() + " = " + splitDeta[1]);
						System.out.println("send " + deta);
					}else if(splitDeta[0].equals("load")){
						pw.println(storage.getDeta());
						System.out.println("load");
					}else if(splitDeta[0].equals("close")) {
						storage.close(getName());
						pw.println("close");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}
						System.out.println("close");
						break;
					}else {

					}
				}else {

				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			socket.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
