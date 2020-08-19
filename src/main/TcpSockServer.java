package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSockServer {
	public static void main(String[] args) {
		final int portNumber = 34567;

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(portNumber));

			Storage storage = new Storage();

			while(true) {
				Socket socket = serverSocket.accept();

				MainThread mThread = new MainThread(socket, storage);
				mThread.start();
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}else {

				}
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}
}
