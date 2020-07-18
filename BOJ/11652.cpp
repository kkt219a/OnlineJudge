//백준 - 11652 - 카드
#include<iostream>
#include<algorithm>
using namespace std;
int n,i,p,k=1,m;
long long s,a[1000000];

int main(){
	cin>>n;
	for(;i<n;i++)
		cin>>a[i];
	sort(a,a+n);
	for(i=1;i<n;i++){
		p=i-1;
		if(a[i]==a[p])
			k++;
		else
			k=1;
		if(max(k,m)==k&&m!=k){
			m=k;
			s=a[i-1];
		}
	}
	if(m==0)
		s=a[0];
	cout<<s;
}