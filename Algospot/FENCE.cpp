// FENCE - 울타리 자르기  - 스택과 라인 스위핑 이용 - 다시 

#include<iostream>
#include<stack>
#include<vector>
#include<algorithm>
using namespace std;
int c, n, i = 1;
int solve(vector<int> v2) {
	stack<int> s;
	v2.push_back(0); // 마지막에 총 사각형 넓이 위해
	int ret = 0;
	for (int i = 0; i < v2.size(); i++) {
		// 앞에 큰놈이 없을때까지 삭제
		while (!s.empty()&&v2[s.top()]>=v2[i]) {
			int k = s.top(), width = -1;
			s.pop();
			if (s.empty()) // 비었다는건 left가 -1로 간주
				width = i;
			else // 안 비었으면 스택에서 제일 위에있는 놈이 left
				width = i - s.top() - 1;
			ret = max(ret, v2[k] * width); // 바로바로 계산해두기
		}
		s.push(i);
	}
	return ret;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> c; c--;) {
		cin >> n;
		vector<int> v(n);
		for (i=0; i < n; cin >> v[i++]);
		cout<<solve(v)<<"\n";
	}
}