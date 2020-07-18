// 18247 - 겨울왕국 티켓 예매
#include<iostream>
using namespace std;
int n, m,t;
int main() {
	for (cin >> t; t--;) {
		cin >> n >> m;
		if (n < 12||m<4)
			cout << "-1\n";
		else
			cout << 11 * m + 4<<"\n";
	}
}