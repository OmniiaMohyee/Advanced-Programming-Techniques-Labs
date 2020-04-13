package assign4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
	int port;
	int A1,A2;
	int[][]A;
	ServerThread(int p)
	{
		this.port = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
			try {
				ss = new ServerSocket(port);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			while (true)  
		    { 
		        Socket s = null; 
		          
		        try 
		        { 
		            // socket object to receive incoming client requests 
		            s = ss.accept();
					InputStream dataIn = s.getInputStream();
		       
		            int A1  = dataIn.read();
					int A2 = dataIn.read(); 
					A = new int [A1][A2];
				    for (int i = 0 ;i<A1;i++)
				    	for(int j =0 ;j<A2;j++)
				    		A[i][j] = dataIn.read();
					for (int i = 0 ;i<A1;i++)
					{
						for(int j =0 ;j<A2;j++)
						{
				    		System.out.print(A[i][j]+ " ");
						}
						System.out.print('\n');
						System.out.println("recieved on S");
					}
		        
		              
		            
		        System.out.println("Assigning new thread for this client"); 
		        ClientHandler CH = new ClientHandler(A1,A2,A,port); 
		        Thread t = new Thread(CH);
		        t.start();

		              
		        } 
		
			catch (IOException e) {
			e.printStackTrace();
			}
		    }
			}
}