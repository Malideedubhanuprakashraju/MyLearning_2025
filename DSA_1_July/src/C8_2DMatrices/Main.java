package C8_2DMatrices;

import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) 
	{
		//Matrix =Mat[rows][Columns];
		//Mat[N][M]--->N-rows, M Columns
		//Iterate on Row, Column Changes[0...M-1]
		//Iterate on Col, Row Changes[0....N-1]
		//Q) Sum of all Elemnts in Ith Row ..?
		int mat[][]= {{1,0,3},{4,5,6},{0,8,9}};
		int sum=SumIthrow(mat,0);
		System.out.println(sum);
		//Q) Sum of All Matrix
		int SumAll=SumOfAllM(mat);
		System.out.println(SumAll);
		//Q)Given Squre Matrix,Print Anti Diagonal{Top Right-->Bottom Left}
		//Squre=>rows=Columns
		PrintAntiDiag(mat);
		//Q)Given Matrix Print All Diagonals in a Matrix(Right-Left)(Top-Down)Not Squre Matrix
		printAllAnt(mat);
		//Start Points are all elements in 0th row & M-1 Col
		//1)Take every cell in 0th row as Start Point & Call Function
		//2)Take every cell in M-1th col as Start Point & Cell Function
		//Q)Given N*N Matrix:
		//Return all Right to Left Diagonals in ArrayList
		//Note :Each Diagonal Store it in a Arralist
		//Note :All ArrayList Should have Same no of elemnts
		//Note :If a Particular Arraylist has lesser elemnts add them With )
		ArrayList<ArrayList<Integer>> ar=printAlD(mat);
		System.out.println();
		for(ArrayList<Integer> df:ar)
		{
			System.out.println(df);
		}
		//Q)Row to Column Zero
		//You are given a 2D integer Matrix A.
		//if A[i][j]=0 Make All The Elemnts in a ith row & Jth Column Zero
		int anss[][]=modify(mat);
		for(int i=0;i<anss.length;i++)
		{
			for(int j=0;j<anss[0].length;j++)
			{
				System.out.print(anss[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] modify(int[][] a) 
	{
		
		 int n=a.length;
		 int m=a[0].length;
		 for(int i=0;i<n;i++)
		 {
			 boolean ch=false;
			 for(int j=0;j<m;j++)
			 {
				 if(a[i][j]==0)
				 {
					 ch=true;
					 break;
				 }
			 }
			 if(ch)
			 {
				 for(int j=0;j<m;j++)
				 {
					 if(a[i][j]!=0)
					 {
						 a[i][j]=-1;
					 }
				 }
			 }
		 }
		 for(int j=0;j<m;j++)
		 {
			 boolean ch=false;
			 for(int i=0;i<n;i++)
			 {
				 if(a[i][j]==0)
				 {
					 ch=true;
					 break;
				 }
			 }
			 if(ch)
			 {
				 for(int i=0;i<n;i++)
				 {
					 if(a[i][j]!=0)
					 {
						 a[i][j]=-1;
					 }
				 }
			 }
		 }
		 for(int i=0;i<n;i++)
		 {
			for(int j=0;j<m;j++)
			{
				if(a[i][j]==-1)
				{
					a[i][j]=0;
				}
			}
		 }
		 return a;
	}

	private static ArrayList<ArrayList<Integer>> printAlD(int[][] mat) 
	{
		 ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		 int n=mat.length;
		 for(int j=0;j<n;j++)
		 {
			 ArrayList<Integer> temp=AntiS(0,j,mat);
			 ans.add(temp);
		 }
		 System.out.println();
		 for(int i=0;i<n;i++)
		 {
			 ArrayList<Integer> t=AntiS(i,n-1,mat);
			 ans.add(t);
		 }
		 
		 return ans;
	}

	private static ArrayList<Integer> AntiS(int r, int c, int[][] mat) 
	{
		 int n=mat.length;
		 ArrayList<Integer> dig=new ArrayList<>();
		 while(r<n && c>=0)
		 {
			 dig.add(mat[r][c]);
			 r++;
			 c--;
		 }
		 int cd=n-dig.size();
		 for(int i=0;i<cd;i++)
		 {
			dig.add(0); 
		 }
		 return dig;
	}

	private static void printAllAnt(int[][] mat)
	{
		 int n=mat.length;
		 int m=mat[0].length;
		 for(int j=0;j<m;j++)
		 {
			 AntiStart(0,j,mat);
		 }
		 for(int i=1;i<n;i++)
		 {
			 AntiStart(i,m-1,mat);
		 }
	}

	private static void AntiStart(int r, int c, int[][] mat)
	{
		int n=mat.length;
		while(r<n && c>=0)
		{
			System.out.print(mat[r][c]+" ");
			r++;
			c--;
		}
	}

	private static void PrintAntiDiag(int[][] mat) 
	{
		 int n=mat.length;
		 int r=0,c=n-1;
		 while(r<n && c>=0)
		 {
			 System.out.println(mat[r][c]);
			 r++;
			 c--;
		 }
	}

	private static int SumOfAllM(int[][] mat) 
	{
		 int n=mat.length;
		 int m=mat[0].length;
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 sum=sum+mat[i][j];
			 }
		 }
		 return sum;
	}

	private static int SumIthrow(int[][] mat, int r) 
	{
		 int m=mat[0].length;
		 int sum=0;
		 for(int j=0;j<m;j++)
		 {
			 sum=sum+mat[r][j];
		 }
		 return sum;
	}

}
