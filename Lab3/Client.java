package assign4;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random;

public class Client implements Serializable{
	private static Scanner input; 
	static int A1,A2;
	static int[][]A;
	static int request;
	public static void main(String args[]) throws IOException, InterruptedException
	{
	
		// for determinate.
		getDimensions();
		fillMatrix();
		getRequest();
		if(request == 1)
		{
		Socket S = new Socket("localhost",6660);
		OutputStream dataOut = S.getOutputStream();
		
	    dataOut.write(A1);
	    dataOut.write(A2);
	    for (int i = 0 ;i<A1;i++)
	    	for(int j =0 ;j<A2;j++)
	    		dataOut.write(A[i][j]);
	    dataOut.flush();
	   
	    S.close();
		}
		else
		if(request == 2)
		{
			Socket S= new Socket("localhost",6661);
			OutputStream dataOut = S.getOutputStream();
			
		    dataOut.write(A1);
		    dataOut.write(A2);
		    for (int i = 0 ;i<A1;i++)
		    	for(int j =0 ;j<A2;j++)
		    		dataOut.write(A[i][j]);
		    dataOut.flush();
		    S.close();
		}
		TimeUnit.MILLISECONDS.sleep((new Random()).nextInt(1000));
	}

	
	private static void getDimensions()
	{
		int c = 0;
		boolean flag = true;
		while(true )
		{
		if(!flag)
		{
			System.out.println("Wrong Dimensions!");
		}
		System.out.println("Enter The dimensions for Matrix A");
		input = new Scanner(System.in);
		A1 = input.nextInt();
		A2 = input.nextInt();
		
		if(A1 <=0 || A2 <= 0)
			flag = false;
		else
			break;
		
		}
		
		
	}
	private static void fillMatrix()
	{
		A =new int[A1][A2];
		System.out.println("Enter The elements of Matrix A, Row by Row");
		for(int i= 0 ;i<A1;i++)
		{
			for(int j=0;j<A2;j++)
			{
				A[i][j] = input.nextInt();
			}
		}
	
		
		
	}
	private static void getRequest()
	{
	System.out.println("Choose any of the following services :");
	System.out.println("1: transpose 2:Determinant");
	boolean flag = false;
	int c = 0;
	while(!flag)
	{
		if(c>=1)
		{
			System.out.println("Re-enter the request,Please!");
		}
	  request = input.nextInt();
	  c++;
	  if(request == 1 || request == 2 || ((request == 1) && (A1 !=A2)))
		  flag = true;
	}
	
	
	}

}
