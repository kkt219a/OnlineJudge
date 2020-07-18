// NERD2 - 너드인가, 너드가 아닌가? 2 - 맵

#include<iostream>
#include<map>
using namespace std;
map<int, int> m; // m[x]=y
int c, n, i, p, q;
//새 점이 기존의 다른 점들에 지배당하는지 점검
bool dominate(int x, int y) {
	map<int, int>::iterator it = m.lower_bound(x); // x보다 오른쪽 중 가장 왼쪽에 있는 점 찾기
	if (it == m.end()) return 0;
	return y < (it->second); // y값이 x의 오른쪽중 가장 왼쪽이 있는 y값과 비교했을 때, y가 더 낮으면 지배 당함.
}
//새 x,y에 지배 당하는 친구가 있으면 삭제하기
void remo(int x, int y) {
	map<int, int>::iterator it = m.lower_bound(x);
	if (it == m.begin()) return; // x보다 작은게 없다
	it--; // it는 x가 들어오면 x바로 오른쪽 애니까 한칸 왼쪽으로
	while (1) {
		if (it->second > y) break; //y값 더 크면 얘랑 상관없으니 끝
		if (it == m.begin()) { // 첫번째면 얘만 삭제하면 끝
			m.erase(it);
			break;
		}
		else { // 첫번째아니면 삭제하고 it계속 줄이기
			map<int, int>::iterator jt = it; //jt는 it를 가리킨다
			jt--; // jt는 it앞을 가리키고
			m.erase(it); // it는 삭제 되고나서 
			it = jt; // it는 jt가 가리키는걸 가리킨다.
			//원래 했던대로 jt로 삭제하면 it가 삭제되는것과 같아서 두 값 다 삭제된다!
		}
	}
}
//추가후의 과정들, 일단은 너드인 애들 반환
int registered(int x, int y) {
	if (dominate(x, y)) return m.size(); // 지배 되는거면 바로 버리기
	remo(x, y); // x,y가 지배하는것들 삭제
	m[x] = y; // x,y값 넣어주고 값 반환
	return m.size();
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> c; c--;) {
		int sum = 0;
		for (cin >> n, i = 0; i < n; i++) {
			cin >> p >> q;
			sum+=registered(p, q);
		}
		cout<<sum<<"\n";
		m.clear();
	}
}