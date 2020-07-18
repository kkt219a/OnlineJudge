//백준 - 11050 - 이항 계수 1
#include<iostream>
#include<cstring>
int d[30][30],m,k;
int b(int n, int r){
	if(r==0||r==n)
		return 1;
	if(d[n][r]!=-1)
		return d[n][r];
	return d[n][r]=b(n-1,r)+b(n-1,r-1);
}
int main(){
	std::cin>>m>>k;
	for(int i=0;i<30;i++)
		memset(d[i],-1,sizeof(int)*30);
	std::cout<<b(m,k);
}