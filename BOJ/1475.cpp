//백준 - 1475 - 방번호
#include <stdio.h>
int main(){
	int N,a[7],i=0,max=0,d,e=0,f=0;
	scanf("%d",&N);
	if(N==0)
		max=1;
	while(N>0){
		a[i++]=N%10;
		N/=10;
	}
	while(e<10){
		d=0;
		for(int j=0;j<=i-1;j++){
			if(e==a[j]){
				if(e==6||e==9)
					f++;
				else 
					d++;
			}
		}
		if(max<d)
			max=d;
		e++;
	}
	if(f%2==0)
		f/=2;
	else 
		f=f/2+1;
	if(max<f)
		max=f;
	printf("%d",max);
}