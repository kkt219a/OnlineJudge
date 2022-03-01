#include<iostream>
#include<math.h>
#include<algorithm>
#include<vector>
#pragma warning(disable:4996)
using namespace std;
vector<int> mint[400000];
int siz, t, values[100001], i, n, m,a,b,c;
void up(int start, int end, int node){
    if(i>=start&&i<=end){
        mint[node].push_back(values[i]);
        if(start!=end){
            int mid = (start + end) / 2;
            up(start,mid,node*2);
            up(mid+1,end,node*2+1);
        }
    }
}
int query(int left, int right, int start, int end, int node){
    if (left > end || right < start) return 0;
    if (left <= start && right >= end) return mint[node].end()-upper_bound(mint[node].begin(),mint[node].end(),c);
    int mid = (start + end) / 2;
    return query(left,right,start,mid,node*2)+query(left,right,mid+1,end,node*2+1);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    for(cin>>n, i=1;i<=n;cin>>values[i],up(1,n,1),i++);
    siz = (1 << ((int)(log2(n) + 1)));
    for(i=1;i<400000;sort(mint[i].begin(),mint[i].end()),i++);
    for(cin>>m;m--;){
        cin>>a>>b>>c;
        cout<<query(a,b,1,n,1)<<"\n";
    }
    for(i=1;i<400000;mint[i++].clear());
}