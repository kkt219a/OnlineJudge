// 15596 - 정수 N개의 합
#include <vector>
long long sum(std::vector<int> &a) {
	long long ans = 0;
    for (std::vector<int>::iterator b = a.begin(); b != a.end(); b++)
		ans += *b;
	return ans;
}
