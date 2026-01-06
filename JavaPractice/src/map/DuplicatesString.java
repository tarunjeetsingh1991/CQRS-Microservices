package map;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DuplicatesString 
{
	public static HashMap<Character, Integer> duplicateCount(String st)
	{
		HashMap<Character, Integer>temp = new HashMap<>();
		
		for(char ch : st.toCharArray())
		{
			temp.put(ch, temp.getOrDefault(ch,0) + 1);
		}
		return temp;
	}
	public static void main(String[] args) 
	{
		String s1 = "hello world";
		HashMap<Character, Integer> mp = duplicateCount(s1);
		//System.out.println(mp);
		
		for (Map.Entry<Character, Integer> e : mp.entrySet())
		{
			if(e.getValue() > 1)
			{
				System.out.println(e.getKey() + " : " + e.getValue());
			}
		}
		
		System.out.println("One liner solution : -------------------");
		
		List<Entry<Character, Integer>> list = mp.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.collect(Collectors.toList());
				
		System.out.println(list);
		
		
		mp.entrySet().stream()
		.filter(e -> e.getValue() > 1)
		.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
		
		
	}

}
