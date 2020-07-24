//2번 - 행운의 번호
#include <string>
#include<vector>
using namespace std;
class Solution {
public:
	int solution(string s) {
		vector<int> v; // 각 숫자 저장 공간 
		int maxx = -1, i, j, sum1, sum2, k, l;
		if (s.length() == 1) return 0; // 길이1이면 0 반환
		for (i = 0; i < s.length(); v.push_back(s[i++] - '0')); // 숫자 저장
		for (i = 0; i < v.size() - 1; i++) { // 내부 크기만큼
			for (j = 0, l = i; j < (v.size() - i) / 2; j++) { // 범위 벗어나지 않게
				for (sum2 = sum1 = 0, k = 0; k <= j; k++) { // 매번 각 합을 구한다.
					sum1 += v[l + k];
					sum2 += v[l + k + j + 1];
				}
				if (sum1 == sum2) // 합이 같으면 길이 max 체크
					maxx = max(maxx, (j + 1) * 2);
			}
		}
		return (maxx == -1) ? 0 : maxx; // 길이 변화 없으면 없음으로 0 반환
	}
};
