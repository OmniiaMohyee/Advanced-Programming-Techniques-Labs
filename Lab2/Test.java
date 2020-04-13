package assign2;

import java.util.Scanner;

public class Test {
	
	private static int A1,A2,B1,B2;
	private static int[][] A;
	private static int[][] B;
	private static int[][] C;
	private static Scanner input; 
	
	public static void main(String[] args) throws InterruptedException
	{
		GetDimensions();
		fillarrays();
		printarrays();
		Multiply M1 = new Multiply(A,B,C);
		Multiply M2 = new Multiply(A,B,C);
		Thread t1 = new Thread(M1);
		Thread t2 = new Thread(M2);
		t1.setName("1");
		t2.setName("2");
		t1.start();
		t2.start();
		
		// we need to use join, because each thread is processing
		// half of the matrix and we need both to print out the result.
		t1.join();
		t2.join();
		
		for(int i = 0 ;i<A1;i++)
		{
			for(int j = 0;j<B2;j++)
			{
				System.out.print(C[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		return;
	
	}
	private static void GetDimensions()
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
		System.out.println("Enter The dimensions for Matrix B");
		B1 = input.nextInt();
		B2 = input.nextInt();
		
		if(A2 != B1)
		{
			flag = false;
		}
		else
			break;
		
		}
		
		
	}
	private static void fillarrays()
	{
		A =new int[A1][A2];
		B = new int[B1][B2];
		C = new int[A1][B2];
		System.out.println("Enter The dimensions of Matrix A, Row by Row");
		for(int i= 0 ;i<A1;i++)
		{
			for(int j=0;j<A2;j++)
			{
				A[i][j] = input.nextInt();
			}
		}
		System.out.println("Enter The dimensions of Matrix B, Row by Row");
		for(int i= 0 ;i<B1;i++)
		{
			for(int j=0;j<B2;j++)
			{
				B[i][j] = input.nextInt();
			}
		}
		
		
	}
	private static void printarrays()
	{
		for(int i= 0 ;i<A1;i++)
		{
			for(int j=0;j<A2;j++)
			{
				System.out.print(A[i][j]);
				System.out.print(" ");
			}
			System.out.print('\n');
		}
		
		for(int i= 0 ;i<B1;i++)
		{
			for(int j=0;j<B2;j++)
				{
					System.out.print(B[i][j]);
					System.out.print(" ");
				}
				System.out.print('\n');
		}
	}

}
