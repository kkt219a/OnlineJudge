//백준 - 1373 - 2진수 8진수
//맞긴한데 다시한번 rere
#include<iostream>
#include<cstring>
std::string a,r;
int i,m,t,k
int main(){
	std::cin>>a;
	t=a.size();
	for(i=t%3,k=1;i>0;i--,k*=2) //처음 것 자리수따라서 잘라서 먼저계산.
		m+=(a[i-1]-'0')*k;
	if(m>0) //제일앞에 0 방지
		r+=m+'0';
	for(i=t%3;i<t;i+=3) // 자리수 자르고나면 3의배수씩 되니까 3개합 계산
		r+=((a[i]-'0')*4+(a[i+1]-'0')*2+(a[i+2]-'0'))+'0';
	if(!(r.size())) //r이 0일때
		r+="0";
	std::cout<<r;
}