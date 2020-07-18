// 15552 빠른 A+B
#include<iostream>
using namespace std;


int main(){
	cin.tie(NULL); //
	ios::sync_with_stdio(false); // 입출력 더빠른 편법?
	int T;
	cin>>T;
	while(T>0){
		int A,B;
		cin>>A>>B;
		cout<<A+B<<"\n";
		T--;
	}
}