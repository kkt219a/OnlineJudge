//15683 - 감시 - 어려웠따 단순구현 ㅠ 

#include<iostream>
#include<algorithm>
using namespace std;
int i, j, n, m, a[8][8], mi = 9999, va, check[8][8];
void see(bool init, int num, int x, int y) {
	if (num == 0)
		for (; x >= 0 && a[x][y] != 6; x--) {
			if (init) check[x][y]--;
			else check[x][y]++;
		}
	else if (num == 1)
		for (; y < m && a[x][y] != 6; y++) {
			if (init) check[x][y]--;
			else check[x][y]++;
		}
	else if (num == 2)
		for (; x < n && a[x][y] != 6; x++) {
			if (init) check[x][y]--;
			else check[x][y]++;
		}
	else if (num == 3)
		for (; y >= 0 && a[x][y] != 6; y--) {
			if (init) check[x][y]--;
			else check[x][y]++;
		}
}
void go(int x1, int y1) {
	va = 0;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (a[i][j] == 0 && check[i][j] == 0) va++;
	mi = min(va, mi);
	for (int i = x1, j = y1; i < n; i++, j = 0) {
		for (; j < m; j++) {
			if (a[i][j] == 0 || a[i][j] == 6) continue;
			else if (a[i][j] == 5) {
				for (int k = 0; k < 4; k++) see(0, k, i, j);
				go(i, j + 1);
				for (int k = 0; k < 4; k++) see(1, k, i, j);
			}
			else if (a[i][j] == 4)
				for (int k = 0; k < 4; k++) {
					for (int p = 0; p < 3; p++) see(0, (k + p) % 4, i, j);
					go(i, j + 1);
					for (int p = 0; p < 3; p++) see(1, (k + p) % 4, i, j);
				}
			else if (a[i][j] == 3)
				for (int k = 0; k < 4; k++) {
					for (int p = 0; p < 2; p++) see(0, (k + p) % 4, i, j);
					go(i, j + 1);
					for (int p = 0; p < 2; p++) see(1, (k + p) % 4, i, j);
				}
			else if (a[i][j] == 2)
				for (int k = 0; k < 2; k++) {
					see(0, k, i, j); see(0, k + 2, i, j);
					go(i, j + 1);
					see(1, k, i, j); see(1, k + 2, i, j);
				}
			else
				for (int k = 0; k < 4; k++) {
					see(0, k, i, j);
					go(i, j + 1);
					see(1, k, i, j);
				}
		}
	}
}
int main() {
	for (cin >> n >> m; i < n; i++)
		for (j = 0; j < m; cin >> a[i][j++]);
	go(0, 0);
	cout << mi;
}
