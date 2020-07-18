// 백준 - 1874 - 스택 수열
#include<iostream>
#include<stack>
using namespace std;
stack<int> s;
int a,b[100001],i,c[100001],j,k;
char d[999999];
int main(){
	cin>>a;
	for(;i<a;i++)
		cin>>b[i];
	for(i=1;i<=a;i++){
		s.push(i);
		d[k++]='+';
		while(!s.empty()&&s.top()==b[j]){
			c[j++]=s.top();
			s.pop();
			d[k++] = '-';
		}
	}
	for(i=0,j=0;i<a;i++)
		if(b[i]==c[i])
	j++;
	if(j==a)
		for(i=0;i<k;i++)
			cout<<d[i]<<"\n";
	else
		cout<<"NO";
}