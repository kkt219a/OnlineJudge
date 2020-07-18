// TRAVERSAL - 트리 순회 변경  - 다시

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int c, i, n, k;
vector<int> in, pre;
vector<int> slice(vector<int> v, int a, int b) { // a~b-1까지의 벡터를 만들어 반환
	return vector<int>(v.begin() + a, v.begin() + b);
}
void solve(vector<int> pree, vector<int> inn) {
	if (pree.empty()) // 루트가 없다는 것
		return;
	int p = pree.size(); //전위 크기
	int left= find(inn.begin(), inn.end(), pree[0]) - inn.begin(); // 좌 서브트리는 중위 탐색 결과에서 루트의 위치를 찾으면 됨
	int right = p - 1 - left; //오른쪽은 left와 루트를 뺀 것
	solve(slice(pree,1,left+1),slice(inn,0,left)); // 전위는 루트빼고left까지, 중위는 left-1까지
	solve(slice(pree, left + 1, p), slice(inn, left + 1, p));// 전위는 left+1부터 끝까지, 중위도 루트 다음부터 끝까지
	cout << pree[0] << " ";// 매번 루트는 출력, 
}
int main() {
	for (cin >> c; c--;) {
		for (cin >> n, i = 0; i < n; i++) {
			cin >> k;
			pre.push_back(k);
		}
		for (i = 0; i < n; i++) {
			cin >> k;
			in.push_back(k);
		}
		solve(pre,in);
		cout << "\n";
		in.clear();
		pre.clear();
	}
}