//1038 - 감소하는 수
#include<iostream>
using namespace std;
int i=10,k,l,m=10;
long long a[1023]={0,1,2,3,4,5,6,7,8,9,},t=10;
int main(){
	for(;i!=k;m=i)
		for(;k!=m;k++)
			for(l=0;l<a[k]%10;l++)
				a[i++]=a[k]*t+l;
	cin>>i;
	if(i<1023)cout<<a[i];
	else cout<<"-1";
}