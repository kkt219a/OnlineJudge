//백준 - 12790 - Mini Fantasy War
#include<iostream>
int t,a[8],i;
int main(){
	std::cin>>t;
	while(t--){
		for(i=0;i<8;i++){
			std::cin>>a[i];
			if(i>3)
				a[i-4]+=a[i];
		}
		if(a[0]<1)
			a[0]=1;
		if(a[1]<1)
			a[1]=1;
		if(a[2]<0)
			a[2]=0;
		std::cout<<a[0]+5*a[1]+2*(a[2]+a[3])<<"\n";
	}
}