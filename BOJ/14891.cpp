// 14891 - 톱니바퀴
#include<iostream>
using namespace std;
char a[5][9];
int k,i,b,c,j,tmp,p,ch[5],an[5];
void r(int n,int v){
	if(v==1){
		tmp=a[n][7];
		for(j=7;j>0;a[n][j]=a[n][j-1],j--);
		a[n][0]=tmp;
	}
	else{
		tmp=a[n][0];
		for(j=0;j<7;a[n][j]=a[n][j+1],j++);
		a[n][7]=tmp;
	}
}
int main(){
	for(cin>>a[1]>>a[2]>>a[3]>>a[4]>>k;i<k;i++){
		cin>>b>>c;
		for(p=2;p<5;p++)
			if(a[p][6]!=a[p-1][2])
				ch[p-1]=1;
		for(p=b-1;ch[p]!=0;an[p--]++);
		for(p =b;ch[p]!=0;an[++p]++);
		for(p =1;p<5;an[p]=ch[p]=0,p++){
			if(an[p]>=1||p==b){
				if(b%2==p%2)
					r(p,c);
				else
					r(p,-c);
			}
		}
	}
	cout<<(a[1][0]-'0')+(a[2][0]-'0')*2+(a[3][0]-'0')*4+(a[4][0]-'0')*8;
}
