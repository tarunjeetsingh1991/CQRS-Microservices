package map;

import java.util.*;
import java.util.stream.Collectors;

public class Streams 
{
	public static void main(String[] args) 
	{
		HashMap<String,Integer>mp = new LinkedHashMap<>();
		mp.put("Java", 90);
		mp.put("C++", 81);
		mp.put("Python", 87);
		mp.put("SQL", 75);
		mp.put("C#", 84);
		
		ArrayList<Map.Entry<String, Integer>> al = new ArrayList<>(mp.entrySet());
		al.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		
		List<Map.Entry<String, Integer>> sortedName = al.stream()
				.sorted((s1,s2) -> s1.getKey().compareTo(s2.getKey()))
				.collect(Collectors.toList());
		sortedName.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		
		List<Map.Entry<String, Integer>> sortedMarks = al.stream()
				.sorted((s1,s2) -> s1.getValue() - s2.getValue())
				.collect(Collectors.toList());
		sortedMarks.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		System.out.println("Converting back to Map...........");
		
		HashMap<String,Integer>res = new LinkedHashMap<>();
		for(Map.Entry<String, Integer>e : sortedMarks)
		{
			res.put(e.getKey(), e.getValue());
		}
		
		System.out.println(res);
	}

}
