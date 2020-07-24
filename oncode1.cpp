//1번 - 경연대회
#include <vector>
#include<algorithm>
using namespace std;
class Solution {
public:
	double solution(vector<int> scores) {
		double maxs = -1, avg, sum;
		int scoressize = (scores.size() / 2), i = 0, j, k = (scores.size() % 2 == 1);
		sort(scores.begin(), scores.end()); // score 정렬
		for (i = 0; i < scoressize; i++) { // scores 사이즈의 절반만큼
			for (sum = 0, j = i; j < scores.size(); sum += scores[j++]); // 지정 범위까지의 합
			sum /= (scores.size() - i); // 크기만큼 나누기
			maxs = max(maxs, sum); // 매번 최대값 갱신
			scores.pop_back(); // 뒤부분 짤라내기
		}
		if (k == 1) // 홀수면 마지막 한개를 비교
			maxs = max(maxs, double(scores[scoressize]));
		return (maxs == -1) ? double(scores[0]) : maxs; // maxs가 -1이면 사이즈가 1이라서 첫 원소 반환
	}
};
