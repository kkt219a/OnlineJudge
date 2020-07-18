//1292 - 쉽게푸는 문제

#include<iostream>
int a[1001],count,b,c,s;
int main(){
	std::cin>>b>>c;
	for(int i=1;i<46;i++){
		for(int j=0;j<i;j++){
			if(count==1000)
				break;
			a[count]=i;
			count++;
		}
	}
	for(;b<=c;b++)
		s+=a[b-1];
	std::cout<<s;
}