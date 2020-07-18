// 3020 - 개똥벌레 - lower,upper를 이용한 이진탐색과, prefix sum등 여러가지 방법이 존재한다 무조건다시!

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n, h, i, ans = 2100000000, tmp, cnt = 1, c, d;
vector<int> a, b;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> h; i < n / 2; i++) {
		cin >> c >> d;
		a.push_back(c);
		b.push_back(d);
	}
	sort(a.begin(), a.end());
	sort(b.begin(),b.end());
	for (i = 0; i < h; i++,tmp=0) {
		tmp = a.size()- (lower_bound(a.begin(), a.end(), i) - a.begin());
		tmp += b.size() - (upper_bound(b.begin(), b.end(), h - i) - b.begin());
		if (tmp == ans) cnt++;
		else if (tmp < ans) { ans = tmp; cnt=1; }
	}
	cout << ans << " " << cnt;
}