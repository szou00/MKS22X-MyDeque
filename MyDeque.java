import java.util.*;
import java.util.Arrays;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = -1;
    end = -1;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = -1;
    end = -1;
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
    if (start == -1) { //if the list is empty
      data[0] = element; //add to the list
      start = 0; //both start and end get 0
      end = 0;
      size++; //size increases
    }
    else {
      if (start != 0 && data[start-1] != null) { //if start isn't the beg of the list and there's no more
        // System.out.println("resizing");
        resize(); //space to add to the front, resize
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
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (end+1 >= data.length || data[end+1] != null) {
      resize();
    }
    if (end == -1) {
      data[0] = element;
      end++;
      start = 0;
      return;
    }
    data[end+1] = element;
    end++;
    System.out.println(Arrays.toString(data));
  }

  public E removeFirst(){
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
    if (start == -1) {
      throw new NoSuchElementException();
    }
    E first = data[start];
    // System.out.println(Arrays.toString(data));
    if (start == 0) {
      data[start] = null;
      if (end != start+1) {
        start++;
      }
      else {
        start--;
      }
      return first;
    }
    if (start == size-1) {
      data[start] = null;
      start = 0;
      return first;
    }
    if (start == end) { //when everything is removed, the list is empty
      data[start] = null;
      start = -1;
      end = -1;
      return first;
    }
    data[start] = null;
    start++;
    return first;
  }

  public E removeLast() {
    if (start == -1) {
      throw new NoSuchElementException();
    }
    E last = data[end];
    data[end] = null;
    end--;
    return last;
  }

  public E getFirst(){
    if (start == -1) {
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast() {
    if (start == -1) {
      throw new NoSuchElementException();
    }
    return data[end];
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] newData = (E[])new Object[size *2];
    String ans = "";
    int index = 0;
    for (int i = start; i<size;i++) {
      newData[index] = data[i];
      index++;
    }
    if (start > 0) {
      for (int i = 0; i < start; i++) {
        newData[index] = data[i];
        index++;
      }
    }
    // System.out.println("reassigning");
    start = 0;
    end = data.length-1;
    size = size * 2;
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
