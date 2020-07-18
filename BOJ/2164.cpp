// 2164- 카드2 - 큐 
#include<iostream>
#include<queue>
using namespace std;
int n, i;
queue<int> q;
int main(){
	for(cin>>n; i<n; q.push(i++));
	for(; q.size()!=1; q.pop(),q.push(q.front()),q.pop());
	cout<<q.front()+1;
}