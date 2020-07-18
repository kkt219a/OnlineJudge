//백준 - 1929 - 소수구하기 -(에라토스테네스의 체)
#include<iostream>
int m,n,i,j;
bool a[10000001];
int main(){
	std::cin>>m>>n;
	a[1]=1;
	for(i=2;i<=n;i++)
		if(!a[i])
			for(j=2*i;j<=n;j+=i)
				a[j]=true;
	for(;m<=n;m++)
		if(!a[m])
			std::cout<<m<<"\n";
}