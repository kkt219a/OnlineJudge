//백준 - 2822 - 점수계산
#include<iostream>
#include<algorithm>
using namespace std;
int k[8],a[8],s,i,j,b[5];
int main(){
	for(;i<8;i++){
		cin>>k[i];
		a[i]=k[i];
	}
	sort(a,a+8);

	for(i=3;i<8;i++){
		s+=a[i];
		for(j=0;j<8;j++)
			if(a[i]==k[j])
				b[i-3]=j+1;
	}
	sort(b,b+5);
	cout<<s<<"\n";
	for(i=0;i<5;i++)
		cout<<b[i]<<" ";
}