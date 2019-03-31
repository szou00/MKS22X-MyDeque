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
     + - * / %
    */

    public static double eval(String s){
      String[] ary = s.split(" "); //create an array of values and operators
      // System.out.println(Arrays.toString(ary)); //print out for testing

      MyDeque<Double> operations = new MyDeque<Double>(ary.length); //create a MyDeque to use
      int i = 0; //use this to go through the ary
      String operators = "+-*/%";

      while (i!=ary.length) { //while we haven't reached the end of the array
        if (!(operators.contains(ary[i]))) { //if the current value is not an operation
          operations.addLast(Double.parseDouble(ary[i])); //add the value to the end of the deque
        }
        else { //otherwise remove the last two values and perform the operation on them, and then
          //add that back to the list
          Double result = 0.0;
          if (ary[i].equals("+")) { //if it's addition
            // System.out.println("addition");
            result = operations.removeLast() + operations.removeLast();
          }
          if (ary[i].equals("-")) {
            Double subtracting = operations.removeLast(); //because 5 4 - is equal to 5-4 but 4 is the last
            //value of the list right now!!
            result = operations.removeLast() - subtracting;
          }
          if (ary[i].equals("*")) {
            result = operations.removeLast() * operations.removeLast();
          }
          if (ary[i].equals("/")) {
            Double divisor = operations.removeLast(); //similar to subtraction
            result = operations.removeLast() / divisor;
          }
          if (ary[i].equals("%")) {
            Double divisor = operations.removeLast();
            result = operations.removeLast() % divisor;
          }
          //HARD CODE
          // System.out.println(result);
          operations.addLast(result);
        }
        i+=1;
        // System.out.println(operations);
      }
      return operations.getFirst(); //there should only be one element left in the array ?? so return that
    }

    public static void main(String[] args) {
      System.out.println(eval("10 2.0 +"));
      System.out.println(eval("11 3 - 4 + 2.5 *"));
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
      System.out.println(eval("1 2 3 4 5 + * - -"));
    }
}
