//2580 - 스도쿠 - 백트래킹 - 다시

#include<iostream>
#include<algorithm>
using namespace std;
int sdo[9][9], i, j;
bool row[9][10], col[9][10], sq[9][10];
void back(int n) {
	if (n == 81) {//카운트, 81개 다채우면 출력후 바로 종료
		for (i = 0; i < 9; cout << "\n", i++)
			for (j = 0; j < 9; cout << sdo[i][j++] << " ");
		exit(0);
	}
	int x = n / 9, y = n % 9;
	if (sdo[x][y]) back(n + 1); // 값이 있으면 그냥 넘겨주기 
	else
		for (int i = 1; i <= 9; i++)
			if (!row[x][i] && !col[y][i] && !sq[(x/3)*3+y/3][i]) { //이 숫자 i가 특정 행과 열, 3*3 정사각형에 없으면 일단 얘라고 치고 넣기
				row[x][i] = col[y][i] = sq[(x / 3) * 3 + y / 3][i] = 1;
				sdo[x][y] = i;
				back(n + 1);
				sdo[x][y] = 0;
				row[x][i] = col[y][i] = sq[(x / 3) * 3 + y / 3][i] = 0;
			}
}

int main() {
	for (; i < 9; i++)
		for (j = 0; j < 9; j++) {
			cin >> sdo[i][j];
			if (sdo[i][j]) //값 있으면 행,렬,사각형 처리
				sq[(i/3)*3+j/3][sdo[i][j]]=col[j][sdo[i][j]]=row[i][sdo[i][j]] = 1; //i행에 sdo값이 있고, j열에 sdo값이 있고, 몇번째 상자인지
		}
	back(0);
}