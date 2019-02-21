package multiConnect;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedOutput implements Runnable {
	
	private Socket incoming;
	
	public ThreadedOutput(Socket incomingC) {
		incoming=incomingC;
	}
	
	
	public void run(){
		
		try{
			
			try{
				
				boolean exit = false;
				
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true); //true means autoflush
				
				out.println( "Hello! Enter message and Enter or EXIT to exit." );
				
				while(!exit && in.hasNextLine()){
					
					String messageLine = in.nextLine();
				    out.println("Echo: "+messageLine);
				    if (messageLine.equals("EXIT")){
				    	
				    	exit=true;
				    	
				    }  

				}
				
			}
			finally{
				incoming.close();
			}

		}
		catch (IOException e){  
			e.printStackTrace();
		}

		
	}
	
	

}
