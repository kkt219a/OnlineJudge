//백준 - 11866 - 조세퍼스 문제0
#include<iostream>
#include<queue>
using namespace std;
int m,n,k,i;

int main(){
	queue<int> q;
	cin>>n>>m;
	for(;i<n;i++)
		q.push(i+1);
	cout<<"<";
	while(!q.empty()){
		for(i=1;i<m;i++){
			k=q.front();
			q.pop();
			q.push(k);
		}
		cout<<q.front();
		q.pop();
		if(!q.empty())
			cout<<", ";
	}
	cout<<">";
}