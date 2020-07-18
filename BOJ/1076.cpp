//백준 - 1076 - 저항
#include<iostream>
#include<cstring>
std::string a[3],b[10]={"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
long int i,t,k,j,m=10;
int main(){
	for(;i<3;i++){
		k=1;
		std::cin>>a[i];
		for(j=0;j<10;j++,k*=10){
			if((!a[i].compare(b[j]))&&i==2)
				t*=k;
			else if(!a[i].compare(b[j])){
				t+=j*m;
				m/=10;
			}
				
		}
	}
	std::cout<<t<<"\n";;
}