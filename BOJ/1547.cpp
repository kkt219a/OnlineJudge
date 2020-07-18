//1547 - 공

#include<iostream>
int m, x, y,r=1;
int main(){
	std::cin>>m;
	for(;m--;){
		std::cin>>x>>y;
		if(x==r)
			r=y;
		else if(y==r)
			r=x;
	}
	std::cout << r;
}