//백준 - 2869 - 달팽이는 올라 가고 싶다.
#include<iostream>
int a,b,v,c=1;
int main(){
	std::cin>>a>>b>>v;
	v-=a; //마지막날 올라온걸 빼주고.
	if(v%(a-b)>0) // 마지막날 뺴고 올라올수 있는 나머지가 있으면 또 하루가 더 필요하단거.
		c++;
	std::cout<<v/(a-b)+c; // c가 원래 1인건 마지막 날을 위한것. 
}