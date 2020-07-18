//백준 - 1065 - 한수
//perfect
#include<iostream>
using namespace std;

int main(){
	int N,a[4],i,answer=0,b,c;
	bool ox;
	cin>>N;
	if(N<100)
		cout<<N;

	else{
		for(int j=100;j<=N;j++){
			b=j;
			ox=true;
			for(i=0;b>0;i++){
				a[i]=b%10;
				b/=10;
			}
			c=a[1]-a[0];
			for(i-=1;i>0;i--){
				if((a[i]-a[i-1])!=c)
					ox=false;
			}
			if(ox)
				answer++;
		}
		cout<<answer+99;
	}
}
