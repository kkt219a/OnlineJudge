// 17298 - 오큰수

#include<iostream>
#include<stack>
using namespace std;
int n,i,k,a[1000000];
stack<pair<int,int> > s;
int main() {
    cin.tie(0);
	ios_base::sync_with_stdio(false);
	for(cin>>n;i<n;i++){
		cin>>k;
		for(;!s.empty();a[s.top().first]=k,s.pop())
			if(s.top().second >= k) break;
		s.push(make_pair(i,k));
	}
	for(;!s.empty();a[s.top().first]=-1,s.pop());
	for(i=0;i<n;cout<<a[i++]<<" ");
}