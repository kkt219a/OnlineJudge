//9547 - 대통령 선거
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int t,c,v,i,j, d[101], a, ma, k[2], f=1, ans, ma2;
vector<int> h[101];
vector<int>::iterator z;
int main() {
	for (cin >> t; t--;ma=0,f=1,k[1]=0,ma2=0) {
		for (cin >> c >> v, i = 1; i <= v; i++) {
			for (j=0;j<c;j++){
				cin>>a;
				h[i].push_back(a);
				if(j==0) d[a]++;
			}
		}
		for(i=1; i<=c;i++){
			if(ma<d[i]){
				ma=d[i];
				j=i;
			}
		}
		for(k[0]=j,d[j]=0,i=1;i<=c;i++){
			if (ma2<d[i]){
				ma2=d[i];
				j=i;
			}
		}
		k[1]=j;
		if (ma>v/2)
			ans=k[0];
		else{
			for (f++,j=0,a=0, i = 1; i<=v;i++){
				for(z=h[i].begin();z!=h[i].end();z++){
					if(*z==k[0]){
						j++;
						break;
					}
					else if(*z==k[1]){
						a++;
						break;
					}
				}
			}
			if (j>a)
				ans=k[0];
			else
				ans=k[1];
		}
		cout<<ans<<" "<<f<<"\n";
		for (i=1; i<=100;d[i]=0,h[i].clear(),i++);
	}
}