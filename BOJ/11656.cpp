//백준 - 11656 - 접미사 배열
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
string a,b[1001];
int i,j;
int main(){
	for(cin>>a,j=a.length();i<j;b[i]=a.substr(i),i++);
	sort(b,b+j);
	for(i=0;i<j;cout<<b[i++]<<"\n");
}