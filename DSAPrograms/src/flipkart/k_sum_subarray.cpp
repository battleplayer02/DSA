#include <iostream>
#include <map>
#include <vector>
using namespace std;
// print map function
void printMap(map<int, int> m) {
    for (auto it = m.begin(); it != m.end(); it++) {
        cout << it->first << " " << it->second << endl;
    }
}
int subarraySum(vector<int> &nums, int k)
{
    int count = 0;
    int sum = 0;
    int n = nums.size();
    map<int, int> m;
    m[0] = 1;
    for(int i=0;i<n;i++){
        sum += nums[i];
        m[sum]++;
        if(sum == k)
            count++;
        
        if(m[sum-k]>0)
            count += m[sum-k];
        
    }
    return count;
}

int main()
{
    vector<int> nums;
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        nums.push_back(x);
    }
    cout << subarraySum(nums, k);
    return 0;
}