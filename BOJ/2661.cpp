//2661 - 좋은 수열 - 백트래킹 - 다시

#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
int n;
string ans;
void b(char c, int k) {
	if (k-1 == n) { // 출력 후 종료
		cout << ans;
		exit(0);
	}
	ans += c;
	for (int i = 1; i <= k / 2; i++) {
		string a = ans.substr(k - i * 2, i), b = ans.substr(k - i, i); 
		if (a.compare(b) == 0) { // 나쁜수열이면 더볼거도 없이 삭제하고 바로 리턴
			ans.pop_back();
			return;
		}
	}
	b('1', k+1); b('2', k+1); b('3', k+1);
	ans.pop_back(); // 다 본건 삭제
}
int main() {
	cin >> n;
	b('1',1); b('2', 1); b('3', 1);
}