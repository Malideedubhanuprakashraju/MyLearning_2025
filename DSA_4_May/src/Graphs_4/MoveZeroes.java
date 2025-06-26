package Graphs_4;

public class MoveZeroes 
{

	public static void main(String[] args) 
	{
		 int A[]= {3,4,0,0,8,9,0};
		 int ans[]=moveZeros(A);
		 System.out.println("Move Zeros-----> Last Elements");
		 for(int x:ans)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
		 System.out.println("Move Zeros-----> First Elemnts ");
		 int ans1[]=moveZero(A);
		 for(int x:ans1)
		 {
			 System.out.print(x+" ");
		 }
	}

	private static int[] moveZero(int[] a) 
	{
		 int ans[]=new int[a.length];
		 int j=0;
		 for(int i=0;i<a.length;i++)
		 {
			 if(a[i]==0)
			 {
				 ans[j++]=0;
			 }
		 }
		 for(int i=0;i<a.length;i++)
		 {
			 if(a[i]!=0)
			 {
				 ans[j]=a[i];
				 j++;
			 }
		 }
		 return ans;
	}

	private static int[] moveZeros(int[] a) 
	{
		 int Ans[]=new int[a.length];
		 int j=0;
		 for(int i=0;i<a.length;i++)
		 {
			 if(a[i]!=0)
			 {
				 Ans[j]=a[i];
				 j++;
			 }
		 }
		 return Ans;
	}

}
