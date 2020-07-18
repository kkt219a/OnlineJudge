//백준 - 설탕 배달 - 2839
#include<iostream>
int N,c,i,j;
int main(){
	for(std::cin>>N,c=N;i<N;i++)
		for(j=0;j<N;j++)
			if(N==i*3+j*5&&i+j<c)
				c=i+j;
	std::cout<<(c==N?-1:c);
}