//4358 - 생태학 - 맵

#include<iostream>
#include<map>
#include<string>
using namespace std;
map<string, int> m;
string s;
int i;
int main() {
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	cout.precision(4);
	cout << fixed;
	for (; getline(cin, s); m.insert(make_pair(s, 1)).second ? m[s] : m[s]++, i++);
	for (map<string, int>::iterator it = m.begin(); it != m.end(); cout << it->first << " " << ((double)it->second / i) * 100 << "\n", it++);
}