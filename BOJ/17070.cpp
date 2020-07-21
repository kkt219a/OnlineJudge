// 17070 - 파이프 옮기기 1 - BackTracking
#include<iostream>
using namespace std;
int xy[17][17], n, i = 1, j, sum;
void sol(int x1, int y1, int x2, int y2) {
	//범위 벗어나거나 파이프가 벽이거나, 대각선인데 2*2가 성립되지 않는 경우
	if (x1 <= 0 || x1 > n || x2 <= 0 || x2 > n || y1 <= 0 || y1 > n || y2 <= 0 || y2 > n|| xy[x1][y1] || xy[x2][y2]|| ((x2 - x1 == y2 - y1) && (xy[x1 + 1][y1] || xy[x1][y1 + 1])))
		return;
	else if (x2 == n && y2 == n) //경우의 수 하나 추가
		sum++;
	else if (x2 - x1 == y2 - y1) { //대각선이면
		sol(x1 + 1, y1 + 1, x2 + 1, y2 + 1); // 대각선으로 밀기
		sol(x1 + 1, y1 + 1, x2, y2 + 1); // 밀고 위로 45' , 가로 만들기
		sol(x1 + 1, y1 + 1, x2 + 1, y2); // 밀고 아래로 45', 세로 만들기
	}
	else if (x2 - x1 == 1) { //세로라면
		sol(x1 + 1, y1, x2 + 1, y2); //밑으로 밀기
		sol(x1 + 1, y1, x2 + 1, y2 + 1); // 밀고 위로 45'
	}
	else if (y2 - y1 == 1) { //가로라면
		sol(x1, y1 + 1, x2, y2 + 1); // 오른쪽으로 밀기
		sol(x1, y1 + 1, x2 + 1, y2 + 1); //밀고 아래로 45'
	}
}
int main() {
	for (cin >> n; i <= n; i++)
		for (j = 1; j <= n; cin >> xy[i][j++]);
	sol(1, 1, 1, 2);
	cout << sum;
}