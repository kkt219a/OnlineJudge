// ITES - 외계 신호 분석 - 큐 이용

#include<iostream>
#include<queue>
using namespace std;
int c, n, k;
typedef struct goo {
	unsigned seed;
	goo() :seed(1983) {}
	unsigned next() {
		unsigned r = seed;
		seed = (seed * 214013u + 2531011u);
		return r % 10000 + 1;
	}
}g;
void solve(int kk, int nn) {
	g G;
	queue<int> q;
	int ret=0, rangesum=0;
	for (int i = 0; i < n; i++) {
		int v = G.next();
		rangesum += v;  // 부분합 더하고
		q.push(v); // 현재에 넣어주고
		while (rangesum > kk) { // 넘었으면 부분합에서 빼주고 삭제
			rangesum -= q.front();
			q.pop();
		}
		if (rangesum == kk) // 같으면 결과 값 더해주기
			ret++;
	}
	cout << ret << "\n";
}
int main() {
	for (cin >> c; c--;) {
		cin >> k >> n; // 합이 k가 되는거 , n개
		solve(k, n);
	}
}