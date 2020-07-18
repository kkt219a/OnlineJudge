//백준 - 5086 - 배수와 약수
#include<iostream>
using namespace std;
int a, b;
int main() {
	for(cin >> a >> b;a!=b; cin >> a >> b){
		if (b % a == 0)
			cout << "factor\n";
		else if (a % b == 0)
			cout << "multiple\n";
		else
			cout << "neither\n";
	}
}