import java.net.*;
import java.io.*;


public class InstructorServer{
	public static void main(String[]args){
		try{
			ServerSocket s = new ServerSocket(5000);
			Socket socket = s.accept();
			
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
}