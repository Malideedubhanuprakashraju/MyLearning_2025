package P5_Backtracking2;

public class AllPathsRectangularBoard 
{

	public static void main(String[] args) 
	{
		int A=5,B=7;
		solve(A,B);
	}

	private static void solve(int a, int b) 
	{
		 String path="";
		 printPaths(0,0,path,a,b);
	}

	private static void printPaths(int r, int c, String path, int a, int b) 
	{
		if(r==a-1 && c== b-1)
		{
			System.out.println(path);
			return;
		}
		if(r+1<a)
		 printPaths(r+1,c,path+"D",a,b);
		if(c+1<b)
		 printPaths(r,c+1,path+"R",a,b);
		return;
	}

}
