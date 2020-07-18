// 18245 - 이상한 나라의 암호
#include<iostream>
#include<string.h>
using namespace std;
char a[10002];
int main() {
	for (int i=2,j,k;i<102;i++,a[0]='\0') {
		cin >> a;
		if (a[1] == 'a')
			break;
		k = strlen(a);
		for (j = 0; j < k; j += i)
			cout << a[j];
		cout << "\n";
	}
}