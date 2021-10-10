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
int input[100001][2];
int m,t,leftMax,rightMax,minV=2100000000;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("coin.inp", "r", stdin);
    freopen("coin.out", "w", stdout);
    for(cin>>t;t--;leftMax=rightMax=0,minV=2100000000){
        cin>> m;
        for(int i=1;i<=m;cin>>input[i][0],leftMax+=input[i++][0]);
        for(int i=1;i<=m;cin>>input[i++][1]);
        for(int i=1;i<m;i++){
            leftMax-=input[i][0];
            rightMax+=input[i-1][1];
            minV = min(max(leftMax,rightMax),minV);
        }
        cout<<((minV==2100000000)?0:minV)<<"\n";
    }
}
