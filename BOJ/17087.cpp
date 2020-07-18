// 17087 - 숨바꼭질 6

#include<iostream>
#include<algorithm>
#include<math.h>
using namespace std;
int g(int m,int n){
	if(n==0)
		return m;
	return g(n,m%n);
}
int n,s,a[100000],i,b;
int main() {
	for(cin>>n>>s;i<n;cin>>b,a[i++]=abs(s-b));
	for(i=1,b=a[0];i<n;b=(g(b,a[i++])));
	cout<<b;
}