//백준 - 10799 - 막대기
//rerererererererere
#include<iostream>
#include<cstring>
#include<stack>
using namespace std;
int t,s;
int main(){
	stack<int> o;
	string a;
	cin>>a;
	for(;a[t]!='\0';t++){
		if(a[t]=='(')
			o.push(t);	
		else{
			o.pop();
			if(a[t-1]=='(') 
				s+=o.size();
			else
				s++;
		}
	}
	cout<<s;
}