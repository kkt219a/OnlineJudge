//백준 - 11650 - 좌표 정렬하기
#include<iostream>
#include<algorithm>
using namespace std;
int n, i;
struct a{int x,y;};
a b[100000];
bool c(a d,a e){
	if(d.x==e.x)
		return d.y<e.y;
	return d.x<e.x;
}
int main(){
	cin>>n;
	for(;i<n;i++)
		cin>>b[i].x>>b[i].y;
	sort(b,b+n,c);
	for(i=0;i<n;i++)
		cout<<b[i].x<<" "<<b[i].y<<"\n";
}