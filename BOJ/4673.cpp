//백준 - 4673 - 셀프넘버
#include<iostream>
int d[10001],i=1,k;
bool dp[10001];
int main(){
	for(;i<10000;i++){
		d[i]+=i;
		for(k=i;k!=0;k/=10)
			d[i]+=k%10;
		dp[d[i]]=1;
	}
	for(i=1;i<10000;i++)
		if(!dp[i])
			std::cout<<i<<"\n";
}