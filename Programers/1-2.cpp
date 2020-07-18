// 프로그래머스 레벨1
#include <string>
#include<math.h>

using namespace std;

int solution(string dartResult) {
	int answer = 0, i, ans[3] = { 0,0,0 }, j, gop = 0;
	int arr[3][3] = { {0,0,1},{0,0,1},{0,0,1} }; // 3개의 점수에서 각각 점수/sdt를 1,2,3으로 저장/ *=2, #=-1,바로 넘어가면 1
	for (i = 0,j=0; j<3;j++) {
		if (dartResult[i] > 47 && dartResult[i] < 58) {
			if (dartResult[i + 1] == '0') {
				arr[j][0] = (dartResult[i] - 48) * 10;
				i++;
			}
			arr[j][0] = (dartResult[i] - 48);
		}
		i++;
		if (dartResult[i] == 'S')
			arr[j][1] = 1;
		else if (dartResult[i] == 'D')
			arr[j][1] = 2;
		else
			arr[j][1] = 3;
		i++;
		if (dartResult[i]=='#') {
			arr[j][2] = -1;
			i++;
		}
		else if (dartResult[i] == '*') {
			arr[j][2] = 2;
			if (j != 0)
				arr[j - 1][2] *= 2;
			i++;
		}
	}
	for (j = 0; j < 3; j++)
		answer += pow(arr[j][0], arr[j][1])*arr[j][2];
	return answer;
}