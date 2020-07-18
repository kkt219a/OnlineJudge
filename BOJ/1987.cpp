// 1987 - 알파벳 - 백트래킹

#include<iostream>
#include<algorithm>
using namespace std;
char a[21][21];
int n, m, i = 1, j = 1, xy[4][2] = { {0,1},{0,-1},{1,0},{-1,0} }, val, ret = -1;
bool check[26];
void back(int r, int c) {
	check[a[r][c] - 65] = 1;
	val++;
	ret = max(ret, val);
	//cout << r << " " << c << "\n";
	for (int i = 0; i < 4; i++) {
		int b = r + xy[i][0], d = c + xy[i][1];
		//cout << b << " " << d <<" "<< a[b][d]<<"z\n";
		if (b>0&&d>0&&b<=n&&d<=m&&!check[a[b][d] - 65]) //방문 안한 알파벳이고 범위 안이라면
			back(b,d); // 이 점 방문
	}
	val--;
	check[a[r][c] - 65] = 0;
}
int main() {
	for (cin >> n >> m; i <= n; i++) {
		cin >> a[i];
		for (j = m-1; j >=0; a[i][j + 1] = a[i][j], j--);
	}
	back(1, 1);
	cout << ret;
}