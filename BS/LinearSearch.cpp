// linear search in a vector
#include <bits/stdc++.h>
using namespace std;
int main(){
    int n,x;
    cin>>n;
    vector<int> v(n);
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
    cin>>x;
    for(int i=0;i<n;i++){
        if(v[i]==x){
            cout<<i<<endl;
            break;
        }
    }
    return 0;
}