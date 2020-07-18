// 1256 - 사전 - 조합 스트링 dp - 다시

#include <iostream>
#define K 1000000000
using namespace std;
int n, m, d[201][201], i, j, k;
int main() {
	//조합 채워주기
	for (cin >> n >> m >> k; i <= (n + m); d[i][0] = d[i][i] = 1, i++)
		for (j = 1; j < i; j++) {
			d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
			if (d[i][j] > K) d[i][j] = K;
		}
	//조합 값이 k보다 크면 -1
	if (d[n + m][m] < k) cout << "-1" << '\n';
	else
		for (j = n + m; j > 0; j--) {
			if (k <= d[n + m - 1][m]) { cout << "a"; n--; } //a썼으면 1개줄이기
			else { k -= d[n + m - 1][m]; cout << "z"; m--; } // z썼으면 1개줄이고 k위치도 변경
		}
}