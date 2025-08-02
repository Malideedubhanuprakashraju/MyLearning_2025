package D3_Arrays2;

public class Main 
{

	public static void main(String[] args) 
	{
		 //Q) Given matrix(squre) Print Boundary in Clockwise Direction
		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
		printBoundary(mat);
		 /*
		   | Metric           | Complexity |
		   | ---------------- | ---------- |
		   | Time Complexity  | **O(n)**   |
		   | Space Complexity | **O(1)**   |

		 */
		//Q) Sprial Printing
		//After 1 Full Boundary
		//i++,j++,N=N-2
		SpiralPrinting(mat);
		//Q) Given Matrix Find Sum of All Submatrices Sum
		//Sum Of All : Contribution Technique = Add Contribution of Individual Ele in Final
		//For any Elemnt Contribution= Ele * Occur
		//Occur= Count no of times ele is present in SubMatrix
		//TL=(i+1)(j+1)
		//BR=(N-i)(M-j)
		//SubMatrices with Cell(i,j)=TL*BR
		//(i,j)=(i+1)(j+1)(n-i)(m-j)
		int ar[][]= {{3,1},{-1,-2},{2,4}};
		int ans=SumSubMatr(ar);
		System.out.println();
		System.out.println("SubSum-->"+ans);
		boolean ans1=matSearch(mat,7);
		System.out.println(ans1);
		//We can Start Search from Top Right or Bottom Left
		//At Each Iteration : Skip Row or Skip Col
		//Total Rows=N
		//Total Colums=M
		//Total Iterations=N+M
	}

	private static boolean matSearch(int[][] mat, int k) //T.C=O(N+M), S.C=O(1)
	{
		//TR
//		 int n=mat.length;
//		 int m=mat[0].length;
//		 int i=0,j=m-1;
//		 while(i<n && j>=0)
//		 {
//			 if(mat[i][j]==k)
//			 {
//				 return true;
//			 }
//			 if(mat[i][j]<k)
//			 {
//				 i++;//Skip Row : Go to Down
//			 }
//			 else
//			 {
//				 j--;//Skip Col : go to Left
//			 }
//		 }
//		 return false;
		
		//BL
		int n=mat.length;
		 int m=mat[0].length;
		 int i=n-1,j=0;
		 while(j<m && i>=0)
		 {
			 if(mat[i][j]==k)
			 {
				 return true;
			 }
			 if(mat[i][j]<k)
			 {
				 i--;//Skip Row : Go to Down
			 }
			 else
			 {
				 j++;//Skip Col : go to Left
			 }
		 }
		 return false;
	}

	private static int SumSubMatr(int[][] mat) 
	{
		 int n=mat.length;
		 int m=mat[0].length;
		 int ans=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 int tl=(i+1)*(j+1);
				 int br=(n-i)*(m-j);
				 ans=ans+mat[i][j]*(tl*br);
			 }
		 }
		 return ans;
	}

	private static void SpiralPrinting(int[][] mat) //O(N2), O(1)
	{
		int n=mat.length;
		int i=0,j=0;
		
		while(n>1)//If n==0 or 1: Stop Code
		{
			//Step :1 Print N-1 Ele in 0th Row-->L-->R
			for(int l=1;l<n;l++)//N-1 iterations
			{
				System.out.print(mat[i][j]);
				j++;
			}
			//step :2 Print N-1 Ele in Last Col :T-->D
			for(int l=1;l<n;l++)
			{
				System.out.print(mat[i][j]);
				i++;
			}
			//Step :3 Print N-1 Ele in 0th Col :R-->L
			for(int l=1;l<n;l++)
			{
				System.out.print(mat[i][j]);
				j--;
			}
			//Step :4 Print N-1 Ele in 0thCol :B-->T
			for(int l=1;l<n;l++)
			{
				System.out.print(mat[i][j]);
				i--;
			}
			i++;
			j++;
			n=n-2;
			
		}
		if(n==1)
		{
			System.out.print(mat[i][j]);
		}
		 
		
	}

	private static void printBoundary(int[][] mat) //O(N), O(1)
	{
		int n=mat.length;
		int i=0,j=0;
		
		//Step :1 Print N-1 Ele in 0th Row-->L-->R
		for(int l=1;l<n;l++)//N-1 iterations
		{
			System.out.println(mat[i][j]);
			j++;
		}
		//step :2 Print N-1 Ele in Last Col :T-->D
		for(int l=1;l<n;l++)
		{
			System.out.println(mat[i][j]);
			i++;
		}
		//Step :3 Print N-1 Ele in 0th Col :R-->L
		for(int l=1;l<n;l++)
		{
			System.out.println(mat[i][j]);
			j--;
		}
		//Step :4 Print N-1 Ele in 0thCol :B-->T
		for(int l=1;l<n;l++)
		{
			System.out.println(mat[i][j]);
			i--;
		}
		if(n==1)
		{
			System.out.println(mat[i][j]);
		}
		
	}

}
