//백준 - 최댓값 - 2566
#include<iostream>
#include<algorithm>
using namespace std;
int a[9][9],i,j,m,x,y;

int main(){
	for(i=0;i<9;i++){
		for(j=0;j<9;j++){
			cin>>a[i][j];
			if(max(m,a[i][j])==a[i][j]){
				x=i;
				y=j;
				m=max(m,a[i][j]);
			}
		}
	}
	
	cout<<m<<"\n"<<x+1<<" "<<y+1;
	
}