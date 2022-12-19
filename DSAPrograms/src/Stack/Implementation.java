/*
 * Stack Implementation
 *
 */

class Implementation {

    private final int SIZE = 10;
    private int arr[] = new int[SIZE];
  private int i = -1;

  public boolean isEmpty() {
    return i == -1;
  }
 
  
  public void print() {
    for (int a : arr) {
      System.out.println(a + "\n");
    }
  }

  public void push(int a) {
    arr[++i] = a;
  }

  public int pop() {
    return arr[i--];
  }

  public int size() {
    return i;
  }

  public static void main(String... args) {
    Implementation s = new Implementation();
    s.push(10);
    s.push(20);
    s.print();
  }
}