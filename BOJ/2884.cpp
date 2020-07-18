//백준 - 알람시계 - 2884
#include<iostream>
int h,m,k;
int main(){
	std::cin>>h>>m;
	k=(h*60+m-45);
	if(k>1440)
		k-=1440;
	else if(k<0)
		k+=1440;
	std::cout<<k/60<<" "<<k%60;
}