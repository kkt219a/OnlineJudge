// 2748 - 피보나치 수2
#include <iostream>
long long f(int n){
    long long i,a=0,b=1,c;
    if(n==0)return a;
    else if(n==1)return b;
    else if(n>1){
        for(i=2;i<n+1;i++){
            c=a+b;a=b;b=c;
        }
        return c;
    }
}
int main(){
    int n;
    std::cin >> n;
    std::cout<<f(n);
}
