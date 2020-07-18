// 18110 - solved.ac
#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
int n, a[300000], i;
double b, o;
int main() {
	for (cin >> n; i < n;cin >> a[i], i++);
	if(n!=0){
		sort(a, a + n);
		b = floor((n*0.15) + 0.5);
		for (i = b; i < n - b; o += (double)a[i], i++);
		o = floor((o / (n - 2 * b))+0.5);
	}
	cout << o;
}