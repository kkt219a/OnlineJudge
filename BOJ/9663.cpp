// 9663 - N-Queen - BackTracking - re

#include<iostream>
using namespace std;
int n, c, q[15];
void dfs(int a) {
	int i, j;
	if (a == n) {
		c++;
		return;
	}
	for (i = 0; i < n; i++) { // a행 i열을 확인 
		q[a] = i; // a행에 i열에 퀸 있다고 있다고 체크
		// 0~a-1행까지 같은 열이 없어야 하고 같은 대각선이 없어야 함
		for (j = 0; j < a&&q[a]!=q[j]&&abs(q[a]-q[j])!=a-j; j++);
		//없었으면 다음 행으로, 있었으면 다음 열로 이동
		if (j == a) dfs(a + 1);
	}
}
int main() {
	cin >> n;
	dfs(0);
	cout << c;
}