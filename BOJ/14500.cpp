//14500 - 테트로미노 - 브루트포스

#include<iostream>
#include<algorithm>
using namespace std;
int n, m, p[500][500], i, j, ret=-1, val1, val2;
int t1(int x, int y) { //2*2
	if (x+1 < n  && y+1 < m)
		return p[x][y] + p[x + 1][y] + p[x][y + 1] + p[x + 1][y + 1];
	return -1;
}
int t2(int x, int y) {//1*4
	val1 = -1;
	if (x + 3 < n) //ㅣ
		val1 = max(val1, p[x][y] + p[x + 1][y] + p[x + 2][y] + p[x + 3][y]);
	if (y + 3 < m) //ㅡ
		val1 = max(val1, p[x][y] + p[x][y + 1] + p[x][y + 2] + p[x][y + 3]);
	return val1;
}
int t3(int x, int y) { // ㅗ형태
	val1 = -1;
	if (y - 1 >= 0 && y + 1 < m) {
		if (x + 1 < n) val1 = max(val1, p[x][y] + p[x][y - 1] + p[x][y + 1] + p[x + 1][y]); //ㅜ
		if(x-1>=0) val1 = max(val1, p[x][y] + p[x][y - 1] + p[x][y + 1] + p[x -1][y]); //ㅗ
	}
	if (x - 1 >= 0 && x + 1 < n) {
		if (y + 1 < m) val1 = max(val1, p[x][y] + p[x-1][y] + p[x+1][y] + p[x][y+1]); //ㅏ
		if (y - 1 >= 0) val1 = max(val1, p[x][y] + p[x-1][y] + p[x+1][y] + p[x][y-1]); //ㅓ
	}
	return val1;
}
int t4(int x, int y) { //ㄴㄱ 형태
	val1 = -1;
	if (x - 1 >= 0 && x + 1 < n&&y + 1 < m) //ㄴㄱ 반전
		val1 = max(val1, p[x][y] + p[x][y + 1] + max(p[x - 1][y] + p[x + 1][y + 1], p[x + 1][y] + p[x - 1][y + 1]));
	if (y - 1 >= 0 && y + 1 < m&&x - 1 >= 0)// ㄱㄴ 반전
		val1 = max(val1, p[x][y] + p[x - 1][y] + max(p[x][y - 1] + p[x - 1][y + 1], p[x][y + 1] + p[x - 1][y - 1]));
	return val1;
}
int t5(int x, int y) {
	val1 = -1;
	if (x + 2 < n) {
		if (y + 1 < m) val1 = max(val1, p[x][y] + p[x + 1][y] + p[x + 2][y] + max(p[x + 2][y + 1], p[x][y + 1]));
		if (y - 1 >= 0) val1 = max(val1, p[x][y] + p[x + 1][y] + p[x + 2][y] + max(p[x + 2][y - 1], p[x][y - 1]));
	}
	if (y + 2 < m) {
		if (x + 1 < n) val1 = max(val1, p[x][y] + p[x][y + 1] + p[x][y + 2] + max(p[x+1][y],p[x+1][y+2]));
		if (x - 1 >= 0) val1 = max(val1, p[x][y] + p[x][y + 1] + p[x][y + 2] + max(p[x - 1][y], p[x - 1][y + 2]));
	}
	return val1;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m; i < n; i++)
		for (j = 0; j < m; cin >> p[i][j++]);
	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++) {
			ret = max(ret, t1(i, j));
			cout << i << " " << j << " " << ret << "z\n";
			ret = max(ret, t2(i, j));
			cout << i << " " << j << " " << ret << "z\n";
			ret = max(ret, t3(i, j));
			cout << i << " " << j << " " << ret << "z\n";
			ret = max(ret, t4(i, j));
			cout << i << " " << j << " " << ret << "z\n";
			ret = max(ret, t5(i, j));
			cout <<i<<" "<<j<<" "<< ret << "z\n";
		}
	cout << ret;
}
