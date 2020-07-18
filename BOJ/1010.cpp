//1010 다리놓기 (조합문제)

#include<iostream>
using namespace std;
long long c(int n, int r) {
	static long long mem[30][30] = { 0 };
	if (mem[n][r] > 0) // 만약 값이있다면 1이니까 한번 확인한거니 더 펼치지않고 값이 있는거로치고 올린다. 시간축소
		return mem[n][r];
	if (r == 0 || n == r) // 1이되는것들 , 2차원배열 기억해두면 다확인필요X
		return mem[n][r] = 1;
	return mem[n][r] = c(n - 1, r - 1) + c(n - 1, r);  //모든값 다 장
}


int main(){
	int t;
	int n,m,sum;
	cin>>t;
	while(t>0){
		cin>>n>>m; //mCn;
		cout<<c(m,n)<<"\n";
		t--;
	}
}