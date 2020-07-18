//백준 - 2606 - 바이러스
//rerererereere
#include<iostream>
using namespace std;
int n,s,a,b;
bool visit[101],adj[101][101];

void c(int d){
	s++;
	visit[d]=1;
	for(int e=1;e<=n;e++) //여기서 외부에서 고정시켜놓으면 수가 계속 바껴서 매번 새롭게 해줘야함.
		if(!visit[e]&&adj[d][e])
			c(e);
}

int main(){
	cin>>n>>s;
	for(;s>0;s--){
		cin>>a>>b;
		adj[a][b]=adj[b][a]=1;
	}
	c(1);
	cout<<s-1;
}