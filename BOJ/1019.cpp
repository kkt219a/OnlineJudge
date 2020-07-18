// 1019 - 책 페이지 - 수학 , 재귀인데 어렵네.. 코테 출제문제라니 다시 보기

#include <iostream>
using namespace std;
int check[10], n, i;
void calc(int n, int ten) { //ten은 그 자리수 만큼, 예를들어 53427경우 3번째자리구하기위한 534가 529로 줄어들며 100개씩 더해지겠지
	while (n > 0) {
		check[n % 10] += ten;
		n /= 10;
	}
}
void solve(int A, int B, int ten) {
	while (A % 10 != 0 && A <= B) { calc(A, ten); A++; } //처음에만 한자리수는 1부터라서 예외적으로
	if (A > B) return;  // 한자리수면 끝내기
	while (B % 10 != 9 && B >= A) { calc(B, ten); B--; } //끝자리 9로 맞추려고 빼기,  빠지면서 계산
	long long cnt = (B / 10 - A / 10 + 1); // 개수 차+1만큼.
	for (int i = 0; i < 10; check[i] += cnt * ten, ++i); // 이것들도 각자리수만큼 ten을 곱해서 더해준다.
	solve(A / 10, B / 10, ten * 10); // 그다음 자리수 찾아서
}
int main() {
	cin >> n;
	solve(1, n, 1);
	for (; i < 10; cout << check[i++] << " ");
}