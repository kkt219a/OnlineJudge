//
//  bridge.cpp
//  espa
//
//  Created by 김규태 on 2021/09/15. 45분
//

#include <iostream>
#include<string>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;
char a[4] = {'C','D','S','H'};
char b[13] = {'2','3','4','5','6','7','8','9','T','J','Q','K','A'};
char c[4] = {'N','E','S','W'};
bool comp(string s1, string s2){
    int value1=0, value2=0;
    for(int v = 0; v<4; v++){
        if(a[v]==s1.at(0)){
            value1 = v;
        }
        if(a[v]==s2.at(0)){
            value2 = v;
        }
    }
    if(value1!=value2){
        return value1 < value2;
    }else{
        for(int v = 0; v<13; v++){
            if(b[v]==s1.at(1)){
                value1 = v;
            }
            if(b[v]==s2.at(1)){
                value2 = v;
            }
        }
        return value1 < value2;
    }
}
string direction;
string value, temp, tmp1, tmp2;
string people[4][13];
int startNum; // N:0, E:1, S:2, W:3
int nowCNum;
void out(int v){
    sort(people[v],people[v]+13,comp);
    cout<<c[v] << ": ";
    for(int i = 0; i<13; i++){
        cout<<people[v][i]<<" ";
    }
    cout<<"\n";
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("bridge.inp", "r", stdin);
    freopen("bridge.out", "w", stdout);
    while(true){
        cin>>direction;
        if(direction.compare("#")==0){
            break;
        }
        nowCNum = 0;
        value = "";
        cin>>temp;
        value.append(temp);
        cin>>temp;
        value.append(temp);
        startNum = direction=="N" ? 0 : (direction=="E" ? 1 : (direction=="S" ? 2 : 3));
        for(int i=0;i<103;i+=2){
            if(i%8==0&&i!=0){
                nowCNum++;
            }
            startNum = startNum+1 > 3 ? 0 : startNum+1;
            tmp1 = value.at(i);
            tmp2 = value.at(i+1);
            string realValue = tmp1+tmp2;
            people[startNum][nowCNum] = realValue;
        }
        out(2);out(3);out(0);out(1);
    }
    return 0;
}
