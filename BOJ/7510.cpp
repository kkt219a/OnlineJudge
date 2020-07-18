// 7510-고급수학
#include<iostream>
#include<algorithm>
using namespace std;
int a[3], t, i;
int main() {
	cin >> t;
	for(i=1;i<=t;i++){
		cin >> a[0] >> a[1] >> a[2];
		sort(a, a + 3);
		cout << "Scenario #" << i << ":\n";
		if (a[2] * a[2] == a[1] * a[1] + a[0] * a[0])
			cout << "yes\n\n";
		else
			cout << "no\n\n";
	}
}