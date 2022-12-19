public class Leetcode67 {
    public String addBinary(String a, String b) {
        String ans = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int op1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int op2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = op1 + op2 + carry;
            ans = (char) (sum % 2 + '0') + ans;
            carry = sum / 2;
            i--;
            j--;
            System.err.println("a");
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode67 leetcode67 = new Leetcode67();
        System.out.println(leetcode67.addBinary("11", "1"));
    }
}
