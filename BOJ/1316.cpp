//1316 - 그룹단어체커

#include<iostream>
#include<string.h>
char b[102], c;
int n, i, a[26], ch=1, sum;
int main() {
	std::cin >> n;
	for (; n--;ch=1) {
		std::cin >> b;
		for (i = 0; i < strlen(b); i++) { 
			if (a[b[i] - 97] == 0) {
				a[b[i] - 97] = 1;
				c = b[i];
				for (; b[i] == c; i++);
				i--;
			}
			else {
				ch = 0;
				break;
			}
		}
		sum += ch;
		b[0] = '\0';
		for (i = 0; i < 26; a[i] = 0, i++);
	}
	std::cout << sum;
}
