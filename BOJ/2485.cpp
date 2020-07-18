//백준 - 가로수 - 2485
#include<iostream>
using namespace std;

int n,a[100001],b,s;

int gcd(int a,int b){ //최대공약수 
    int n;
    if(a<b){
        n=a;
        a=b;
        b=n;
    }
    while(b!=0){
        n=a%b;
        a=b;
        b=n;
    }
    return a;

}
int main(){
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>a[i];

	
	for(int i=1;i<n-1;i++){ //1이면 예외로 처음꺼만 최대공약수 넣어주고 
		if(i==1)
			b=gcd(a[1]-a[0],a[2]-a[1]);
		else if(i>1)
			b=gcd(b,a[i+1]-a[i]); // 1보다크면 원래구했던 최대공약수와 뒤에 수들의 최대공약수로 다시구한다
	}
	
	for(int i=1;i<n;i++){
		s+=((a[i]-a[i-1])/b)-1; //사이에 들어가는 수를 구하기 위한 공식, 거리간격/최대공약수 - 1 
	}
	cout<<s;
	
}