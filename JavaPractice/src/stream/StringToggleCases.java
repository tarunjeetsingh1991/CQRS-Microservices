package stream;

import java.util.function.Predicate;

public class StringToggleCases 
{
	public static void main(String[] args) 
	{
		String test = "TarunJeet";
		// res = tARUNjEET;
		
		String res = test.chars().mapToObj(c ->(char) c).map(ch -> {
			if(Character.isUpperCase(ch))
				return Character.toLowerCase(ch);
			else if(Character.isLowerCase(ch))
				return Character.toUpperCase(ch);
			else
				return ch;
			})
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
			.toString();
		
		System.out.println(res);
		
		//Another way using predicates
		Predicate<Character> upper =  Character::isUpperCase;
		Predicate<Character> lower =  Character::isLowerCase;

		String res1 = test.chars().mapToObj(c ->(char) c).map(ch -> upper.test(ch) ? Character.toLowerCase(ch) : 
						lower.test(ch) ? Character.toUpperCase(ch) : ch)
						.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
						.toString();
		System.out.println(res1);
	}

}
