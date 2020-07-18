//백준 - 게임을 만든 동준이 - 2847
#include <cstdio>

int main() {
	int n;
	int cnt = 0;
	int arr[20001] = { 0, };
	scanf("%d",&n);
	for (int i = 0; i < n; i++) {
		scanf("%d",&arr[i]);
	}
	for (int i = n - 2; i >= 0; i--) {
		if (arr[i] >= arr[i + 1]) {
			cnt += arr[i] - arr[i + 1] + 1;
			arr[i] = arr[i] - (arr[i] - arr[i + 1] + 1);
		}
	}
	printf("%d",cnt);
}