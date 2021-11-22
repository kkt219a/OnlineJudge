//
//  rescue.cpp
//  espa
//
//  Created by 김규태 on 2021/11/22.
//

#include<iostream>
#include<algorithm>
#include <memory.h>
using namespace std;
int a, dp[10001][3], n, i = 1, t;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("rescue.inp", "r", stdin);
    freopen("rescue.out", "w", stdout);
    for(cin>>t;t--;i=1){
        memset(dp,0,sizeof(dp));
        for (cin>>n;i<=n;i++) {
            cin >> a;
            if(i==1){
                dp[i][0] = a;
                dp[i][1] = a;
            }else{
                dp[i][0] = max(dp[i-1][1],dp[i-1][2]) + a;
                dp[i][1] = max(dp[i-2][0],dp[i-2][1]) + a;
                dp[i][2] = dp[i-1][0];
            }
        }
        cout << max(dp[n][0],dp[n][1])<<"\n";
    }
}
