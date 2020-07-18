//백준 - 16481 - 원 전문가 진우
#include<stdio.h>
double a,b,c;
int main(){
	scanf("%lf %lf %lf",&a,&b,&c);
	printf("%.9lf",1/(1/a+1/b+1/c));
}