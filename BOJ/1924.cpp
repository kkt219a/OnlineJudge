// 1924 - 2007년
#include<iostream>
#include<string>
int k,l,m,j;
int main() {
	std::string a[12][32],b[7]={"MON","TUE","WED","THU","FRI","SAT","SUN"};
	for(int i=0;i<12;i++)
		for(k, j=0;j<31;j++,k++){
			if(k==7)
				k=0;
			if(i==1)
				if(j==28)
					break;
			if(i==3||i==5||i==8||i==10)
				if(j==30)
					break;
			a[i][j]=b[k];
		}
	std::cin>>l>>m;
	std::cout<<a[l-1][m-1];
}