package character;

public class ToggleCaseXOR 
{
    public static String toggle(String str) 
    {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) 
        {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) 
            {
                sb.append((char) (ch ^ 32));
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

