// 11003 - 최소값 찾기 - 슬라이딩 윈도우 덱 - re

#include<iostream>
#include<deque>
using namespace std;
int n, l, i, k;
deque<pair<int, int> > d; // 현재 값, 지금 까지 최소 값
int main() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	for (cin >> n >> l; i < n; i++) {
		cin >> k;
		for (; !d.empty() && d.front().first <= i-l; d.pop_front());
		for (; !d.empty() && d.back().second > k; d.pop_back());
		//범위 벗어난거 제거
		d.push_back(make_pair(i,k));
		cout << d.front().second << " ";
	}
}