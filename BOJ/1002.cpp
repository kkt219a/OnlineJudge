// 1002 - 터렛
#include<iostream>
#include<stdio.h>
#include<math.h>
#include<algorithm>
using namespace std;
int x, y, x2, y2, t, a;
double d,r,r2;
int main() {
	for (cin >> t; t--; a = 0) {
        scanf("%d %d %lf %d %d %lf",&x,&y,&r,&x2,&y2,&r2);
		if (r > r2)
			swap(r, r2);
		d = sqrt((x2 - x)*(x2 - x) + (y2 - y)*(y2 - y));
		if (r == r2 && d == 0)
			a = -1;
		else if (r2 - r < d&&d < r + r2)
			a = 2;
		else if (d == r + r2 || d == r2 - r)
			a = 1;
		cout << a << "\n";
	}
}