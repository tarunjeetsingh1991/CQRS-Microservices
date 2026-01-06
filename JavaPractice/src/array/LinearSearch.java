package array;

public class LinearSearch 
{
	public static int linear(int[] arr,int n, int k)
	{
		for(int i=0; i<n; i++)
		{
			if(arr[i] == k)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) 
	{
		long start = System.nanoTime();
		
		int size = 1000000;
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++)
		{
			arr[i] = i+1;
		}
		
		for(int i=0; i<size; i++)
		{
			int x = linear(arr, size, arr[i]);
			if(x != -1)
				System.out.println("Element " + arr[i] + " is at : " + x + " position");
		}
		
		long end = System.nanoTime();

	    long executionTime = (end - start) / 1000000;
	    System.out.println();
	    System.out.println("Time is : " + executionTime + "ms");
	}

}
