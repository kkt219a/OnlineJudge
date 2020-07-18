//백준 - 덱 - 10866
#include<iostream>
#include<deque>
#include<cstring>
using namespace std;
int n,i,v;
string a;
int main(){
	deque<int> dq;
	cin>>n;
	for(;i<n;i++){
		cin>>a;
		if(a=="push_front"){
			cin>>v;
			dq.push_front(v);
		}
		else if(a=="push_back"){
			cin>>v;
			dq.push_back(v);
		}
		else if(a=="pop_front"){
			if(dq.empty())
				cout<<"-1\n";
			else{
				cout<<dq.front()<<"\n";
				dq.pop_front();
			}
		}
		else if(a=="pop_back"){
			if(dq.empty())
				cout<<"-1\n";
			else{
				cout<<dq.back()<<"\n";
				dq.pop_back();
			}
		}
		else if(a=="size")
			cout<<dq.size()<<"\n";
		else if(a=="empty")
			cout<<dq.empty()<<"\n";
		else if(a=="front"){
			if(dq.empty())
				cout<<"-1\n";
			else
				cout<<dq.front()<<"\n";
		}
		else if(a=="back"){
			if(dq.empty())
				cout<<"-1\n";
			else
				cout<<dq.back()<<"\n";
		}
		a="";
	}
	
}