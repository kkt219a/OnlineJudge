// 11279 - 최대 힙 - 힙 구현
#include<iostream>
using namespace std;
int n, a;
typedef struct heap {
	int h[100001], cur;
	heap() { cur = 0; }
	void push(int k) {
		h[++cur] = k;
		for (int p = cur; p > 1 && h[p] > h[p / 2]; swap(h[p], h[p / 2]), p /= 2);
	}
	int top() { return h[1]; }
	void pop() {
		h[1] = h[cur--];
		for (int p = 1;;) {
			int left = p * 2, right = p * 2 + 1, next=p;
			if (left > cur) break;
			if (h[next] < h[left]) next = left;
			if (right <= cur&&h[next] < h[right]) next = right;
			if (next == p) break;
			swap(h[next], h[p]);
			p = next;
		}
	}
}heap;
heap h;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (h=heap(),cin >> n; n--;) {
		cin >> a;
		if (a) { h.push(a); }
		else if (h.cur != 0) { cout << h.top()<<"\n"; h.pop(); }
		else { cout << "0\n"; }
	}
}