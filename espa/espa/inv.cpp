//
//  inv.cpp
//  espa
//
//  Created by 김규태 on 2021/11/29.
//

#include<iostream>
#include<algorithm>
#pragma warning(disable:4996)
using namespace std;
int t, mint[100001],mint2[100001], i, n, j;
long long sum;
void sort(int start, int mid, int end){
    int low = start, high = mid + 1, left = start;
    while(low<=mid&&high<=end){
        if (mint[low] <= mint[high])
            mint2[left++] = mint[low++];
        else{
            sum += (mid - low + 1);
            mint2[left++] = mint[high++];
        }
    }
    if (high<=end)
        for(j=high;j<=end;mint2[left++]=mint[j++]);
    if (low<=mid)
        for(j=low;j<=mid;mint2[left++] = mint[j++]);
    for(j=start;j<=end;mint[j]=mint2[j],j++);
}
void merge(int start, int end){
    if (start < end) {
        int mid = (start + end) / 2;
        merge(start, mid);
        merge(mid + 1, end);
        sort(start,mid,end);
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    freopen("inv.inp", "r", stdin);
    freopen("inv.out", "w", stdout);
    for(cin>>t;t--;sum=0){
        for(cin>>n,i=1;i<=n;cin>>mint[i++]);
        merge(1,n);
        cout<<sum<<"\n";
        for(i=1;i<=100000;mint2[i]=mint[i]=0,i++);
    }
}
