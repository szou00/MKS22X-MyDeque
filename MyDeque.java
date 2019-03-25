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
    if (start == -1) {
      data[0] = element;
      start = 0;
      end = 0;
    }
    else {
      if (start == 0) {
        data[size-1] = element;
        start = size-1;
        end++;
        return;
      }
      if (data[start-1] != null) {
        resize();
      }
      data[start-1] = element;
      start--;
      end++;
    }
  }

  public void addLast(E element){
    if (data[end+1] != null) {
      resize();
    }
    data[end+1] = element;
    end++;
  }

  public E removeFirst(){
    E first = data[start];
    if (start == 0) {
      data[start] = null;
      start--;
      return first;
    }
    data[start] = null;
    start++;
    return first;

  }
  // public E removeLast(){ }
  // public E getFirst(){ }
  // public E getLast(){ }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] newData = data = (E[])new Object[size *2];
    for (int i = start; i<size;i++) {
      newData[i] = data[i];
    }
    for (int i = 0; i<start;i++) {
      newData[i] = data[i];
    }
  }

  public static void main(String[] args) {
    MyDeque<String> test = new MyDeque<String>(8);
    System.out.println(test);
    // System.out.println(test.size());
    test.addFirst("c");
    System.out.println(test);
    test.removeFirst();
    System.out.println(test);
    test.addFirst("b");
    System.out.println(test);
    test.addFirst("a");
    System.out.println(test);
    test.addLast("d");
    System.out.println(test);
    test.addLast("e");
    System.out.println(test);
    test.removeFirst();
    System.out.println(test);
  }
}
