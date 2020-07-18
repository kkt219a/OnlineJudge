//백준 - 11504 - 돌려 돌려 돌림판
#include<iostream>
#include<list>
#include<math.h>
using namespace std;
int t,n,m,x[9],y[9];// 테스트케이스, n등분 , m은 x와y의 자리수 , 자리수에맞게 최대9자리 수까지 저장
int i,j; // 반복문 돌리기 전용 
int s,ans,l,o; //s는 매번 나오는 합, ans는 정답, l은 10^m, k는 q.front(),o는 증가를 위해 근데 s는 입력값으로도 잠깐 쓰인다.
int xx,yy; //x합, y합
int main(){
	list<int> q;
	list<int>::iterator it;
	cin>>t;
	for(;t>0;t--){
		cin>>n>>m;
		ans=0;
		for(i=0;i<m;i++)
			cin>>x[i];
		for(i=0;i<m;i++)
			cin>>y[i];
		for(i=0;i<n;i++){
			cin>>s;
			q.push_back(s);
		}
		for(i=0;i<n;i++){ // n-1개의 원하는 숫자 뽑아내기
			l=pow(10,m-1),s=0,xx=0,yy=0;
			
			for(it=q.begin(),o=0;o<i;it++,o++)
				if(it==q.end())
					it=q.begin();
			
			
			for(j=0;j<m;j++,l/=10,it++){ // m자리수만큼 큐에서 빼고 넣고 해주기
				if(it==q.end())
					it=q.begin();
				s+=(*it)*l;
				xx+=x[j]*l;
				yy+=y[j]*l;
			}
			if(xx<=s&&s<=yy)
				ans++;
		}
		cout<<ans<<"\n";
		q.clear();
	}
}