import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class MyServer extends Thread {
	
	Socket client;
	String input;
	
	public MyServer(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
		try {
	
			Scanner stream = new Scanner(client.getInputStream());
			PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
			
			do {
				
				input = stream.nextLine();
				int ctr = 0;
				for(int i = 0; i < input.length(); i++) {
					if(Character.isLetter(input.charAt(i))) {
						ctr++;
					}
				}
				pw.println(ctr);
				
			} while(!input.equalsIgnoreCase("bye"));
			
		System.out.println("The client has left");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
			
		try {
			
			ServerSocket server = new ServerSocket(5454);
			
			while(true) {
				Socket client = server.accept();
				MyServer clientThread = new MyServer(client);
				clientThread.start();
				System.out.println("A client entered");
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}