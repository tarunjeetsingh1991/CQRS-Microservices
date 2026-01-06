package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeArrays {
	
	public static void main(String[] args) 
	{
		int[] arr1 = {5,4,1,2,3};
		int[] arr2 = {8,6,1,3,6,5};
		
		// result : {1,2,3,4,5,6,8};
		
		 List<Integer> list = IntStream
	                .concat(Arrays.stream(arr1), Arrays.stream(arr2))
	                .distinct()
	                .sorted()
	                .boxed()
	                .collect(Collectors.toList());
		 
		 System.out.println(list);
	}

}
