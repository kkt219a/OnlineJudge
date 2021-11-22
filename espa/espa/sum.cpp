//
//  sum.cpp
//  espa
//
//  Created by 김규태 on 2021/11/22.
//

#include<iostream>
#include<algorithm>
#include <memory.h>
#pragma warning(disable:4996)
using namespace std;
int s,w,t;
int n[201], dp[201][80001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("sum.inp", "r", stdin);
    freopen("sum.out", "w", stdout);
    for(cin>>t;t--;){
        cin>>s>>w;
        for(int i=1;i<=s;i++){
            cin>>n[i];
        }
        for(int i=1;i<=s;i++){
            dp[i][n[i]] = (dp[i][n[i]]+1)%100000;
            for(int j=1;j<=w;j++){
                if(dp[i-1][j]>0){
                    dp[i][j+n[i]] = (dp[i-1][j] + dp[i][j+n[i]])%100000;
                    dp[i][j] = (dp[i][j]+dp[i-1][j])%100000;
                }
            }
        }
        cout<<dp[s][w]%100000<<"\n";
        memset(dp,0,sizeof(dp));
    }
}
