//백준 - 소수 - 2581
#include<iostream>
#include<math.h>
using namespace std;
int a,b,i,j,m=10001,s;
bool z;
int main(){
	cin>>a>>b;
	for(i=a;i<=b;i++){
		z=true;
		for(j=2;j<=sqrt(i);j++){
			if(i%j==0){
				z=false;
				break;
			}
		}
		if(i==1)
			z=false;
		if(z==true){
			m=min(m,i);
			s+=i;
		}
	}
	if(s==0)
		cout<<"-1";
	else
		cout<<s<<"\n"<<m;
}
