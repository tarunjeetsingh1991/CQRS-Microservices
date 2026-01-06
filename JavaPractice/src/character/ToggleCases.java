package character;

public class ToggleCases 
{
	public static String toggle(String str) 
	{
	    StringBuilder sb = new StringBuilder();

	    for (char ch : str.toCharArray()) 
	    {
	        if (Character.isUpperCase(ch)) 
	        {
	            sb.append(Character.toLowerCase(ch));
	        } 
	        else if (Character.isLowerCase(ch)) 
	        {
	            sb.append(Character.toUpperCase(ch));
	        }
	        else 
	        {
	            sb.append(ch);
	        }
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) 
    {
        System.out.println(toggle("TarunJEETSinGH@1991!"));
        System.out.println(toggle("ABCefg123...@XYzZ"));
    }

}
