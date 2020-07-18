// 코드포스 - 621차 - a번

#include<iostream>
#include<algorithm>
using namespace std;
int t, n, d, a[100], i;
bool k;
int main() {
	for (cin >> t; t--;) {
		for (cin >> n >> d, i = 0; i < n; cin >> a[i++]); // 0번 더미로 다 옮겨야한다.
		for (i=1,k=1; i<n && d!=0&&k;i++) {
			while(a[i] != 0&&d!=0) { // 0이아니면 땡겨와 i만큼 
				if (d - i >= 0)
					d -= i;
				else {
					k = 0;
					break;
				}
				a[0]++; // 건초 1개 추가해주고
				a[i]--; // 건초 i번째에서 1개 빼주고
			}
		}
		cout << a[0] << "\n";
	}
}