import java.util.*;
import java.util.Arrays;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "{"; //ans will store the contents of the string
    if (start == -1) { //if there's nothing
      return ans + "}"; //only {} is printed
    }
    for (int i = start; i < data.length;i++) { //otherwise, values from start to the end
      if (data[i] != null) { //besides null
        ans += data[i] + " "; //are added
      }
    }
    if (start > 0) { //if start wasn't zero
      for (int i = 0; i < start; i++) { //need to circle back around and add all the values
        if (data[i] != null) { //besides null
          ans += data[i] + " "; //but up until start, to the end
        }
      }
    }
    return ans + "}"; //other bracket is added
  }

  public void addFirst(E element){
    if (element == null) { //if the element is null, throws an excpetion
      throw new NullPointerException();
    }
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
    if (size==0) { //if the list is empty
      data[start] = element; //add to the list
      size++; //size increases
      return;
    }
    if (size==data.length-1) { //if there's no more space in the list
      // System.out.println("resizing");
      resize(); //resize
    }
    if (start == 0) { //if start is the beg already
      // System.out.println("start is 0");
      data[data.length-1] = element; //add element to the end
      start = data.length-1; //move start
      size++;
      return;
    }
      // System.out.println(Arrays.toString(data));
    data[start-1] = element; //otherwise keeps adding to the one before start
    start--;
    size++;
    return;
  }

  public void addLast(E element){
    if (element == null) { //if element is null, throw an exception
      throw new NullPointerException();
    }
    if (end+1 >= data.length || data[end+1] != null) { //if there's no where else to add it, resize
      resize();
    }
    if (end == -1) { //if it's an empty list
      data[0] = element; //add to the list;
      end++; //increase both start and end by one
      start = 0;
      size++; //increase size by one
      return;
    }
    data[end+1] = element; //otherwise, add to the end of the list
    end++; //increase end
    size++; //increase size
    // System.out.println(Arrays.toString(data));
  }

  public E removeFirst(){
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
    if (size==0) { //if it's an empty list, throw an exception
      throw new NoSuchElementException();
    }
    E first = data[start]; //store the targeted element
    // System.out.println(Arrays.toString(data));
    if (start == 0) { //if start is at the beg
      data[start] = null; //remove it
      if (end != start+1) { //if there's more to the list
        start++; //the next element becomes the first one
      }
      else {
        start--; //otherwise start becomes -1
      }
      size--; //size decreases
      return first; //return the element
    }
    if (start == data.length-1) { //if start is the end of the list
      data[start] = null; //remove element
      start = 0; //start goes back to beg
      size--; //size decreases
      return first; //return element
    }
    if (start == end) { //when everything is removed, the list is empty
      data[start] = null; //element is removed
      start = -1; //both start and end decrease
      end = -1;
      size--; //size decreases
      return first;
    }
    data[start] = null; //for all other cases, remove element
    start++; //start increases
    size--; //size decreases
    return first;
  }

  public E removeLast() {
    if (size==0) { //if list is empty, throw exception
      throw new NoSuchElementException();
    }
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
    E last = data[end]; //store the element
    if (end == 0) { //if the end is at the beg of the list
      if (start > 0) { //if there's more to the list
        data[end] = null; //remove the end
        end = data.length-1; //the element at the end of the list becomes the end
        size--; //size decreases
        return last;
      }
    } //otherwise
    data[end] = null; //remove it
    end--; //end just becomes the end
    size--; //size decreases
    // System.out.println(Arrays.toString(data));
    return last;
  }

  public E getFirst(){
    if (size==0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast() {
    if (size==0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }

  //resizing
  @SuppressWarnings("unchecked")
  public void resize() {
    System.out.println(Arrays.toString(data));
    E[] newData = (E[])new Object[size *2];
    String ans = "";
    int index = 0;
    for (int i = start; i<data.length;i++) {
      // System.out.println(Arrays.toString(newData));
      newData[index] = data[i];
      index++;
    }
    if (start > 0) {
      for (int i = 0; i < start; i++) {
        // System.out.println(Arrays.toString(newData));
        newData[index] = data[i];
        index++;
      }
    }
    // System.out.println("reassigning");
    start = 0;
    end = size;
    data = newData;

  }

  public static void main(String[] args) {
    MyDeque<String> test = new MyDeque<String>(8);
    System.out.println(test);
    // System.out.println(test.size());
    String str = "abcdefghijk";
    for (int i =  0;i < str.length();i++) {
      test.addFirst(str.substring(i,i+1));
      System.out.println(test);
    }
    // for (int i =  0;i < str.length();i++) {
    //   test.removeFirst();
    //   System.out.println(test);
    // }
    // for (int i =  0;i < str.length();i++) {
    //   test.addLast(str.substring(i,i+1));
    //   System.out.println(test);
    // }
    // for (int i =  0;i < str.length();i++) {
    //   test.removeLast();
    //   System.out.println(test);
    // }
    // test.addFirst("c");
    // // test.removeFirst();
    // System.out.println(test);
    // test.addFirst("b");
    // System.out.println(test);
    // test.addFirst("a");
    // System.out.println(test);
    // test.addLast("d");
    // System.out.println(test);
    // test.addLast("e");
    // System.out.println(test);
    // test.removeFirst();
    // System.out.println(test);
    // test.removeLast();
    // System.out.println(test);
    // System.out.println(test.getFirst());
    // System.out.println(test.getLast());
  }
}
