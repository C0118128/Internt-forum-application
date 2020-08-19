package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TcpSockClientGUI extends JFrame {

	private JPanel contentPane;
	private JTextField sendDetatextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				final String ipAddress = "127.0.0.1";
				final int portNumber = 34567;

				try {
					Socket socket = new Socket(ipAddress, portNumber);
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

					try {
						TcpSockClientGUI frame = new TcpSockClientGUI(socket,br, pw);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (UnknownHostException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TcpSockClientGUI(Socket socket, BufferedReader br, PrintWriter pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		sendDetatextField = new JTextField();
		sendDetatextField.setBounds(12, 224, 307, 27);
		contentPane.add(sendDetatextField);
		sendDetatextField.setColumns(10);


		JTextArea loadDetaTextArea = new JTextArea();
		loadDetaTextArea.setBounds(12, 41, 410, 173);
		contentPane.add(loadDetaTextArea);

		JTextArea connectionStatusTextArea = new JTextArea();
		connectionStatusTextArea.setBounds(115, 9, 204, 21);
		contentPane.add(connectionStatusTextArea);
		connectionStatusTextArea.setText("Socket connecting");
		try {
			pw.println("load");
			String readStr = br.readLine();
			System.out.println(readStr);
			String[] splitStr = readStr.split(",", 0);

			loadDetaTextArea.setText("");
			for(String readSplitStr: splitStr) {
				loadDetaTextArea.append(readSplitStr + "\n");
			}
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		JButton sendBtn = new JButton("Send");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sendStr = sendDetatextField.getText();
				if(sendStr.equals("") == false) {
					pw.println("send," + sendStr);
				}else {

				}

				try {
					pw.println("load");
					String readStr = br.readLine();
					System.out.println(readStr);
					String[] splitStr = readStr.split(",", 0);

					loadDetaTextArea.setText("");
					for(String readSplitStr: splitStr) {
						loadDetaTextArea.append(readSplitStr + "\n");
					}
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});
		sendBtn.setBounds(331, 227, 91, 21);
		contentPane.add(sendBtn);

		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pw.println("load");
					String readStr = br.readLine();
					System.out.println(readStr);
					String[] splitStr = readStr.split(",", 0);

					loadDetaTextArea.setText("");
					for(String readSplitStr: splitStr) {
						loadDetaTextArea.append(readSplitStr + "\n");
					}
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});
		loadBtn.setBounds(12, 10, 91, 21);
		contentPane.add(loadBtn);

		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pw.println("close");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
					String closeStr = br.readLine();
					connectionStatusTextArea.setText(closeStr);
					socket.close();
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
		});
		closeBtn.setBounds(331, 10, 91, 21);
		contentPane.add(closeBtn);
	}
}
