package matrix;

public class Table 
{
	public static void printTable(int n)
	{
		int increment = n;
		int[][]arr = new int[10][10];
		
		for(int r=0; r<10; r++)
		{
			for(int c=0; c<10; c++)
			{
				if(r==c)
				{
					arr[r][c] = n;
					System.out.print(arr[r][c] + " ");
				}
				else
				{
					arr[r][c] = 0;
					System.out.print(arr[r][c] + " ");
				}
			}
			n += increment;
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		for(int i=1; i<=10; i++)
		{
			printTable(i);
			System.out.println("----------------------------------");
		}
	}

}
