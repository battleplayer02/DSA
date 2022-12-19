/*
* A2OJ 1 
* Author: Himanshu Shekhar
* Link:   https://codeforces.com/problemset/problem/69/A
* Date:   26/07/2022
*/
#include <iostream>
#include <vector>

using namespace std;
int main()
{
    // input n
    int n;
    cin >> n;
    // vector of 3 and initializing it to 0
    vector<int> arr(3, 0);
    int x = 0;
    int y = 0;
    int z = 0;
    // input 3 elements
    // for i->n
    for (int i = 0; i < n; i++)
    {
        for (int i = 0; i < 3; i++)
        {
            cin >> arr[i];
        }
        x = arr[0] + x;
        y = arr[1] + y;
        z = arr[2] + z;
    }
    // printing the sum of 3 elements
    // cout << x << " " << y << " " << z << endl;
    if(x + y + z == 0 && x == y && y == z)
    {
        cout << "YES" << endl;
    }
    else
    {
        cout << "NO" << endl;
    }

    return 0;
}