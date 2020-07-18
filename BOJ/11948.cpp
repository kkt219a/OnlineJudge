//백준 - 11948 - 과목선택
#include<iostream>
#include<algorithm>
using namespace std;
int a[6],i,s;
int main(){
	for(;i<6;i++)
		cin>>a[i];
	sort(a,a+4);
	sort(a+4,a+6);
	for(i=0;i<6;i++)
		if(i!=4&&i!=0)
			s+=a[i];
	cout<<s;
}