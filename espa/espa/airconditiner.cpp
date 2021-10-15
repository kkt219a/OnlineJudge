//
//  jump.cpp
//  espa
//
//  Created by 김규태 on 2021/10/01.
//

#include<iostream>
#include<algorithm>
#include<vector>
#pragma warning(disable:4996)
using namespace std;
int dp[100001],a[100001];
vector<pair<int,int>> t;
int tc,n,k;
bool comp(pair<int, double> a, pair<int, double> b) {
    return a.first < b.first;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("airconditiner.inp", "r", stdin);
    freopen("airconditiner.out", "w", stdout);
    for(cin>>tc;tc--;){
        cin>>n>>k;
        for(int i=0;i<k;cin>>a[i++]);
        for(int i=0;i<k;cin>>dp[a[i]],t.push_back(make_pair(dp[a[i]],a[i])),i++);
        sort(t.begin(),t.end(),comp);
        for(int i=0;i<t.size();i++){
            pair<int,int> tmp = t[i];
            for(int j=tmp.second,b=tmp.first;j>=1;j--,b++){
                if(dp[j]==0||dp[j]>=b){
                    dp[j]=b;
                }else{
                    break;
                }
            }
            for(int j=tmp.second,b=tmp.first;j<=n;j++,b++){
                if(dp[j]==0||dp[j]>=b){
                    dp[j]=b;
                }else{
                    break;
                }
            }
        }
        for(int i=1;i<=n;i++){
            cout<<dp[i]<<" ";
        }
        cout<<"\n";
        for(int i=0;i<=n;dp[i]=a[i]=0,i++);
        t.clear();
    }
}
