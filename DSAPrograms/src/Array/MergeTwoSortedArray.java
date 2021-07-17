
//Github Copilot in action
import java.util.*;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] b = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] c = mergeTwoSortedArray(a, b);
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i]);
    }

    public static int[] mergeTwoSortedArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }
}
