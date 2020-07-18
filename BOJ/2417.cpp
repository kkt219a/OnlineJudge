//2417 - 정수 제곱근
#include<stdio.h>
#include<math.h>
double a;
int main() {
	scanf("%lf", &a);
	printf("%.0lf", ceil(sqrt(a)));
}