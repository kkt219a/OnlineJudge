// codeground  - 13 - 균일수
//미해결 ????

#include <iostream>
using namespace std;

int Answer;

int main()
{
	int T,*a,b,n; //a는 자리수에 들어갈 숫자 즉 몫이된다, b는 특정수에대해서 몇진수로 나눠볼 것인지, n은 본래의 숫자
	int m; //m은 나머지값!
	int c; //c는 증감을 위한값
	bool inc;
	
	cin >> T;
	
	for(int i=0;i<T;i++)
	{
		cin>>n;
		Answer = 0;
		
		for(int j=2;j<n+2;j++){
			b=j;
			c=0;
			inc=1;
			while(b<=n){ // n을 나눌수있는 최대 제곱수를 찾기 위해서 
				b*=j; 
				c++;
			}
			b/=j;
			m=n;
			a=(int*)malloc(sizeof(int)*(c+1)); // 2의2승 2의1승 1x 니까 2승일떄 3자리가 필요함
			
			for(int k=0;m!=0&&k<c+1;k++){
				a[k]=m/b;
				if(m/b!=0)
					m%=b;
				b/=j;
			}
			
			for(int k=0;k<c+1;k++){
				if(a[0]!=a[k]){
					inc=0;
					break;
				}
			}
			
			if(inc==1){
				Answer=j;
				break;
			}
		}

		
		cout << "Case #" << i+1 << endl;
		cout << Answer << endl;
	}
	return 0;
}

//				cout<<a[k]<<"  "<<j<<"  "<<m<<"  "<<b<<endl;
/*