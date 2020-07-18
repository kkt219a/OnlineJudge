// 2775 부녀회장이 될테야 
#include<iostream>
using namespace std;
int w(int k,int n){
	int s=0,a=0;
	if(k==1){
		for(int i=1;i<n+1;i++)
			s+=i;
		return s;
	}
	for(int i=1;i<n+1;i++)
		a+=w(k-1,i);
	return a;
}
int main(){
	int t,k,n;
	cin>>t;
	while(t>0){
		cin>>k>>n;
		cout<<w(k,n)<<\n;
        t--;
	}
}