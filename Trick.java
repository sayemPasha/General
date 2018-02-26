package basic;

public class Trick {
    public static void main(String[] args) {
        //number conversion
        String number ="111";
        int base1 = 8;
        int base2   = 10;
        String out = "unknown";
        try {
            out = Integer.toString(Integer.parseInt(number, base1), base2);
            System.out.println(out);
        }
        catch (NumberFormatException e)
        {
            System.out.printf("Cannot be represented in base2");
        }
    }
}
