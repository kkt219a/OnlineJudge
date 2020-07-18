// 백준 - 1747 - 소수&팰린드롬
#include<iostream>
using namespace std;
int n,i,j,a[1004000]={1,1,},b[7],c,f;
int main(){
	for(i=2;i<502000;i++){
		if(a[i]==1) continue;
		for(j=2;i*j<1004000;a[i*j]=1,j++);
	}
	for(cin>>n;;n++){
		if(a[n]==0){
			for(f=0,c=n,i=0;c!=0;b[i++]=c%10,c/=10);
			for(j=0,i--;;j++,i--){
				if(b[i]!=b[j]) f = 1;
				if(i-j==0||i-j==1) break;
			}
			if(!f) break;
		}
	}
	cout<<n;
}