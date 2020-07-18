//백준 - 나이순 정렬 - 10814
#include<iostream>
#include<string>
#include<algorithm>
using namespace std;
struct p {
	int a;
	string n;
	int s;
};
p b[100000];
int k, i;
bool c(p d, p e) {
	if (d.a == e.a)
		return d.s < e.s;
	return d.a < e.a;
}
int main(){
	for (cin >> k; i < k;b[i].s=i ,i++)
		cin >> b[i].a >> b[i].n;
	sort(b, b + k, c);
	for (i=0; i < k; i++)
		cout << b[i].a << " "<<b[i].n<<"\n";
}