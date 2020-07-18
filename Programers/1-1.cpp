// 프로그래머스 레벨1
#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) { // arr1은 지도 1의 값들이 한 행마다, arr2는 지도 2의 값들이 한 행 마다, n은 행은 개수 
	vector<string> answer;
	string ans = "";
	int i, j, a[16], b[16];
	for (i = 0; i < n;ans="",i++) { // n행보다 작은동안 매 행 가져오기
			for (j=0; arr1[i] != 0 || arr2[i] != 0;j++) {
				a[j] = arr1[i] % 2;
				arr1[i] /= 2;
				b[j] = arr2[i] % 2;
				arr2[i] /= 2;
			}
			for (j--; j >= 0; j--) {
				if (a[j] == 0 && b[j] == 0)
					ans += " ";
				else
					ans += "#";
			}
			answer.push_back(ans);
	}
	return answer;
}