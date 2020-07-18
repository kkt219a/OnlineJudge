// 비트마스크 - 예제 - 극대 안정 집합

#include<iostream>
int n,ret; // 전체 범위, 극대안정집합의 수
int explode[1000]; // 인덱스 i와 같이 뒀을때 폭발하는 것들이 explode[i] 값, 자기자신은 1이겠지 i=0이면 1110 이렇게
bool stable(int k) { // k가 안정적인가, 
	for (int i = 0; i < n; i++)
		if ((k & (1 << i)) && (k&explode[i])) // i가 돌면서 좌항은 k안에 i번째 물질이 존재하고, 우항은 i번과 같이 두면 터지는 물질이 k에 있는지
			return 0; // 있다면 안정적이지 않다.
	return 1;
}

int check() { // 극대 안정 집합의 개수는?
	for (int i = 1; i < (1 << n); i++) {
		if (!stable(i)) //여기서 위험한건 다 걸렀기에
			continue;
		bool mss=false; // 하나만 더 추가되면 폭발하는지 여부, 여기까지 온건 안정이거나 극대 안정 집합
		for(int j=0;j<n;j++)
			if ((i&(1 << j)) == 0 && ((i&explode[j]) == 0)) {// j번 원소가 i에 없고, j와 같이뒀을 때 폭발하는게 없다면 그건 안정집합
				mss = true;
				break;
			}
		if (!mss) // mss가 false면 j와 같이 뒀을때 폭발하는게 있다는 것, 즉 극대 안정집합이다.
			ret++;
	}
	return ret;
}