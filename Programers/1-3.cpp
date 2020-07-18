// 프로그래머스 레벨1 
#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
	string answer = "김서방은 ", inp = "Kim";
	vector<string>::iterator v;
	int i = 0;
	for (v = seoul.begin(); v != seoul.end(); v++,i++) {
		if (inp.compare(*v) == 0)
			break;
	}
	answer += to_string(i);
	answer += "에 있다";
	return answer;
}