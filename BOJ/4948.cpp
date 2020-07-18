//백준 - 4948 - 베르트랑 공준 - (에라토스테네스의 체)
#include<iostream>
int n,i,j,c;
bool a[247000];
int main(){
	for(i=2;i<=246912;i++)
		if(!a[i])
			for(j=i+i;j<=246912;j+=i)
				a[j]=1;
	while(1){
		c=0;
		std::cin>>n;
		if(n==0)
		  break;
		for(i=n+1;i<=2*n;i++)
			if(!a[i])
				c++;
		std::cout<<c<<"\n";
	}
}