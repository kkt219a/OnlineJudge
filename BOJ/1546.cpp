// 1546 평균
#include<iostream>
#include<stdlib.h>
using namespace std;

int main(){
	int N,*a,max=0;
	double sum=0;
	cin>>N; //과목갯수
	a=(int*)malloc(sizeof(int)*N); //과목점수 
	//a[i]/max*100
	cout<<fixed;
    cout.precision(2);
	for(int i=0;i<N;i++){
		cin>>a[i];
		if(max<a[i])
			max=a[i];
	}
	for(int i=0;i<N;i++){
		sum+=(double)a[i];
	}
	cout<<sum/max*100/N;
	
	
}