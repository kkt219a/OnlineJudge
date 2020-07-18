// JOSEPHUS - 조세푸스 문제 - 리스트 이용

#include<iostream>
#include<list>
using namespace std;
int c, n, k;
void jo(int num, int seq) {
	list<int> hyun, sal;
	for (int i = 1; i <= num; hyun.push_back(i++));
	list<int>::iterator kill = hyun.begin();
	while (num > 2) {
		kill=hyun.erase(kill);
		if (kill == hyun.end()) kill = hyun.begin();
		num--;
		for (int i = 0; i < k - 1; i++) {
			kill++;
			if (kill == hyun.end()) kill = hyun.begin();
		}	
	}
	cout << hyun.front() << " " << hyun.back() << "\n";
}
int main() {
	for (cin >> c; c--;) {
		cin >> n >> k;
		jo(n, k);
	}
}