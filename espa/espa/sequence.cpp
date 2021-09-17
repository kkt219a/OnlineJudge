//
//  sequence.cpp
//  espa
//
//  Created by 김규태 on 2021/09/15.
// 19:36~20:10
//

#include <iostream>
#include<string>
#include<algorithm>
#include<vector>
#pragma warning(disable:4996)
using namespace std;
int n, value;
vector<int> s;
vector<int> c;
vector<int> out;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("sequence.inp", "r", stdin);
    freopen("sequence.out", "w", stdout);
    cin>>n;
    for(int i=0;i<n;i++){
        cin>> value;
        s.push_back(value);
    }
    sort(s.begin(),s.end());
    for(int i=0;i<n;i++){
        cin>>value;
        c.push_back(value);
    }
    for (auto i = c.rbegin(); i != c.rend(); ++i){
        int idx = *i;
        int value = s.at(idx);
        out.push_back(value);
        s.erase(s.begin()+idx);
    }
    for (auto i = out.rbegin();i!=out.rend();++i){
        cout<<*i<<"\n";
    }
    return 0;
}
