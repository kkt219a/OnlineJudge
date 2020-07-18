// 17299 - 오등큰수

#include<iostream>
#include<stack>
using namespace std;
int n, i, k, a[1000000], f[1000001], w[1000000];
stack<pair<int, int> > s;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for(cin>>n;i<n;cin>>a[i],f[a[i++]]++);
	for(i=0;i<n;i++){
		for(;!s.empty();w[s.top().first]=a[i],s.pop())
			if(s.top().second>=f[a[i]])break;
		s.push(make_pair(i,f[a[i]]));
	}
	for(;!s.empty();w[s.top().first]=-1,s.pop());
	for(i=0;i<n;cout<<w[i++]<<" ");
}