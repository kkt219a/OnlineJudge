// 1018-체스판 다시 칠하기 - 브루트포스
#include<iostream>
#include<algorithm>
using namespace std;
int i, j, m, n, a3, a4, a5, k, l, mx=65;
char a1[8][8],a2[8][8],t[50][50];
int main() {
	cin >> n >> m;
	for (; i < n; i++) {
		for (j = 0; j < m; j++) {
			cin >> t[i][j];
			if ((i+j)%2==1&& i < 8 && j < 8) {
				a1[i][j] = 'B';
				a2[i][j] = 'W';
			}
			else if ((i+j)%2==0 && i < 8 && j < 8) {
				a1[i][j] = 'W';
				a2[i][j] = 'B';
			}
		}
	}
	for (i = 0; i < n - 7; i++) {
		for (j = 0; j < m - 7; j++,a4=0,a5=0) {
			for (k = 0; k < 8; k++) {
				for (l = 0; l < 8; l++) {
					if (a1[k][l] != t[i + k][l + j])
						a4++;
					if ((a2[k][l] != t[i + k][l + j]))
						a5++;
				}
			}
			mx=min(min(mx, a4),a5);
		}
	}
	cout << mx;
}