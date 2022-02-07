#include <iostream>
using namespace std;

// Function to find the maximum sum of a subarray
int kadans_algo(int *arr)
{
    int n = sizeof(arr) / sizeof(arr[0]);
    int max_so_far = 0, max_ending_here = 0;
    for (int i = 0; i < n; i++)
    {
        max_ending_here = max_ending_here + arr[i];
        if (max_ending_here < 0)
            max_ending_here = 0;
        if (max_so_far < max_ending_here)
            max_so_far = max_ending_here;
    }
    return max_so_far;
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    cout << "Maximum contiguous sum is " << kadans_algo(arr);
    return 0;
}
