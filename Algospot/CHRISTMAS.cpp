// CHRISTMAS - 크리스마스 선물 - 부분합 응용

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int c, n, k, i, mod = 20091101, inp;
int one(vector<int> psum, int p) { // 부분합, 인형의 개수
	int ret = 0;
	vector<long long> count(p, 0);
	for (int i = 0; i < psum.size(); i++)
		count[psum[i]]++; // 나머지가 같은걸 센다
	for (int i = 0; i < p; i++)
		if (count[i] > 1) // 1개 이상이라면 count[i] C 2 = count[i]*(count[i]-1)/2
			ret = (ret + ((count[i] * (count[i]-1)) / 2)) % mod;
	return ret;
}
int two(vector<int> psum, int p) { // 여러번 주문 할건데 인형 상자가 두개 이상 중복 안 되게 주문의 최대 값, p는 아이들 수
	vector<int> ret(psum.size(), 0); // ret[i] = 첫 상자부터 i번째 상자까지 고려했을 때 살수 있는 최대 수
	vector<int> prev(p, -1); // prev[s] = psum[]이 s였던 마지막 위치
	
	for (int i = 0; i < psum.size(); i++) {
		// i번째 상자를 아예 고려 안 하면 이전과 구매 횟수는 똑같다 이걸 미리 입력
		if (i != 0) ret[i] = ret[i - 1];
		else ret[i] = 0;
		int loc = prev[psum[i]]; // i번째 부분합이 만약 이전에 있었는지 조사
		if (loc != -1) ret[i] = max(ret[i], ret[loc] + 1); // 이전에 이 기록이 있었으면 그때의 구매 횟수에서 1을 더해준다.
		//만약 중간중간의 구매횟수를 알고 싶으면 loc~i번째까지 싹 다 1을 더해주면 되겠지, 근데 지금은 마지막만 알면 되니까 필요 없음
		prev[psum[i]] = i; //prev[]에 현재 위치를 기록, 본적이 있든 없든 현재가 제일 마지막이니 기록해둔다.
	}
	return ret.back(); // 마지막에는 최대 구매 횟수가 나온다. 
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> c; c--;) {
		cin >> n >> k;
		vector<int> dp(n + 1);
		dp[0] = 0;
		for (i=1; i <= n; i++) { 
			cin >> inp;
			dp[i]=(dp[i - 1] + inp) % k; //각 부분합을 k로 나눈 나머지
		}
		cout << one(dp, k) << " " << two(dp, k) << "\n";
	}
}