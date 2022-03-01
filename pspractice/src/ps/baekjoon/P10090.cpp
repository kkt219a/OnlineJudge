#include<iostream>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;
int t, mint[4000001], i, n, v;
int up(int start, int end, int node){
    if(v<start||v>end) return mint[node];
    if(start==end) return ++mint[node];
    int mid = (start + end) / 2;
    mint[node] = up(start,mid,node*2)+up(mid+1,end,node*2+1);
    return mint[node];
}
int query(int left, int right, int start, int end, int node){
    if (left > end || right < start) return 0;
    if (left <= start && right >= end) return mint[node];
    int mid = (start + end) / 2;
    return query(left,right,start,mid,node*2)+query(left,right,mid+1,end,node*2+1);
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    long long sum = 0;
    for(cin>>n, i=1;i<=n;cin>>v,sum+=(v-1-query(1,v-1,1,n,1)),up(1,n,1),i++);
    cout<<sum;
}