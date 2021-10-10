//
//  jump.cpp
//  espa
//
//  Created by 김규태 on 2021/10/01.
//

#include<iostream>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;
int input[100001],dp[100001];
int n,t,maxV=-1;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("jump.inp", "r", stdin);
    freopen("jump.out", "w", stdout);
    for(cin>>t;t--;maxV=-1){
        cin>> n;
        for(int i=1;i<=n;cin>>input[i++]);
        for(int i=1;i<=n;i++){
            maxV = max(dp[i]+input[i],maxV);
            if(i+input[i]<=n){
                dp[i+input[i]] = max(dp[i+input[i]],+dp[i]+input[i]);
            }
            dp[i] = 0;
        }
        cout<<maxV<<"\n";
    }
}
