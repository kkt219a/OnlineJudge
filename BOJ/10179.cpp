//백준 - 10179 - 쿠폰
#include<stdio.h>
int n;
double b;
int main(){
	for(scanf("%d", &n);n--;scanf("%lf", &b),printf("$%.2lf\n", b*0.8));
}