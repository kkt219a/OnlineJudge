// 프로그래머스 레벨2

#include <vector>
#include <iostream>
using namespace std;
int arr[3000];
int solution(vector<int> nums) {
	int answer = 0, i, j, k;
	//에라토스테네스의 체 구현해서 소수 만들어주기
	for (i = 2; i < 1500; i++) {
		if (arr[i]) continue;
		for (j = 2; i*j < 3000; arr[i*j] = 1, j++);
	}
	for (i = 0; i < nums.size() - 2; i++) {
		for (j = i + 1; j < nums.size() - 1; j++) {
			for (k = i + 2; k < nums.size(); k++) {
				if (!arr[nums[i] + nums[j] + nums[k]])
					answer++;
			}
		}
	}

	return answer;
}
