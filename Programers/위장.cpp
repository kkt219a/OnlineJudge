#include <string>
#include <vector>
#include<map>
using namespace std;
int solution(vector<vector<string>> clothes) {
	int answer = 1;
	map<string, int> m;
	for (int i = 0; i < clothes.size(); m[clothes[i][1]]++,i++);
	for (map<string, int>::iterator a = m.begin(); a != m.end(); answer *= (a->second + 1), a++);
	return answer-1;
}
