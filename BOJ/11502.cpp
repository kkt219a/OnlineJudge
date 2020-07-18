//11502 - 세개의 소수 문제
#include<iostream>
#include<algorithm>
using namespace std;
int a[1000]={1,1},i,j,t,k,b[3];
int main(){
	cin>>t;
	for(i=2;i*i<h;i++)
		if(!a[i])
			for(j=i*i;j<h;j+=i)
				a[j]=1;
	for(;t--;){
		cin>>k;
		for(i=4;i<=k-1;i+=2)
			if(!a[k-i])
				break;
		if(i==k-1)
			cout<<"0\n";
		else{
			b[0]=k-i;
			if(i==4)
				b[1]=b[2]=2;	
			for(i-=3,j=3;j<=i;i-=2,j+=2)
				if(!a[i]&&!a[j]){
					b[1]=i;
					b[2]=j;
				}
			sort(b,b+3);
			cout<<b[0]<<" "<<b[1]<<" "<<b[2]<<"\n";
		}
	}
}