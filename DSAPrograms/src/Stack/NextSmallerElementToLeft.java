import java.util.Stack;

class NextSmallerElementToLeft{
  public static void main(String... args){
    int arr[] = new int[]{ 2 ,1 ,5 ,6 ,2 ,3 };
    //                    -1  -1 1  5  1  2
    /*
     *   
     *   1
     *   -1
     *    
     *
     */
    ap(arr);
    Stack<Integer> st = new Stack<Integer>(); 
    st.push(-1);
    int nsl[] = new int[arr.length];
    for(int i=0;i<arr.length;i++){
        while(!st.isEmpty() && arr[i] < st.peek()){
            st.pop();
        }
        nsl[i] = st.isEmpty() ?-1:st.peek();
        st.push(arr[i]);
    }
    ap(nsl);   
  } 
  public static void ap(int arr[]){
    for(int a:arr){
        System.out.print(a+"\t");
    }
    System.out.println();
  } 
}