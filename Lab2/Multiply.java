package assign2;

public class Multiply implements Runnable {

	public int[][]A;
	public int[][]B;
	public int[][]C;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (Thread.currentThread().getName().equals("1")) {
			for(int i = 0 ;i<A.length;i++)
			{
				
				for(int j = 0 ;j<B[0].length/2;j++)
				{
					C[i][j] = 0; 
					for(int k = 0 ;k<A[0].length;k++)
						{
						C[i][j] += A[i][k] * B[k][j];
						}
					System.out.println("Thread 1 :C["+Integer.toString(i)+
							"]["+Integer.toString(j)+"] = "+Integer.toString(C[i][j]));
				}
				
			}
		}

		else 
		{
	
			for(int i = 0 ;i<A.length;i++)
			{
				for(int j = B[0].length/2 ;j<B[0].length;j++)
				{
					C[i][j] = 0; 
					for(int k = 0 ;k<A[0].length;k++)
					{
						C[i][j] += A[i][k] *B[k][j];
					}
					System.out.println("Thread 2 :C["+Integer.toString(i)+
							"]["+Integer.toString(j)+"] = "+Integer.toString(C[i][j]));
				}
					
			}
			
		}
		
	}
	public Multiply(int [][]A, int[][]B,int[][]C)
	{
		this.A = A;
		this.B = B;
		this.C = C;
	}
	

}
