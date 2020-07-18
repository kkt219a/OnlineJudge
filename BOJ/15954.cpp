//백준 - 인형들 - 15954(카카오 코드 페스티벌 2018 B)
#include<iostream>
#include<math.h>
using namespace std;
int n,k,a[500],i,j;
long double v,p,m=1000001; //v평균, p는 분산, 루트 분산이 표준편차
int main(){
	cin>>n>>k;
	for(;i<n;i++)
		cin>>a[i];
	for(;k<=n;k++){
		for(j=0;j<n&&j+k<=n;j++){
			p=0;
			v=0;
			for(i=0;i<k;i++)
				v+=a[j+i];
			v/=k;
			for(i=0;i<k;i++)
				p+=pow(a[j+i]-v,2);
			p=sqrt(p/k);
			if(p<m)
				m=p;
		}
	}
	cout.precision(11); //5,3하고 1,2,3,4,5 넣었을때 끝자리 3되는건 상관없는듯 예제출력은 2인데 나는3나와도 맞음 
	cout<<m;
}