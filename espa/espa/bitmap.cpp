//
//  bitmap.cpp
//  espa
//
//  Created by 김규태 on 2021/09/24.
//

#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#pragma warning(disable:4996)
using namespace std;
int t;
long long E[2][2] = { {1,1},{1,0} }, mat[2][2] = { {1,0},{0,1} }, tmp[2][2], mod=1, a, b, c, d,val[4],i,j,l;
void calc(long long a[][2], long long b[][2]) {
    for (i = 0; i < 2; i++)
        for (j = 0; j < 2;tmp[i][j]%=mod, j++)
            for (tmp[i][j]=0,l = 0; l < 2; l++)
                tmp[i][j] += a[i][l] * b[l][j];
    for (i = 0; i < 2; a[i][0] = tmp[i][0], a[i][1] = tmp[i][1], i++);
}
long long getValue(long long n){
    E[0][0]=E[0][1]=E[1][0]=mat[0][0] = mat[1][1] = 1;
    E[1][1]=tmp[0][0]=tmp[1][0]=tmp[0][1]=tmp[1][1]=mat[1][0] = mat[0][1] = 0;
    if (n < 2){
        return n != 0 ? 1 : 0;
    }
    else {
        for (n -= 2; n != 0; n /= 2) {
            if (n % 2)
                calc(mat, E);
            calc(E, E);
        }
        return (mat[0][0] + mat[0][1])%mod;
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("1.inp", "r", stdin);
    freopen("bitmap.out", "w", stdout);
    for(cin>>t;t--;){
        cin>>a>>b>>c>>d>>mod;
        cout << (((getValue(a)*getValue(b))%mod)+((getValue(c)*getValue(d))%mod))%mod<<"\n";
    }
}
