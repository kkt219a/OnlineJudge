//백준 - 조세퍼스 - 1158 - Queue used

#include<iostream>
#include<queue>
using namespace std;

int main(){
	queue<int> q;
	int n,m,k; // n명 m번째 , k는 pop전에 기억해서 다시 넣기위해
	cin>>n>>m; // n명 m번째
	for(int i=0;i<n;i++)
		q.push(i+1);
	cout<<"<";
	for(int i=0;i<n;i++){
		for(int j=0;j<m-1;j++){
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