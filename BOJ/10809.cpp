//백준 - 알파벳 찾기 - 10809
#include<iostream>
#include<string>
using namespace std;

string a;
int d[26];

int main()
{
	cin >> a;
	int b = 0;


	for (b = 1; b < a.size(); b++)
	{
		if (d[a[b] - 'a'] != 0)
		{
			continue;
		}
		d[a[b] - 'a'] = d[a[b] - 'a'] + b;
	}

	for (b = 0; b < 26; b++)
	{
		if (d[b] ==0)
		{
			d[b]--;
		}
	}

	d[a[0] - 'a'] = 0;

	for (b = 0; b<26; b++)
		cout << d[b] << " ";
}