package string;

public class ToggleCases 
{
	public static String toggle(String str)
	{
		String res = "";
		for(int i=0; i<str.length(); i++)
		{
			int asciiValue = (int)str.charAt(i);
			
			if(asciiValue >= 65 && asciiValue <= 90)
			{
				asciiValue += 32;
			}
			else if(asciiValue >= 97 && asciiValue <= 122)
			{
				asciiValue -= 32;
			}
			else
			{
				asciiValue += 0;
			}
			res += (char)asciiValue;
		}
		return res;
	}
	
	public static void main(String[] args) 
	{
		String s1 = "TarunJEETSinGH@1991!";
		System.out.println(toggle(s1));
		
		String s2 = "ABCefg123...@XYzZ";
		System.out.println(toggle(s2));
	}

}
