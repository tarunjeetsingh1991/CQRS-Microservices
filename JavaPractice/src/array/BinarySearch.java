package array;

public class BinarySearch 
{
	public static int binary(int[] arr,int n, int k)
	{
		int low = 0;
		int high = n;
		while(low <= high)
		{
			int mid = (low+high)/2;
			
			if(arr[mid] == k)
				return mid;
			else if(arr[mid] > k)
				high = mid-1;
			else
				low = mid+1;
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
			int x = binary(arr, size, arr[i]);
			if(x != -1)
				System.out.println("Element " + arr[i] + " is at : " + x + " position");
		}
		
		long end = System.nanoTime();

	    long executionTime = (end - start) / 1000000;
	    System.out.println();
	    System.out.println("Time is : " + executionTime + "ms");
		
	}

}
