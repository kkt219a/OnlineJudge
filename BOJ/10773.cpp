//백준 - 10773 - 제로
#include<iostream>
#include<stack>
using namespace std;
stack<int> s;
int n,a,b;
int main(){
	cin>>n;
	for(;n--;){
		cin>>a;
		if(a==0)
			s.pop();
		else
			s.push(a);
	}
	while(!s.empty()){
		b+=s.top();
		s.pop();
	}
	cout<<b;
}