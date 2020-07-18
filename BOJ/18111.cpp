// 18111 - 마인크래프트
#include<iostream>
#include<algorithm>
#define keu 9223372036854775807
using namespace std;
int i, j, map[500][500], h;
long long s1, s3 = keu, s4 = -keu, s, n, m, b, b2;
int main() {
	for (cin >> n >> m >> b; i < n; i++)
		for (j = 0; j < m; cin >> map[i][j], s+=map[i][j], j++);
	for (b += s % (n*m), s -= s % (n*m); s / (n*m) < 257&& b2 <= b;) {
		for (s1=0,i = 0; i < n; i++)
			for (j = 0; j < m; j++) {
				h = map[i][j] - s / (n*m);
				if (h < 0)
					s1 += (-h);
				else if (h> 0)
					s1 += 2*h;
			}
		if (s1 < s3) {
			s3 = s1;
			s4 = s / (m*n);
		}
		else if(s1==s3)
			s4 = max(s4, s / (m*n));
		if (b < n*m)
			break;
		else {
			b2 += n * m;
			s += n * m;
		}
	}
	cout << s3 << " " << s4;
}