// 6416-트리인가?
#include<iostream>
#include<set>
using namespace std;
set<int> a;
int b, c, d, t = 1;
int main() {
	for (;;) {
		cin >> b >> c;
		if (b == -1)
			break;
		if (b == 0) {
			if (d==0||(d + 1) == a.size())
				cout << "Case " << t << " is a tree.\n";
			else
				cout << "Case " << t << " is not a tree.\n";
			d = 0;
			t++;
			a.clear();
			continue;
		}
		d++;
		a.insert(b);
		a.insert(c);
	}
}