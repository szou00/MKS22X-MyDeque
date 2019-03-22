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
    size = initialCapacity;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "";
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
    return ans;
  }

  public void addFirst(E element){
    if (start == 0) {
      data[start] = element;
      start+=1;
      end+=1;
    }
    else {
      data[size-1] = element;
      start = size-1;
    }
  }

  public void addLast(E element){
    if (size == end) {
      resize();
    }
  }
  // public E removeFirst(){ }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }

  public void resize() {}

  public static void main(String[] args) {
    MyDeque<String> test = new MyDeque<String>(8);
    System.out.println(test);
    // System.out.println(test.size());
    test.addFirst("h");
    System.out.println(test);
    test.addFirst("c");
    System.out.println(test);

  }
}
