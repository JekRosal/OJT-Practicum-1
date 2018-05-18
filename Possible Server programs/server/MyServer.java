import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyServer extends JFrame{
	static JFrame frame;
	static String message = "";
	
private JPanel contentPane;
private JTextField txtMsg;

	public static void main(String[] args){
		String client;
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				try{
					MyServer frame = new MyServer();
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
			  }
      }});
}
		public MyServer(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 577, 144);
contentPane = new JPanel();
setContentPane(contentPane);
contentPane.setLayout(null);
 
 
		frame = new JFrame("Server");
		frame.setLayout(new FlowLayout());
		JButton accept = new JButton("Send");
		JTextField input = new JTextField();
		TextArea field = new TextArea(12,20);
  		frame.add(accept);
  		frame.add(field);
  		final JButton btnStartServer = new JButton("Start Server");
btnStartServer.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) {
	new Thread(new Runnable(){
	@Override
		public void run(){
		try{
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Waiting for client request.");
			Socket sock = ss.accept();
			System.out.println("Client connected.");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String message;
			if((message=br.readLine())!=null){
				System.out.println("Received message from client.");
			}
			
		}catch(IOException e){
			System.out.println("Exception: "+e);
			
	}}}).start();
}});
 
btnStartServer.setBounds(10, 42, 147, 45);
contentPane.add(btnStartServer);
txtMsg = new JTextField();
txtMsg.setBounds(10, 11, 510, 20);
contentPane.add(txtMsg);
txtMsg.setColumns(10);
}}