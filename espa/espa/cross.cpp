//
//  cross.cpp
//  espa
//
//  Created by 김규태 on 2021/09/14.
//

#include <iostream>
#pragma warning(disable:4996)
using namespace std;

int t,num;

int s1[10000],s2[10000];
int indexOf(int value){
    int k=0;
    for(;k<num;k++){
        if(s2[k]==value){
            break;
        }
    }
    return k;
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("cross.inp", "r", stdin);
    freopen("cross.out", "w", stdout);
    cin>>t;
    for(int i=0;i<t;i++){
        cin>>num;
        int answer = 0;
        for(int j=0;j<num;cin>>s1[j++]);
        for(int j=0;j<num;cin>>s2[j++]);
        for(int j=0;j<num; s1[j] = indexOf(s1[j]),j++);
        for(int j=0;j<num;j++){
            int s2Idx = s1[j];
            for(int k=0;k<j;k++){
                if(s2Idx<s1[k]){
                    answer++;
                }
            }
        }
        cout<<"Case "<<(i+1)<<": "<<answer<<"\n";
    }
    return 0;
}
