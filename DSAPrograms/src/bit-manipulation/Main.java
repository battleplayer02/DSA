import java.util.*;

public class Main {
    // main
    public static void main(String[] args) {
        System.out.println(bin(2));
    }
    public static String bin(int num){
        List<Integer> st = new ArrayList<Integer>();
        while(num!=0){
            st.add(num%2);
            num/=2;
        }

        Collections.reverse(st);
        return st.toString();
    }
}