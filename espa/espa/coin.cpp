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
int dp[101][101][101];
int n,a,b,c;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("coin.inp", "r", stdin);
    freopen("coin.out", "w", stdout);
    dp[0][0][1]=dp[0][1][0]=dp[1][0][0]=-1;
    for(int i=0;i<101;i++){
        for(int j=0;j<101;j++){
            for(int k=0;k<101;k++){
                if(dp[i][j][k]==0){
                    if(
                       (i>=1&&dp[i-1][j][k]==-1)||(i>=2&&dp[i-2][j][k]==-1)||(i>=3&&dp[i-3][j][k]==-1)||
                       (j>=1&&dp[i][j-1][k]==-1)||(j>=2&&dp[i][j-2][k]==-1)||(j>=3&&dp[i][j-3][k]==-1)||
                       (k>=1&&dp[i][j][k-1]==-1)||(k>=2&&dp[i][j][k-2]==-1)||(k>=3&&dp[i][j][k-3]==-1)
                       )
                        dp[i][j][k]=1;
                    else
                        dp[i][j][k]=-1;
                }
            }
        }
    }
    for(cin>>n;n--;){
        cin>>a>>b>>c;
        cout<<"("<<a<<" "<<b<<" "<<c<<") : "<<dp[a][b][c]<<"\n";
    }
}
