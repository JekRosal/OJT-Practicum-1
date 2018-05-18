import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *@author Ivan Demeter B. Torcuato
 */

public class server extends JFrame {
	
	JTextArea textArea = new JTextArea("Waiting for client request.", 6, 20);
	JTextField textField = new JTextField("", 20);
	JButton button = new JButton("Send");
	public server() {
		
		JFrame frame = new JFrame("Server");
		setLayout(new FlowLayout());
		
		add(textArea);
		add(textField);
		add(button);
		
		textArea.setEditable(false);
		
		setSize(300, 210);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		setVisible(true);
		button.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
				String txtInput = textField.getText();
		try{
			ServerSocket ss = new ServerSocket(9999);
			Socket sock = ss.accept();
			textArea.append("\nClient connected.\n");
 			OutputStreamWriter osw = new OutputStreamWriter(sock.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter pw = new PrintWriter(osw);
			pw.println(txtInput);
			pw.flush();
			textArea.append("Server: " + txtInput + "\n");
		}catch(IOException ex){
			System.out.println("Exception: " + ex );
		}
			}
		});
		do {
			receive();
		} while(true);
			
	}	
		
	
	
	public void receive() {
		try {
			String input = br.readLine();
			if(input != null) {
				textArea.append("Client: " + input + "\n");
			}
		} catch(IOException e) {
			
		}
	}
	
	public void end() {
		try{
			ss.close();
			sock.close();
			osw.close();
			pw.close();
			br.close();
		} catch(IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		MyServer server = new MyServer();
		server.end();	
	}
}