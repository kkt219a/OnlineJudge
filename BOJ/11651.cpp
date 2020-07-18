//백준 - 11651 - 좌표 정렬하기 2
#include<iostream>
#include<algorithm>
using namespace std;
int n, i;
struct a{int x,y;};
a b[100000];
bool c(a d,a e){
	if(d.y==e.y)
		return d.x<e.x;
	return d.y<e.y;
}
int main(){
	cin>>n;
	for(;i<n;i++)
		cin>>b[i].x>>b[i].y;
	sort(b,b+n,c);
	for(i=0;i<n;i++)
		cout<<b[i].x<<" "<<b[i].y<<"\n";
}