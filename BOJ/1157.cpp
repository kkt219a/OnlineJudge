//백준 - 1157 - 단어공부
#include<iostream>
#include<algorithm>
char a[1000001],b;
int i,c[98],m=-1;
int main(){
	std::cin>>a;
	for(;a[i]!='\0';i++){
		if(a[i]>95)
			a[i]-=32;
		c[a[i]]++;
	}
	for(i=65;i<91;i++){
		if(c[i]==std::max(c[i],m)){
			m=c[i];
			b=i;
		}
	}
	std::sort(c,c+98);
	if(c[97]==c[96])
		b='?';
	std::cout<<b;
}