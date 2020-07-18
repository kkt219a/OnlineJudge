//백준 - 1212 - 8진수 2진수
//★rererererererererere
#include<iostream>
#include<cstring>
std::string a[]={"000","001","010","011","100","101","110","111"},b,r;
int i,s;
int main(){
	std::cin>>b;
	for(i=0;i<b.size();i++)
		r+=a[b[i]-'0']; // 한개당 바로바로 2진수로 변환
	for(i=0;i<r.size();i++)
		if(s||r[i]!='0'){
			s=1;
			std::cout<<r[i];
		}
	if(!s)
		std::cout<<"0";
}