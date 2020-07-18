//백준 - 주사위 게임 - 2476
#include<iostream>
#include<algorithm>
using namespace std;

int n,a[3],s,m;
int main(){
	cin>>n;
	while(n>0){
		cin>>a[0]>>a[1]>>a[2];
		sort(a,a+3);
		if(a[0]==a[1]&&a[1]==a[2])
			s=10000+(a[0]*1000);
		else if(a[0]==a[1]||a[1]==a[2])
			s=1000+(a[1]*100);
		else
			s=a[2]*100;
		m=max(m,s);
		n--;
	}
	cout<<m;
}
