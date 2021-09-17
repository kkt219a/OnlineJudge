//
//  family.cpp
//  espa
//
//  Created by 김규태 on 2021/09/17.
//

#include<iostream>
#include<vector>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;
int t, n,a,b,maxValue, parentTop;
vector<int> person[500001];
bool chk[500001],visit[500001];
void dfs(int curNum, int depth){
    visit[curNum] = true;
    if(person[curNum].size()==0){
        maxValue = max(maxValue,depth);
    }else{
        for(int j=0;j<person[curNum].size();j++){
            if(!visit[person[curNum].at(j)]){
                dfs(person[curNum].at(j),depth+1);
            }
        }
    }
    visit[curNum] = false;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("family.inp", "r", stdin);
    freopen("family.out", "w", stdout);
    for(cin>>t;t--;){
        cin>>n;
        for(int i=1;i<n;i++){
            cin>>a>>b;
            chk[b] = true;
            person[a].push_back(b);
        }
        for(int i=1;i<=n;i++)
            if(!chk[i]){
                parentTop = i;
                break;
            }
        dfs(parentTop,1);
        for(int i=1;i<=n;i++){
            visit[i] = false;
            chk[i]=false;
            person[i].clear();
        }
        cout<<maxValue<<"\n";
        maxValue = -1;
    }
    return 0;
}
