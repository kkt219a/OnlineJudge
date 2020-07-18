//백준 - 카드 역배치 - 10804
#include<iostream>
#include<stack>
int a[20],i,b,c,j;
int main(){
	std::stack<int> d;
	for(;i<20;i++)
		a[i]=i+1;
	for(i=0;i<10;i++){
		std::cin>>b>>c;
		for(j=b;j<=c;j++)
			d.push(a[j-1]);
		for(j=b;j<=c;j++){
			a[j-1]=d.top();
			d.pop();
		}
	}
	for(i=0;i<20;i++)
		std::cout<<a[i]<<" ";
}