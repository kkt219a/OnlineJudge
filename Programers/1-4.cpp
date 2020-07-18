// 프로그래머스 레벨1

#include <string>
#include <vector>
#include<algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;
	vector<int> tmp;
	int a[3], j, k, l;
	for (int i = 0;i< commands.size(); i++) {
		for (j = 0; j < 3; j++)
			a[j]=commands[i][j]; // 2~5 1~4
		for (k = a[0] - 1; k < a[1]; k++)
			tmp.push_back(array[k]);
		sort(tmp.begin(), tmp.end());
		answer.push_back(tmp[a[2] - 1]);
		tmp.clear();
	}
	return answer;
}