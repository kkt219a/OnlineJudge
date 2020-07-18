//백준 - 1로만들기 - 1463
//rerere
#include<iostream>
using namespace std;
int n,c;

int main(){
	cin>>n;
	while(n!=1){ //n이 1이 아닌동안. 1이되면 탈출
		if(n%3==0){
			n/=3;
			cout<<n<<" n%3==0"<<"\n";
			c++;
		}
		else if(n%2==0){ 
			if((n/2)%2!=1){ 
				n/=2;
				cout<<n<<" n/2%2==0"<<"\n";
				c++;
			}
			else{
				n-=1;
				cout<<n<<" n/2%2==1"<<"\n";
				c++;
			}
		}
		else{
			n-=1;
			cout<<n<<" 아무것도 안나눠 질때"<<"\n";
			c++;
		}
	}
	cout<<c;
}