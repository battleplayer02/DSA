import java.util.*;

public class Main { 
    // main
    public static void main(String[] args) {
        ans(0, 1, 5, 6, 3);        
    }

    public static void ans(int num, int i, int j, int k, int m) {
        /**
         * Turn ON  ith bit
         * Turn OFF jth bit
         * Toggle   kth bit
         * Check    mth bit
         **/
         turnON(num, i);
    }

    public static void turnON(int n, int i){
        // 10000000000
        // 00000010000
        // 10000010000
        int msk = 1<<i;
        System.out.println(bin(msk));
        int res = n | msk;
        System.out.println(i+"th bit turned on of "+bin(n)+"="+bin(res));
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