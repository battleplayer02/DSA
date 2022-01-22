#include <bits/stdc++.h>
using namespace std;

// 0 / 1 Knapsack Problem
int knapsack(int wt[], int val[], int ap, int n)
{
    // base condition
    if (ap == 0 || n == 0)
        return 0;
    if (wt[n - 1] > ap)
        return knapsack(wt, val, ap, n - 1);
    else
    {
        int ans1 = val[n - 1] + knapsack(wt, val, ap - wt[n - 1], n - 1);
        int ans2 = knapsack(wt, val, ap, n - 1);
        return max(ans1, ans2);
    }
}

/*___0 / 1 Knapsack Problem with DP___*/
int knapsack_dp(int wt[], int val[], int ap, int n)
{
    int dp[n + 1][ap + 1];
    memset(dp, 0, sizeof(dp));
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            if (wt[i] > ap)
                dp[i][j] = dp[i - 1][j];
            else
            {
                int ans1 = val[i] + dp[i - 1][j - wt[i]];
                int ans2 = dp[i - 1][j];
                dp[i][j] = max(ans1, ans2);
            }
        }
    }
    return dp[n][ap];
}

int main()
{
    int wt[] = {1, 2, 3};
    int val[] = {6, 10, 12};
    int ap = 5;
    int maxProfit = knapsack(wt, val, ap, 3);
    int maxProfit_dp = knapsack_dp(wt, val, ap, 3);
    cout << "Maximum Profit is " << maxProfit << endl;
    cout << "Maximum Profit is " << maxProfit_dp << endl;
    return 0;
}