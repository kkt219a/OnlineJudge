// FORTRESS - 요새 - 트리 - 존나 어렵다 다시

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int t, n, i, x[100], y[100], r[100];
struct treenode {
	vector<treenode*> child;
};
int maxx;
int preor(treenode* tr) {
	vector<int> height;
	for (int i = 0; i < (tr->child.size()); i++)
		height.push_back(preor(tr->child[i])); // 재귀
	if (height.empty()) return 0; // 비었으면 높이0임
	sort(height.begin(), height.end()); // 정렬해서
	if (height.size() >= 2)
		maxx=max(maxx, height[height.size() - 1] + height[height.size() - 2] + 2); // 2개 이상이면 가장 깊은 두녀석을 더하고,  루트 거치는+2 포함
	return height.back() + 1; // 1개면 루트까지니까 +1
}
int solve(treenode *root) {
	maxx = 0;
	int h = preor(root); // 가장 깊은 높이
	return max(maxx, h); 
}
int sqr(int v) { return v * v; } // 제곱 반환
int sqrdist(int a, int b) { return sqr(y[a] - y[b]) + sqr(x[a] - x[b]); } // x,y의 거리를 제곱으로 반환
bool enclose(int a, int b) { return r[a] > r[b] && sqrdist(a, b) < sqr(r[a] - r[b]); } //직접 포함관계인지 여부, 직접 포함이면 1, 아니면 0
bool ischild(int parent, int child) {
	if (!enclose(parent, child)) return 0; // 직접 포함관계가 아니면 false
	for (int i = 0; i < n; i++) // 그리고 부모 밑에 다른 애가 포함 되있고, 그 다른애가 자식으로 들어온애를 포함하면 얘는 직접 포함이 아니니 false 
		if (i != parent && i != child && enclose(parent, i) && enclose(i, child))
			return 0;
	return 1; // 이 과정을 다 지나면 참
}
treenode* getTree(int root) {
	treenode *tmp = new treenode();
	for (int i = 0; i < n; i++)
		if (ischild(root, i)) // i가 root성벽에 포함되면 트리 만들고 자손으로 만들면 됨
			tmp->child.push_back(getTree(i));
	return tmp;
}
int main() {
	for (cin >> t; t--;) {
		for (cin >> n, i = 0; i < n; i++)
			cin >> x[i]>> y[i]>> r[i];
		treenode *T = getTree(0); // 루트를 기반으로 트리 생성
		cout << solve(T) << endl;
	}
}