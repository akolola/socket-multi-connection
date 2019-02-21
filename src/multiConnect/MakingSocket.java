package multiConnect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MakingSocket {
	
	
	
	
	public void establishSocket(int portNr){
				
		try{
			
			int socketNr = 1;
			ServerSocket servSoc = new ServerSocket(portNr); 
			
			while(true){
				
				Socket incoming = servSoc.accept();
				System.out.println("Connect ¹" + socketNr);
				Runnable r = new ThreadedOutput(incoming);
				Thread t = new Thread(r);
				t.start();
				socketNr++;
				
			}
			
			
		}
		catch(IOException e){
			e.printStackTrace();		
		}
		
		
		
	}
	

}
