//백준 - 11365 - !밀비 급일
#include<iostream>
#include<cstring>
std::string a[501];
int i,j,t;
int main(){
	for(;;i++){
		getline(std::cin,a[i]);
		if(a[i][0]==69&&a[i][1]==78&&a[i][2]==68)
			break;
		for(j=a[i].size()-1;j>=0;j--)
			std::cout<<a[i][j];
		std::cout<<"\n";
	}
}