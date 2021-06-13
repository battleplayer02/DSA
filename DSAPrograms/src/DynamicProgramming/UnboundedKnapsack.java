package DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int wts[] = new int[n];
        int vls[] = new int[n];
        for (int i = 0; i < n; i++) {
            vls[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wts[i] = s.nextInt();
        }
        int cap = s.nextInt();

        int dp[] = new int[cap + 1];
        for (int bagCapacity = 0; bagCapacity <= cap; bagCapacity++) {
            for (int i = 0; i < n; i++) {
                if (bagCapacity >= wts[i]) {
                    int remCapacity = bagCapacity - wts[i];
                    int remBagWt = dp[remCapacity];
                    int totalWeight = remBagWt + vls[i];
                    dp[bagCapacity] = Math.max(totalWeight, dp[bagCapacity]);
                }

            }
        }
        System.out.println(dp[cap]);
    }
}
