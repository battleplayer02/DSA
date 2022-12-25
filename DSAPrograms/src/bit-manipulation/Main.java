import java.util.*;

import javax.security.cert.X509Certificate;

public class Main { 
    // main
    public static void main(String[] args) {
        // ans(0, 1, 5, 6, 3);
        // int num = 16;
        // StringBuilder bin = new StringBuilder("");
        // while(num!=0){
        //     int rem = num%2;
        //     bin.append(rem);
        //     num/=2;
        // }
        // System.out.println(bin.reverse());
        // 1010111
        // 1001000
        // 1000000
        int x = 42;
        int msk = ~(1<<3);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(msk).substring(26));
        System.out.println(Integer.toBinaryString(x&msk));
    }

    public static void ans(int num, int i, int j, int k, int m) {
        /**
         * Turn ON  ith bit
         * Turn OFF jth bit
         * Toggle   kth bit
         * Check    mth bit
         **/
        //  turnON(num, i);
        System.out.println(bin(73));
        System.out.println(((~73+1)));
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