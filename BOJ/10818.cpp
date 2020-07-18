//백준 - 최소, 최대 - 10818
#include <iostream>
#include<algorithm>
using namespace std;
int a,b,x=-1000001,n=1000001;
int main(){
	cin>>a;
	for(;a--;){
		cin>>b;
		x=max(b,x);
		n=min(b,n);
	}
	cout<<n<<" "<<x;
}