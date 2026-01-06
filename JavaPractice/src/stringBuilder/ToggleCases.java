package stringBuilder;

public class ToggleCases 
{
    public static String toggle(String str) 
    {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') 
            {
                res.append((char) (ch + 32));
            } 
            else if (ch >= 'a' && ch <= 'z') 
            {
                res.append((char) (ch - 32));
            } 
            else 
            {
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) 
    {
        System.out.println(toggle("TarunJEETSinGH@1991!"));
        System.out.println(toggle("ABCefg123...@XYzZ"));
    }
}

