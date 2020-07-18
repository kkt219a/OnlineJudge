//백준 - 스택 - 10828
#include<iostream>
#include<stack>
#include<cstring>
using namespace std;
int n,i,v;
string a;
int main(){
	stack<int> s;
	cin>>n;
	for(;i<n;i++){
		cin>>a;
		if(a=="push"){
			cin>>v;
			s.push(v);
		}
		else if(a=="pop"){
			if(s.empty())
				cout<<"-1\n";
			else{
				cout<<s.top()<<"\n";
				s.pop();
			}
		}
		else if(a=="size")
			cout<<s.size()<<"\n";
		else if(a=="empty")
			cout<<s.empty()<<"\n";
		else if(a=="top"){
			if(s.empty())
				cout<<"-1\n";
			else
				cout<<s.top()<<"\n";
		}
		a="";
	}
	
}