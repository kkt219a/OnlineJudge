//백준 - 11726 - 2xn 타일링
//야매 x 제대로 이해된 설명으로 rerererere
#include<iostream>
long int n,k[1001]={1,2},i=2;
int main(){
	std::cin>>n;
	for(;i<n;i++) // 2*i 의 타일은 2*(i-1)타일에 세로타일하나 붙힌것 + 2*(i-2)타일에 가로타일 두개 붙힌것	과 같다!
		k[i]=k[i-1]+k[i-2];
	std::cout<<k[n-1];
}