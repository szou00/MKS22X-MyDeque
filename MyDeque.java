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
    size = initialCapacity;
    start = -1;
    end = -1;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "{";
    if (start == -1) {
      return ans + "}";
    }
    for (int i = start; i < size;i++) {
      if (data[i] != null) {
        ans += data[i] + " ";
      }
    }
    if (start > 0) {
      for (int i = 0; i < start; i++) {
        if (data[i] != null) {
          ans += data[i] + " ";
        }
      }
    }
    return ans + "}";
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
    if (start == -1) {
      data[0] = element;
      start = 0;
      end = 0;
    }
    else {
      if (start != 0 && data[start-1] != null) {
        // System.out.println("resizing");
        resize();
      }
      if (start == 0) {
        // System.out.println("start is 0");
        data[size-1] = element;
        start = size-1;
        end++;
        return;
      }
      // System.out.println(Arrays.toString(data));
      data[start-1] = element;
      start--;
      end++;
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (data[end+1] != null) {
      resize();
    }
    data[end+1] = element;
    end++;
  }

  public E removeFirst(){
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
    data[start] = null;
    start++;
    // System.out.println("start: " + start + " end: " + end + " size: " + size);
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
    for (int i =  0;i < str.length();i++) {
      test.removeFirst();
      System.out.println(test);
    }
    for (int i =  0;i < str.length();i++) {
      test.addLast(str.substring(i,i+1));
      System.out.println(test);
    }
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
