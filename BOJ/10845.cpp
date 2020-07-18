//백준 - 큐 - 10845
#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int n,i,v;
string a;
int main(){
	queue<int> q;
	cin>>n;
	for(;i<n;i++){
		cin>>a;
		if(a=="push"){
			cin>>v;
			q.push(v);
		}
		else if(a=="pop"){
			if(q.empty())
				cout<<"-1\n";
			else{
				cout<<q.front()<<"\n";
				q.pop();
			}
		}
		else if(a=="size")
			cout<<q.size()<<"\n";
		else if(a=="empty")
			cout<<q.empty()<<"\n";
		else if(a=="front"){
			if(q.empty())
				cout<<"-1\n";
			else
				cout<<q.front()<<"\n";
		}
		else if(a=="back"){
			if(q.empty())
				cout<<"-1\n";
			else
				cout<<q.back()<<"\n";
		}
		a="";
	}
	
}