//백준 - 알파벳 개수 - 10808
#include<iostream>
#include<string>
using namespace std;

string a;
int d[26];

int main()
{
	cin >> a;

	for (int b = 0; b < a.size(); b++)
		d[a[b] - 'a']++;
	for (int b = 0; b<26; b++)
		cout << d[b] << " ";
}