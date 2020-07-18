// 1039 - 게임 - 오래도 걸렸다.... BFS 다싱?

#include<iostream>
#include<string>
#include<queue>
#include<algorithm>
using namespace std;
int k, i, j, m, visit[1000000], siz, p, ans;
string n, tmp;
queue<string> q;
void bfs() {
	for (q.push(n); i <= k; i++) { // 한 깊이씩 파고들기
		for (j = 0; j < 1000000; visit[j++] = 0); // 매라인에서만 동일한거 체크해야하니까 사이클마다 초기화
		//여기서 해야할 일은 이 라인에 있던 것들의 뿌리 파헤치기
		for (siz = q.size(), p = 0; p < siz;p++) { // tmp에 글자 하나씩 받아와 그 라인 만큼
			tmp = q.front();
			if(i==k)
				ans = max(ans, atoi(tmp.c_str()));
			for (j = 0; j < tmp.length(); j++)
				for (m = j + 1; m < tmp.length(); m++) {
					swap(tmp[m], tmp[j]);
					if (tmp[0] != '0' && !visit[atoi(tmp.c_str())]) { visit[atoi(tmp.c_str())] = 1; q.push(tmp); }
					swap(tmp[m], tmp[j]);
				}
			q.pop();
			if (q.empty()) break;
		}
	}
}
int main() {
	cin >> n >> k;
	if (n.length()==7)
		cout << "1000000";
	else {
		bfs();
		if (i!=k+1||n.length()==1||(n.length()==2&&atoi(n.c_str())%10==0))
			cout << "-1";
		else
			cout << ans;
	}
}