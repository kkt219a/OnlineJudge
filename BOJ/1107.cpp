// 1107 - 리모컨

#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
int n,m,k,a[10],v,cnt,h;
int p(int c){
	cnt=0;
	if(c==0){
		if(a[c]==1)return 0;
		cnt++;
	}
	for(;c!=0;c/=10,cnt++)
		if(a[c%10])return 0;
	return cnt;
}
int main(){
	for(cin>>n>>m;m--;cin>>k,a[k]=1);
	for(v=abs(n-100),m=n;m--;){
		h=p(m);
		if(h!=0){ v = min(v, abs(n - m) + h); break; }
	}
	for(m=n;m<1000000;m++){
		h=p(m);
		if(h!=0){ v = min(v, abs(n - m) + h); break; }
	}
	cout<<v;
}