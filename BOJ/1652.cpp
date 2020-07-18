//백준 - 누울자리를 찾아라 - 1652
//rererererere
#include<iostream>
char a[101][101];
int i,n,k,p,t,m,j;
int main(){
	std::cin>>n; // 몇x몇 정사각형인지.
	for(;i<n;i++)
		std::cin>>a[i];
	for(i=0;i<n;i++){
		k=0; //매번 두개는 초기화
		p=0;
		for(j=0;j<n;j++){
			if(a[j][i]=='.') // .이면 2칸이상확인위해 카운트(세로)
				p++;
			else{ //점이아니면
				if(p>1) // 2칸이상이면 누울수있으니까 ok
					m++;
				p=0; //p는 다시초기화
			}
			if(a[i][j]=='.') //가로
				k++;
			else{
				if(k>1)
					t++;
				k=0;
			}
		}
		if(k>1)
			t++;
		if(p>1)
			m++;

	}
	std::cout<<t<<" "<<m;
}