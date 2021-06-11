import java.math.BigInteger;
import java.util.Scanner;

public class FactorialOfLargerNo {

    public static BigInteger fact(BigInteger n) {

        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        BigInteger f ;
        f = n.multiply(fact(n.subtract(BigInteger.ONE)));
        
        return f;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            String n = s.next();
            System.out.println(fact(new BigInteger(n)));
        }
    }
}
