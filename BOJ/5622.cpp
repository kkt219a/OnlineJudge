//백준 - 5622 - 다이얼
#include<iostream>
char a[15];
int i,s,t;
int main(){
	std::cin>>a;
	for(;a[i]!='\0';i++){
		if(a[i]>79&&a[i]<84)
			s+=8;
		else if(a[i]>86&&a[i]<91)
			s+=10;
		else{
			t=(a[i]-'A')/3;
			s+=t+3;
			if(t==7)
				s--;
		}
	}
	std::cout<<s;
}