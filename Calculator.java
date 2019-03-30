import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */

     /**
     1. Convert your string into tokens. (A list of values and operators)
     1b. Test this by printing each one!
     2. Instead of printing each one, decide what to do with them...
    */

    public static double eval(String s){
      ArrayList<String> exp = new ArrayList<String>();
      String[] ary = s.split(" ");
      System.out.println(Arrays.toString(ary));
      return 0.0;
    }

    public static void main(String[] args) {
      eval("10 2.0 +");
    }
}
