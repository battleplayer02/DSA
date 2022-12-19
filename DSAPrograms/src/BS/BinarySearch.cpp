// WAP for Binary Search
#include <bits/stdc++.h>
using namespace std;

// define function
int binarySearch(vector<int> arr, int x)
{
    int low = 0;
    int high = arr.size() - 1;
    int mid;

    while (low <= high)
    {
        mid = (low + high) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] < x)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

void main(){
    // input vector
    vector<int> v = {1,2,3,4,5,6,7,8,9,10};
    // search element
    int search = 5;
    // call binary search function
    int result = binarySearch(v, search);
    // print result
    cout << "Element " << search << " is found at index " << result << endl;
}
