public class IdentityMatrix extends Matrix
{
    public IdentityMatrix()
    {     
        Scanner M1 = new Scanner(System.in);  // Reading from System.in
        Scanner N1 = new Scanner(System.in);  // Reading from System.in
        M= M1;
        N= N1;
        super();
    }

    public boolean SetNumbers(int[]arr)
    {
        if(arr.length<M*N || M != N)
            return false;
        int k=0;
        for (int i = 0; i <= M; i++) 
            for (int j = 0; j <= N; j++) 
            {
                if(i==j && arr[k]!= 1)
                    return false;
                else if(i != j && arr[k]!= 0)
                    return false;
                A[i][j]=arr[k];
                k ++;
            }
        return true;
    }

    public int[] Transpose()
    {
        int[]arr = new int[M*N];
        int k=0;
        for (int i = 0; i <= M; i++) 
            for (int j = 0; j <= N; j++) 
            {        
                arr[k] = Matrix[i][j];
                k++;
            }
        return arr;
    }
  
}