package set;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesString 
{
	public static HashSet<Character> duplicates(String st)
	{
		HashSet<Character> seen = new HashSet<>();
		HashSet<Character> temp = new HashSet<>();
		
		for(char ch : st.toCharArray())
		{
			if(!seen.add(ch))
			{
				temp.add(ch);
			}
		}
		
		return temp;
	}
	
	public static HashSet<Character> duplicatesStream(String st)
	{
		HashSet<Character> seen = new HashSet<>();
		HashSet<Character> temp = new HashSet<>();
		
		temp = (HashSet<Character>) st.chars().mapToObj(c -> (char)c)
				.filter(c -> !seen.add(c))
				.collect(Collectors.toSet());
		
		return temp;
	}
	public static void main(String[] args)
	{
		String s1 = "hello world";
		
		HashSet<Character> res = duplicates(s1);
		System.out.println(res);
		
		HashSet<Character> resStream = duplicatesStream(s1);
		System.out.println(resStream);
	}
}
