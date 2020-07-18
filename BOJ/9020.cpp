//백준 - 9020 - 골드바흐의 추측 -(에라토스테네스의 체)
#include<iostream>
#include<math.h>
int n,i,t,j,b,c;
int a[10001];
int main(){
	std::cin>>t;
	for(i=2;i<=10000;i++)
		if(!a[i])
			for(j=i+i;j<=10000;j+=i)
				a[j]=1;
	for(i=0;i<t;i++){
		b=0;
		c=5000;
		std::cin>>n;
		for(j=2;j<=n/2;j++)
			if(!a[n-j]&&!a[j])
				if(c-b>a[n-j]-a[j]){
					b=j;
					c=n-j;
				}
		std::cout<<b<<" "<<c<<"\n";
	}	
}