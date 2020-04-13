package assign4;

public class ClientHandler implements Runnable {
	int A1,A2;
	int[][]A;
	int request;
	int pnum;
	ClientHandler(int A1,int A2, int[][]A,int pnum)
	{
		this.A1 = A1;
		this.A2 = A2;
		this.A = A;
		this.pnum = pnum;
	}
	@Override
    public void run()  
    { 
         if(this.pnum == 6660)
         {
        	 System.out.println(determinantOfMatrix(A,A1));
         }
         else
        	 {
        		int [][]result = getTranspose();
        		for(int i =0 ;i<A2;i++)
        			for(int j = 0; j<A1;j++)
        			
        				System.out.print(result[i][j]);
        	 }
       
    }	 
	void getCofactor(int[][]A, int[][] temp, int p, int q, int a) 
	{ 
	    int i = 0, j = 0; 
	    for (int row = 0; row < a; row++) 
	    { 
	        for (int col = 0; col < a; col++) 
	        { 
	            if (row != p && col != q) 
	            { 
	                temp[i][j++] = A[row][col]; 
	                if (j == a - 1) 
	                { 
	                    j = 0; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
	}
	private int determinantOfMatrix(int[][]A,int A1) 
	{ 
	    int D = 0; // Initialize result 
	  
	    //  Base case : if matrix contains single element 
	    if (A1 == 1) 
	        return A[0][0]; 
	  
	    int [][] temp = new int[A1][A1]; // To store cofactors 
	  
	    int sign = 1;  // To store sign multiplier 
	  
	    for (int f = 0; f < A1; f++) 
	    { 
	        getCofactor(A, temp, 0, f, A1); 
	        D += sign * A[0][f] * determinantOfMatrix(temp, A1 - 1); 
	  
	        // terms are to be added with alternate sign 
	        sign = -sign; 
	    } 
	  
	    return D; 
	}
	int[][] getTranspose(){
		int [][]tA = new int[A2][A1];
		for(int i = 0 ;i<A2;i++)
		{
			for(int j = 0 ;j<A1;j++ )
			{
				tA[i][j] = A[j][i]; 
				System.out.print(tA[i][j]+ " ");
			}
			System.out.print('\n');
		}
		return tA;
		
	}
}
