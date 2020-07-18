//백준 - 색종이 - 2563
// Re
#include<iostream> 
using namespace std;
int a[101][101],n,b,c,s,i,j,k;
int main(){
	cin>>n;
	for(;i<n;i++){
		cin>>b>>c; //좌표 범위 입력
		for(j=0;j<10;j++) 
			for(k=0;k<10;k++)
				a[b+j][c+k]++; // 그 좌표부터 +9(배열이니까 10이아님)까지 전부다 있는거로 관주하고 전부다 이걸로 다채운다.
	}
	
	for(i=0;i<101;i++)
		for(j=0;j<101;j++)
			if(a[i][j]>0){
				s++; //s는 넓이의 합이다 이부분이 겹쳐있거나 그냥 존재하는거 전부다 1아니면 n개가 겹친다면 n이니까 비어있지만 않으면 모든걸 다 더한다.
			}
	cout<<s;
}