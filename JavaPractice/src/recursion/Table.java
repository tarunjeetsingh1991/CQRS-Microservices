package recursion;

public class Table 
{
	public static void printTable(int n,int i)
	{
		if(i==11)
			return;
		
		System.out.println(n + " X " + i + " = " + n*i);
		printTable(n,i+1);
	}
	public static void main(String[] args) 
	{
		printTable(3,1);
	}

}
