
//
//  cube.cpp
//  espa
//
//  Created by 김규태 on 2021/09/17.
//

#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#pragma warning(disable:4996)
using namespace std;
string inp, a, b;
int opponent[6] = {6,5,4,3,2,1};
int side[6][5] = {{5,4,2,3,5},{1,4,6,3,1},{5,1,2,6,5},{5,6,2,1,5},{6,4,1,3,6},{2,4,5,3,2}};
vector<int> nowSaved;
bool complete = false;
void check(int i, int j){
    nowSaved.push_back(i+1);
    nowSaved.push_back(side[i][j]);
    nowSaved.push_back(side[i][j+1]);
    nowSaved.push_back(opponent[side[i][j+1]-1]);
    nowSaved.push_back(opponent[side[i][j]-1]);
    nowSaved.push_back(opponent[i]);
    int clear = 0;
    for(int i=0;i<nowSaved.size();i++){
        char tmp = b.at(nowSaved.at(i)-1);
        if(a.at(i)==tmp){
            clear++;
        }
    }
    if(clear==6){
        complete = true;
    }
    nowSaved.clear();
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("cube.inp", "r", stdin);
    freopen("cube.out", "w", stdout);
    while(true){
        cin>>inp;
        int exitCount = 0;
        for(int i=1;i<inp.length();i++)
            if(inp.at(0)==inp.at(i))
                exitCount++;
        if(exitCount==11){
            cout<<"TRUE\n";
            break;
        }
        a = inp.substr(0,6);
        b = inp.substr(6,6);
        for(int i=0;i<6;i++){
            for(int j=0;j<4;j++){
                check(i,j);
            }
        }
        cout<<(complete?"TRUE":"FALSE")<<"\n";
        complete = false;
    }
}
