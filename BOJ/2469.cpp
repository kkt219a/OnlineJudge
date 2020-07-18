//2469 - 사다리 타기 
#include<iostream>
using namespace std;
int n, k, i, j, l, o, q, t, check;
char p[27], m[1000][27];
int main() {
	for (cin>>k>>n>>p,i=0;i<n;cin>>m[i],i++);
	for (i = 0; i < k; i++){
		for (l=i, j=n-1; j>=0; j--) {
			if(m[j][l] == '?'||m[j][l-1]=='?') {t=j;break;}
			else if(m[j][l - 1]=='-') l--;
			else if(m[j][l]=='-') l++;
		}
		for (q=p[i]-65, o=0; o<t; o++) {
			if(m[o][q - 1]=='-') q--;
			else if(m[o][q]=='-') q++;
		}
		if(j==-1) continue;
		else if(l-q==-1) m[t][q - 1]='-';
		else if(l-q==1) m[t][l - 1]='-';
		else if(l-q==0) m[t][l]='*';
		else{ check=1; break; }
	}
	if(check)
		for(i=0;i<k-1;i++)
			cout << "x";
	else
		for(i=0;i<k-1;i++){
			if (m[t][i]=='?') m[t][i]='*';
			cout<<m[t][i];
		}
}