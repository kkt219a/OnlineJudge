//백준 - 16482 - 한 점에서 만나라!
#include<stdio.h>
double a, b, c, d, e, f, g;
int main() {
	scanf("%lf %lf %lf %lf %lf", &a, &b, &c, &d, &e);
	f = (c-d) / d;
	g = (a-e) / e;
	printf("%.10lf", b*f*g/(f*g + 1));
}