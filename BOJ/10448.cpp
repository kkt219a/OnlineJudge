//백준 - 10448 - 유레카 이론
#include<iostream>
using namespace std;
int a[45], i = 1, j, k, t, v, f;
int main() {
	for (; i < 45; a[i] = a[i - 1] + i, i++);
	for (cin >> t; t--; cout << f << "\n", f = 0) {
		cin >> v;
		for (i = 1; i < 45; i++)
			for (j = 1; j < 45; j++)
				for (k =1; k < 45; k++)
					if (a[i] + a[j] + a[k] == v)
						f = 1;
	}
}