//백준 - 9012 - 괄호
#include<iostream>
#include<stack>
using namespace std;
int t,i;
char a[50];
int main(){
	stack <char>s;
	cin>>t;
	for(;t>0;t--){
		cin>>a;
		for(i=0;a[i]!='\0';i++){
			if(a[i]==')'&&!s.empty()&&s.top()!=a[i])
				s.pop();
			else
				s.push(a[i]);
		}
		if(s.empty())
			cout<<"YES\n";
		else
			cout<<"NO\n";
		while(!s.empty())
			s.pop();
		a[0]={0};
	}
}