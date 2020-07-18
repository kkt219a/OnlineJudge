//백준 - 1100 - 하얀칸 
//perfect

#include<iostream>
using namespace std;

int main(){
	bool chess[8][8];
	char a;
	int ans=0;
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			chess[i][j]=false;
			cin>>a;
			if((i%2==0&&j%2==0)||(i%2==1&&j%2==1))
				if(a=='F')
					chess[i][j]=true;
		}
	}
	for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
			if(chess[i][j]==true)
				ans++;
		}
	}
	cout<<ans;
}
