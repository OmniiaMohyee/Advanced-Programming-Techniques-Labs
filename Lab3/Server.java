package assign4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	static int port1;
	static int port2;
	public static void main(String args[]) 
	{ 

          port1 = 6660;
          port2 = 6661;
          ServerThread st1 = new ServerThread(port1);
          ServerThread st2 = new ServerThread(port2);
          Thread t1 = new Thread(st1);
          Thread t2 = new Thread(st2);
          t1.start();
          t2.start();
		
	}
	
	
	
	
}
