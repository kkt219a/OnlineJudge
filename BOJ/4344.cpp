// 4344 평균은 넘겠지

#include<iostream>
#include<stdlib.h>
using namespace std;

int main(){
	int T;
	cin>>T;
	cout<<fixed;
    cout.precision(3);
	while(T>0){
		int n,*a,sum=0,cnt=0;
		double avg;
		cin>>n;
		
		a=(int*)malloc(sizeof(int)*n);
		for(int i=0;i<n;i++){
			cin>>a[i];
			sum+=a[i];
		}
		avg=(double)sum/n;
		for(int i=0;i<n;i++){
			if((double)a[i]>avg)
				cnt++;
		}
		
		cout<<(double)cnt/n*100<<"%\n";
		T--;
	}


}