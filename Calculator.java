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
      System.out.println(Arrays.toString(ary)); //print out for testing

      MyDeque operations = new MyDeque(ary.length); //create a MyDeque to use
      int i = 0; //use this to go through the ary
      String operators = "+-*/%";

      while (i!=ary.length) { //while we haven't reached the end of the array
        if (!(operators.contains(ary[i]))) { //if the current value is not an operation
          operations.addLast(Integer.parseInt(ary[i])); //add the value to the end of the deque
        }
        else { //otherwise remove the last two values and perform the operation on them, and then
          //add that back to the list
          int result = operations.removeLast() + operations.removeLast();
          //HARD CODE?? IS THERE ANY OTHER WAY

          operations.addLast(result);
        }
      }
      return operations.getFirst(); //there should only be one element left in the array ?? so return that 
    }

    public static void main(String[] args) {
      eval("10 2.0 +");
    }
}
