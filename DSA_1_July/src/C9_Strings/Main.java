package C9_Strings;

public class Main 
{

	public static void main(String[] args) 
	{
		//Alphabets :'A'-'Z'
		//Numbers : '0'-'9'
		//Special Characters : '@','#','%'
		//Number : x=7;--->In System Binary :111{Any Number->Binary}
		//Text :y="ab"--->Pre-Assaign Symbol Char->number->Binary
		//ASCII :American Standard Code for Information Exchnage
		//Every Character is Associated with an integer Value
		//'A'-65,66......'Z'-90
		//'a'-97,98......'z'-122
		//'0'-48......'9'-57
		//1st Char-->0
		//128th Char-->127
		//Small in Bigger-Implict
		//Big in Smaller-Explicit
		//ASCII Table :Total 128Chars mapped With 0 to 127 as ASCII Codes
		int x='a';
		System.out.println(x);
		System.out.println('a'+2);
		//Implicit Typecasting
		char c='a';//1B->4B
		int ans=c;
		System.out.println(ans);
		//Explicit Typecasting
		int y=97;
		char ch=(char) y;
		System.out.println(ch);
		//Q)Given a String Convert All Uppercase to Lowercase & return String
		// S='Hello'--->"hELLO"
		String s=Toggle("HellO");
		System.out.println(s);
		//Optimization Code
		//Whenever we have Modify Char
		//String-->char[]-->Modify-->String
		String s1=ToggleOpt("BhaNu");
		System.out.println(s1);
		//Strin Builder : If we have to dynamically add Characters
		//In sb, adding a single char=O(1)
		//Dynamic Array Implementation
		String s2=ToggleSB("PrakashRAJU");
		System.out.println(s2);
		//Substring : Subbarray on String is Considered as Substring
		//Continuous Part of a String
		//Full String is a Substring
		//Palindrome : madam
		//Q)Check if a given Substring is Palindrome or Not ..?
		String str="anamadamspe";
		boolean ansr=isPal(str,3,7);
		System.out.println(ansr);
		//Q)Given a String, Return Length of Longest Palindrome Substring
		String strr="dabbal";
		int a=Palindrome(strr);
		System.out.println(a);
		
	}

	private static int Palindrome(String strr) 
	{
		 int ans=0;
		 int n=strr.length();
		 //S1: Take Every Char as Center & Expand -ODD
		 for(int i=0;i<n;i++)
		 {
			 int p1=i,p2=i;
			 while(p1>=0 && p2<n)
			 {
				 if(strr.charAt(p1)==strr.charAt(p2))
				 {
					 p1--;
					 p2++;
				 }
				 else
				 {
					 break;
				 }
			 }
			 ans=Math.max(ans,p2-p1-1);
		 }
		 // S2 :take Every Adjacent Pair as Centre
		 for(int i=0;i<n;i++)
		 {
			 int p1=i,p2=i+1;
			 while(p1>=0 && p2<n)
			 {
				 if(strr.charAt(p1)==strr.charAt(p2))
				 {
					 p1--;
					 p2++; 
				 }
				 else
				 {
					 break;
				 }
				 ans=Math.max(ans, p2-p1-1);
			 }
			 
		 }
		 return ans;
		 
	}

	private static boolean isPal(String str, int s, int e)//TC=O(N),SC=O(1)
	{
		 int p1=s,p2=e;
		 while(p1<p2)
		 {
			 if(str.charAt(p1)==str.charAt(p2))
			 {
				 p1++;
				 p2--;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 return true;
	}

	private static String ToggleSB(String s) 
	{
		StringBuilder sb=new StringBuilder();
		int n=s.length();
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(ch>=65 && ch<=90)
			{
				ch=(char)(ch+32);
			}
			else
			{
				ch=(char)(ch-32);
			}
			sb.append(ch);
		}
		return sb.toString();
	}

	private static String ToggleOpt(String s)//Optimsed TC=O(N+N+N)=O(N)
	{
		 char[] ch=s.toCharArray();
		 int n=ch.length;
		 for(int i=0;i<n;i++)
		 {
			 if(ch[i]>=65 && ch[i]<=90)
			 {
			     ch[i]=(char)(ch[i]+32);
			 }
			 else
			 {
				 ch[i]=(char)(ch[i]-32);
			 }
		 }
		 return new String(ch);
	}

	private static String Toggle(String s)// Bruit Force TC=O(N*N)=N2 
	{
		 int n=s.length();
		 String ans="";
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 if(ch>=65 && ch<=90)
			 {
				 ch=(char)(ch+32);
			 }
			 else
			 {
				 ch=(char)(ch-32);
			 }
			 ans=ans+ch;
		 }
		 return ans;
	}

}
